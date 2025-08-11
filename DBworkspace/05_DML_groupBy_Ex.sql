
-- 1 도서 테이블에서 가격 순으로 내림차순 정렬하여,  도서명, 저자, 가격 출력 (가격이 같으면 저자 순으로 오름차순 정렬)
SELECT BOOKNAME, BOOKAUTHOR, BOOKPRICE
FROM BOOK
ORDER BY BOOKPRICE DESC, BOOKAUTHOR ASC;

-- 2 도서 테이블에서 저자에 '길동'이 들어가는 도서의 총 재고 수량 계산하여 출력
SELECT SUM(BOOKSTOCK) AS 재고
FROM BOOK
WHERE BOOKAUTHOR LIKE '%길동%';

-- 3 도서 테이블에서 ‘서울 출판사' 도서 중 최고가와 최저가 출력
SELECT MAX(BOOKPRICE) AS "최고가" , MIN(BOOKPRICE) AS "최저가" 
FROM BOOK
WHERE PUBNO = 1;

-- 4 도서 테이블에서 출판사별로 총 재고수량과 평균 재고 수량 계산하여 출력 (‘총 재고 수량’으로 내림차순 정렬)
-- 정수표현 반올림 round(대상, 자리수)
SELECT PUBNO, SUM(BOOKSTOCK) AS "총 재고수량", ROUND(AVG(BOOKSTOCK)) AS "평균 재고수량"
FROM BOOK
GROUP BY PUBNO
ORDER BY SUM(BOOKSTOCK) DESC;

-- 5 도서판매 테이블에서 고객별로 ‘총 주문 수량’과 ‘총 주문 건수’ 출력. 단 주문 건수가 2이상인 고객만 해당
SELECT CLIENTNO, SUM(BSQTY) AS "총 주문수량" , COUNT(*) AS "총 주문건수"
FROM BOOKSALE
GROUP BY CLIENTNO
HAVING 2 <= COUNT(*);


