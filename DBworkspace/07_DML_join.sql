
-- JOIN
-- 여러개의 테이블을 결합해 조건에 맞는 행 검색

-- 조인 종류
-- inner join/outer join
-- 1 inner join: 두 테이블에 공통되는 열만 결합
-- 2 outer join: 두 테이블에 공통되는 열이 없어도 결합

-- 고객/주문테이블
-- 상품을 주문한 고객 조회: inner join
-- 상품을 주문한 고객과 주문하지 않은 고객 모두 조회: outer join

/*
SELECT 열 리스트
FROM 테이블명 1
    INNER JOIN 테이블명 2
    ON 조인 조건(기본키 = 외래키)

SELECT 열 리스트
FROM 테이블명 1, 테이블명 2
WHERE 조인 조건(기본키 = 외래키)

SELECT 테이블명.속성명, 테블명.속성명
FROM 테이블명 1, 테이블명 2
WHERE 조인 조건(기본키 = 외래키)
*/
-- 주문한 적이 있는 고객 번호 이름
-- 고객 테이블에서 고객 번호와 이름이 있지만 주문여부 확인 불가능
-- 주문 테이블에서 주문여부 확인 가능하지만 고객 번호와 이름 확인 불가능

-- 주문한적 있는 고객의 정보
-- 가장 많이 사용되는 방법 
SELECT CLIENT.CLIENTNO, CLIENTNAME
FROM CLIENT
    INNER JOIN BOOKSALE
    ON CLIENT.CLIENTNO = BOOKSALE.CLIENTNO;
    
SELECT CLIENT.CLIENTNO, CLIENTNAME
FROM CLIENT, BOOKSALE -- 결합하고자 하는 테이블 나열
WHERE CLIENT.CLIENTNO = BOOKSALE.CLIENTNO;
    
-- 결과는 clientNo 를 제외하고 테이블명 포함시키지 않아도 됨
-- 오라클 서버 입장에서는 속성의 소속을 명확히 하면 위치를 정확히 알수 있음-> 성능 향상
SELECT CLIENT.CLIENTNO, CLIENT.CLIENTNAME, BOOKSALE.BSQTY
FROM CLIENT, BOOKSALE
WHERE CLIENT.CLIENTNO = BOOKSALE.CLIENTNO;

-- 테이블에 별칭 사용
SELECT C.CLIENTNO, C.CLIENTNAME, B.BSQTY
FROM CLIENT C, BOOKSALE B
WHERE C.CLIENTNO = B.CLIENTNO;

-- 주문한적 있는 고객의 정보 (JOIN INNERJOIN 동일함)
-- 조인으로 인한 중복제거 UNIQUE
-- 고객 번호 기준 정렬
SELECT UNIQUE C.CLIENTNO, C.CLIENTNAME
FROM CLIENT C
    JOIN BOOKSALE B
    ON C.CLIENTNO = B.CLIENTNO
ORDER BY C.CLIENTNO;

-- 소장 도서에 대한 도서명과 출판사명
SELECT BOOKNAME, PUBNAME
FROM BOOK B
    INNER JOIN PUBLISHER P
    ON B.PUBNO = P.PUBNO;
 
--------------------------------------------------------------------------------
    
-- 주문된 도서의 도서번호와 고객번호
SELECT BOOKNO, CLIENTNO
FROM BOOKSALE;

-- 주문된(bookSale) 도서의 도서명(book)과 고객(client)
-- 3개 테이블 조인 진행: select ~ from ~ inner join ~ on ~ inner join ~ on ~
SELECT C.CLIENTNAME, B.BOOKNAME
FROM BOOKSALE BS
    INNER JOIN CLIENT C ON C.CLIENTNO = BS.CLIENTNO
    INNER JOIN BOOK B ON B.BOOKNO = BS.BOOKNO;

-- 도서를 주문한 고객의 고객정보, 주문정보, 도서정보 조회
SELECT C.CLIENTNAME, B.BOOKNAME, BS.BSDATE, BS.BSQTY
FROM BOOKSALE BS
    INNER JOIN CLIENT C ON C.CLIENTNO = BS.CLIENTNO
    INNER JOIN BOOK B ON B.BOOKNO = BS.BOOKNO;
    
