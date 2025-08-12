
-- SUB QUERY
-- 하위질의/ 부속질의
-- 중첩 SQL 문 사용
-- 하위 질의 수행 후 반환 릴레이션에 대해 다른 질의 릴레이션으로 포함시킴
-- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공

-- 조인 vs 서브쿼리
-- 1 조인: 여러 데이터를 모두 합쳐 연산
--        BOOK JOIN PUBLISHER-> 18 * 3=> 54행 반환 후 조건에 맞는 튜플 검색 
--        카티션 곱 연산 + SELECT 연산
-- 2 서브쿼리: 필요한 데이터만 찾아 제공 
--           경우에 따라 join 성능이 더 좋은 경우도 있음 대용량 데이터에서 성능 저하 가능성 존재 
--           구성: 메인쿼리 (서브쿼리)-> 서브쿼리 먼저 진행 후 메인쿼리 진행

-- 메시 (client) 고객이 주문한 도서의 총 수량 (bookSale)-> bookSale 에는 clientNo 만 있음
SELECT SUM(BSQTY)
FROM BOOKSALE
WHERE CLIENTNAME = '1';

SELECT CLIENTNO
FROM CLIENT
WHERE CLIENTNAME='메시';

-- 메인쿼리
SELECT SUM(BSQTY)
FROM BOOKSALE
WHERE CLIENTNAME = (-- 서브쿼리
                    SELECT CLIENTNO
                    FROM CLIENT
                    WHERE CLIENTNAME='메시'
                    );
                    
-- 서브쿼리 WHERE 절에서 사용할 경우
-- 서브쿼리 질의 결과가 단일행인 경우: 단일행 서브쿼리-> 관계 연산자 사용
-- 비교 연산자 사용: > < >= <= = !=

-- 서브쿼리 질의 결과가 다중행인 경우: 다중행 서브쿼리-> IN/ANY/ALL/EXISTS 연산자 사용
-- IN/NOT IN: 집합 값의 유무
-- EXISTS/NOT EXISTS: 값의 존재 유무
-- ALL/ANY

-- 고객 호날두의 주문수량 및 주문날짜 조회
-- 1 CLIENT 테이블에서 ‘호날두’ 의 clientNo 검색
-- 2 BOOKSALE 테이블에서 1에서 찾은 clientNo 에 해당하는 주문일, 주문수량 조회
SELECT BSDATE, BSQTY
FROM BOOKSALE BS
    INNER JOIN CLIENT C ON C.CLIENTNO = BS.CLIENTNO
WHERE CLIENTNAME = '호날두';

SELECT BSDATE, BSQTY
FROM BOOKSALE
WHERE CLIENTNO=(
                SELECT CLIENTNO
                FROM CLIENT
                WHERE CLIENTNAME = '호날두'
                );
                
-- 고객 호날두가 주문한 총 주문수량
SELECT SUM(BSQTY) AS "총 주문수량"
FROM BOOKSALE
WHERE CLIENTNO=(
                SELECT CLIENTNO
                FROM CLIENT
                WHERE CLIENTNAME = '호날두'
                );
                
-- 가장 비싼 도서의 도서명과 가격 출력
SELECT BOOKNAME, BOOKPRICE
FROM BOOK
WHERE BOOKPRICE = (
                   SELECT MAX(BOOKPRICE)
                   FROM BOOK
                   );

-- 서점 도서의 평균 가격을 초과하는 도서명, 도서가격 조회
SELECT BOOKNAME, BOOKPRICE
FROM BOOK
WHERE BOOKPRICE > (
                   SELECT AVG(BOOKPRICE)
                   FROM BOOK
                   );
                   
--------------------------------------------------------------------------------

/*
SELECT CLIENTNAME, CLIENTADDRESS
FROM CLIENT
WHERE CLIENTNO IN ('1', '3', '7' ...);
*/

-- 도서를 구매한적이 있는 고객의 고객명, 지역 조회
-- 1 BOOKSALE의 고객 정보(CLIENTNO) 조회
-- 2 CLIENT 테이블에서 조회된 CLIENTNO에 해당되는 고객 레코드 추출후 필요 컬럼 추출
SELECT CLIENTNAME, CLIENTADDRESS
FROM CLIENT
WHERE CLIENTNO IN (
                  SELECT CLIENTNO
                  FROM BOOKSALE
                  );
-- 비교연산자는 하나의 값만 비교 수행 가능
-- 주문한 고객의 고객 번호는 여러개의 값 반환->

