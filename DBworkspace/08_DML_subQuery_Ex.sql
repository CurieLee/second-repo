
-- 1 호날두(고객명)가 주문한 도서의 총 구매량 출력
SELECT SUM(BSQTY) AS "총 구매량"
FROM BOOKSALE
WHERE CLIENTNO = (SELECT CLIENTNO
                  FROM CLIENT
                  WHERE CLIENTNAME = '호날두');

-- 2 ‘정보출판사’에서 출간한 도서를 구매한 적이 있는 고객명 출력
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO IN (SELECT CLIENTNO
                   FROM BOOKSALE
                   WHERE BOOKNO IN (SELECT BOOKNO
                                    FROM BOOK
                                    WHERE PUBNO = (SELECT PUBNO
                                                   FROM PUBLISHER
                                                   WHERE PUBNAME = '정보출판사')));
                                                   
-- 3 베컴이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구매한 고객명 출력
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO = (SELECT CLIENTNO
                  FROM BOOKSALE
                  WHERE BSQTY > (SELECT MAX(BSQTY)
                                 FROM BOOKSALE
                                 WHERE CLIENTNO = (SELECT CLIENTNO
                                                   FROM CLIENT
                                                   WHERE CLIENTNAME = '베컴')));
                                 
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO IN (SELECT CLIENTNO
                  FROM BOOKSALE
                  WHERE BSQTY > ALL(SELECT BSQTY
                                    FROM BOOKSALE
                                    WHERE CLIENTNO = (SELECT CLIENTNO
                                                      FROM CLIENT
                                                      WHERE CLIENTNAME = '베컴')));                                 

-- 4 천안에 거주하는 고객에게 판매한 도서의 총 판매량 출력
SELECT SUM(BSQTY) AS "총 판매량"
FROM BOOKSALE
WHERE CLIENTNO IN (SELECT CLIENTNO
                   FROM CLIENT
                   WHERE CLIENTADDRESS = '천안');
                                   