-- 고객별로 총 주문수량 계산
-- 주문수량 기준 내림차순 정렬    
SELECT CLIENTNO, SUM(BSQTY) AS "총 주문수량"
FROM BOOKSALE
GROUP BY CLIENTNO
ORDER BY "총 주문수량" DESC;

-- 고객별로 총 주문수량 계산
-- 주문수량 기준 내림차순 정렬 
-- 고객명을 표현할것 <-group by 제한

-- 고객별로 그룹 생성시 동명이인 존재할 수 있음-> 고객명만 가지고 그룹화 하면 안됨
SELECT C.CLIENTNO, C.CLIENTNAME, SUM(BS.BSQTY) AS "총 주문수량"
FROM BOOKSALE BS
    INNER JOIN CLIENT C ON C.CLIENTNO = BS.CLIENTNO
GROUP BY C.CLIENTNO, C.CLIENTNAME
ORDER BY "총 주문수량" DESC;

-- Group by 에 작성하지 않은 열 이름이 SELECT 절에 올수 없음

-- 주문된 도서의 주문일, 고객명, 도서명, 도서가격, 주문수량, 주문액(연산 : 단가*주문수량) 조회
SELECT BS.BSDATE, C.CLIENTNAME, B.BOOKNAME, B.BOOKPRICE, BS.BSQTY,
       B.BOOKPRICE * BS.BSQTY AS "주문액"
FROM BOOKSALE BS
    INNER JOIN CLIENT C ON C.CLIENTNO = BS.CLIENTNO
    INNER JOIN BOOK B ON B.BOOKNO = BS.BOOKNO
-- WHERE 100000 <= "주문액" -- 별칭 사용 불가능 (별칭 생성 전에 수행)
WHERE 100000 <= (B.BOOKPRICE * BS.BSQTY)
ORDER BY "주문액" DESC; -- 별칭 사용 가능 (가장 마지막 단계에 수행)

-- 쿼리 실행순서: FROM(JOIN)-> WHERE-> GROUP BY-> HAVING-> SELECT-> ORDER BY


-- 2018년부터 현재까지 판매된 도서의 주문일, 고객명, 도서명, 도서가격, 주문수량, 주문액 계산해서 조회
SELECT BS.BSDATE, C.CLIENTNAME, B.BOOKNAME, B.BOOKPRICE, BS.BSQTY,
       B.BOOKPRICE * BS.BSQTY AS "주문액"
FROM BOOKSALE BS
    INNER JOIN CLIENT C ON C.CLIENTNO = BS.CLIENTNO
    INNER JOIN BOOK B ON B.BOOKNO = BS.BOOKNO
WHERE '2018-01-01' <= BS.BSDATE
ORDER BY BS.BSDATE;

--------------------------------------------------------------------------------

-- CLIENT 테이블과 BOOKSALE 테이블 활용 outer join 예시
-- 왼쪽 기준 
SELECT *
FROM CLIENT C
    LEFT OUTER JOIN BOOKSALE BS
    ON C.CLIENTNO = BS.CLIENTNO
ORDER BY C.CLIENTNO;
-- 조회결과 clientNo_1 컬럼에 NULL 이라고 표현되는 튜플은 주문한적 없는 고객을 의미

-- 오른쪽 기준: inner join 과 동일한 결과 
-- 서점 고객 중 주문하지 않은 고객 존재 가능, 주문한 고객 중 서점의 회원이 아닐 가능성 없음
SELECT *
FROM CLIENT C
    RIGHT OUTER JOIN BOOKSALE BS
    ON C.CLIENTNO = BS.CLIENTNO
ORDER BY C.CLIENTNO;

-- 완전 FULL outer join
-- CLIENT 가 아니면 주문 불가능-> 제약조건 있음: left outer join 과 동일한 결과
SELECT *
FROM CLIENT C
    FULL OUTER JOIN BOOKSALE BS
    ON C.CLIENTNO = BS.CLIENTNO
ORDER BY C.CLIENTNO;

-- 오라클 outer join
-- (+) 연산자로 조인시킬 값이 조인측에 위치 
-- 고객의 주문정보를 확인하되 주문이 없는 고객의 정보 확인
SELECT *
FROM CLIENT C, BOOKSALE BS
WHERE C.CLIENTNO = BS.CLIENTNO (+) -- ORA-01468: outer-join 된 테이블은 1개만 지정 가능
ORDER BY C.CLIENTNO;