-- 도서를 한번도 구매한적 없는 고객의 번호와 고객명 조회
SELECT CLIENTNAME, CLIENTADDRESS
FROM CLIENT
WHERE CLIENTNO NOT IN (
                  SELECT CLIENTNO
                  FROM BOOKSALE
                  );

--------------------------------------------------------------------------------

-- Nested SUB QUERY
-- 도서명이 ‘안드로이드 프로그래밍’인 도서를 구매한 고객의 고객명
-- 1 ‘안드로이드 프로그래밍’ 도서의 도서번호 확인
SELECT BOOKNO FROM BOOK WHERE BOOKNAME = '안드로이드 프로그래밍';
-- 2 bookNo 1004번인 도서를 주문한 고객의 고개번호 확인
SELECT CLIENTNO FROM BOOKSALE WHERE BOOKNO = '1004';
-- 3 고객 번호가 78번인 고객들의 고객명 조회
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO = '7' OR CLIENTNO = '8';

-- combine
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO IN (
                   SELECT CLIENTNO 
                   FROM BOOKSALE
                   WHERE BOOKNO = (
                                   SELECT BOOKNO 
                                   FROM BOOK 
                                   WHERE BOOKNAME = '안드로이드 프로그래밍'
                                   ));

-- 단일행 서브쿼리의 조건 연산으로 in 사용해도 상관없음
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO IN (
                   SELECT CLIENTNO 
                   FROM BOOKSALE
                   WHERE BOOKNO IN (
                                    SELECT BOOKNO 
                                    FROM BOOK 
                                    WHERE BOOKNAME = '안드로이드 프로그래밍'
                                    ));

-- 서브쿼리를 사용해도 서브쿼리의 결과는 조건값이므로
-- WHERE 절 뒤에 필요한 질의 추가 가능
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO IN (
                   SELECT CLIENTNO 
                   FROM BOOKSALE
                   WHERE BOOKNO IN (
                                    SELECT BOOKNO 
                                    FROM BOOK 
                                    WHERE BOOKNAME = '안드로이드 프로그래밍'
                                    ))
ORDER BY CLIENTNAME;

--------------------------------------------------------------------------------

-- 다중행 서브쿼리 연산자 EXISTS/NOT EXISTS
-- EXISTS: 서브쿼리의 결과가 행을 반환하면 참이 되는 연산자
--         참조 무결성에 대한 조건 검사를 병행 해야함
--         —> 상관 서브쿼리 연산 가능: 서브쿼리에서 메인쿼리 컬럼 사용

-- 도서를 구매한적이 있는 고객의 고객명
SELECT CLIENTNO, CLIENTNAME
FROM CLIENT
WHERE EXISTS (
              SELECT CLIENTNO
              FROM BOOKSALE
              WHERE CLIENT.CLIENTNO = BOOKSALE.CLIENTNO
              );

-- 도서를 한번도 주문한적 없는 고객
-- 서브쿼리의 조건에 해당되는 행이 없으면 true 반환
SELECT CLIENTNO, CLIENTNAME
FROM CLIENT
WHERE NOT EXISTS (
              SELECT CLIENTNO
              FROM BOOKSALE
              WHERE CLIENT.CLIENTNO = BOOKSALE.CLIENTNO
              );
-- 위 예시는 IN/NOT IN 사용 예시와 동일한 결과가 나옴

-- null 값을 포함하고 있는 컬럼에서는 차이 있음
-- IN vs EXISTS

-- 서브쿼리의 SELECT 된 칼럼의 값이 null 포함 여부에 따라 메인 쿼리의 결과가 달라질 수 있음

-- CLIENT 테이블의 clientHobby 칼럼은 null 값 포함함
SELECT CLIENTHOBBY FROM CLIENT;

-- IN: 서브쿼리 결과에 null 값 포함 xx
-- 취미 정보가 입력된 null 값이 아닌 고객 번호 조회
SELECT CLIENTNO
FROM CLIENT
WHERE CLIENTHOBBY IN (SELECT CLIENTHOBBY
                      FROM CLIENT);

-- EXISTS: 서브쿼리 결과에 null 값 포함
SELECT CLIENTNO
FROM CLIENT
WHERE EXISTS (SELECT CLIENTHOBBY
              FROM CLIENT);
              
--------------------------------------------------------------------------------

-- ALL/ANY
-- 관계연산자와 같이 사용

-- ALL: 서브쿼리의 결과 리스트가 조건 검사대상이 되는 값과 비교할때 모든 값이 비교연산에 대해 참이 되는 경우 true 반환
-- 칼럼값이 10 > ALL(3, 4, 5, 6)=> true
-- ANY: 서브쿼리의 결과 리스트가 조건 검사대상이 되는 값과 비교할때 하나의 값이라도 참이 되는 경우 true 반환
-- 칼럼값이 10 > ALL(3, 11, 12, 13)=> true

