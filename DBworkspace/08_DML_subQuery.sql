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

-- 도서를 구매한적이 있는 고객의 고객명, 지역 조회
SELECT CLIENTNAME, CLIENTADDRESS
FROM CLIENT
WHERE CLIENTNO IN (
                  SELECT CLIENTNO
                  FROM BOOKSALE
                  );
-- 비교연산자는 하나의 값만 비교 수행 가능
-- 주문한 고객의 고객 번호는 여러개의 값 반환-> 