-- 2번 고객이 주문한 도서의 최고 주문수량보다 더 많은 도서를 구입한 고객의 고객번호, 주문번호, 주문수량 출력
-- 서브쿼리 MAX 집계함수 사용
SELECT CLIENTNO, BSNO, BSQTY
FROM BOOKSALE
WHERE BSQTY > (SELECT MAX(BSQTY)
               FROM BOOKSALE
               WHERE CLIENTNO = '2');
               
-- 메인쿼리에서 ALL 연산자 사용             
SELECT CLIENTNO, BSNO, BSQTY
FROM BOOKSALE
WHERE BSQTY > ALL(SELECT BSQTY
                  FROM BOOKSALE
                  WHERE CLIENTNO = '2');
-- 서브쿼리의 결과 리스트 중 최대값 보다 큰 <-이라는 의미                  
               
-- 2번 고객의 주문 내역과 비교할때 한번이라도 더 많은 주문을 한적 있는 고객
-- 2번 고객의 최소 주문 수량보다 많이 주문한 적이 있는 고객
-- 서브쿼리 MIN 집계함수 사용
SELECT CLIENTNO, BSNO, BSQTY
FROM BOOKSALE
WHERE BSQTY > (SELECT MIN(BSQTY)
               FROM BOOKSALE
               WHERE CLIENTNO = '2');
               
-- 메인쿼리에서 ANY 연산자 사용 
SELECT CLIENTNO, BSNO, BSQTY
FROM BOOKSALE
WHERE BSQTY > ANY(SELECT BSQTY
                  FROM BOOKSALE
                  WHERE CLIENTNO = '2');

-- 2번 고객이 주문한 최소 주문수량보다 많이 주문한 고객 주문정보 (2번 고객 제외)
SELECT CLIENTNO, BSNO, BSQTY
FROM BOOKSALE
WHERE BSQTY > ANY(SELECT BSQTY
                  FROM BOOKSALE
                  WHERE CLIENTNO = '2')
      AND CLIENTNO != 2;

--------------------------------------------------------------------------------

-- Scalar SUB QUERY
-- SELECT/UPDATE 에서 사용
-- 서브쿼리의 결과로 단일열의 스칼라 값 반환

-- 고객별 총 추문수량
-- BOOKSALE 테이블로 GROUP BY 고객이름 조회 불가
SELECT CLIENTNO, SUM(BSQTY) AS "총 주문수량"
FROM BOOKSALE
GROUP BY CLIENTNO;

-- 스칼라 서브쿼리 사용
SELECT CLIENTNO, 
        (SELECT CLIENTNAME -- WHERE절에서 비교되는 CLIENTNO 가 GROUP 기준이므로 반화되는 CLIENTNAME 은 그룹별로 반환됨
         FROM CLIENT
         WHERE CLIENT.CLIENTNO = BOOKSALE.CLIENTNO
         ) AS "고객명",
         SUM(BSQTY) AS "총 주문수량"
FROM BOOKSALE
GROUP BY CLIENTNO
ORDER BY CLIENTNO;

/*
DBMS VIEW 객체 제공
한개의 릴레이션에 모든 정보가 저장되지 않음
필요한 정보를 얻기위해 join, sub query 진행
- 많은 연산 수행 동반
- 한번 연산 해놓은 결과의 데이터를 다시 사용하려 할때 빠른 연산을 위해 연산 순서 기록한 것
- 물리적 의미는 같지만 사용할땐 릴레이션 처럼 사용 가능
- 뷰 생성시 관리 문제나 트랜잭션 등 성능 문제 발생 가능성 => 가상의 뷰/인라인 뷰 사용
*/


-- 인라인 뷰: 반환되는 데이터가 다중행, 다중열 이어도 상관없음

-- 도서가격이 25000원 이상인 도서 중 판매된 도서에 대해 도서별로 도서명, 도서가격, 총 판매수량, 총 판매액 조회
SELECT BOOKNAME, BOOKPRICE, COUNT(*) AS "판매건수", SUM(BSQTY) AS "총 판매수량", SUM(BOOKPRICE * BSQTY) AS "총 판매액"
FROM BOOKSALE BS,
     (SELECT BOOKNO, BOOKNAME, BOOKPRICE
      FROM BOOK
      WHERE BOOKPRICE > 25000) BOOK
WHERE BOOK.BOOKNO = BS.BOOKNO
GROUP BY BOOK.BOOKNO, BOOK.BOOKNAME, BOOK.BOOKPRICE;

