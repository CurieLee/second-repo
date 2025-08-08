
-- SELECT 
/*
SELECT [ALL | DISTINCT] 열이름 리스트
FROM 테이블명
[WHERE 검색조건(들)]
[GROUP BY 열이름]
[HAVING 검색조건(들)]
[ORDER BY 열이름 [ASC┃DESC]
*/

-- 서점 관계 테이블 import
SELECT * FROM BOOK;

-- 테이블에 제약조건 설정
-- 참조 무결성 제약조건
-- 참조되는 테이블의 기본키 먼저 구성-> 참조하는 테이블에서 외래키 구성

-- 모든 도서는 거래하고 있는 출판사에서 구매된다: 도서테이블 출판사 데이터는 출판사 테이블의 기본키 도메인 범위에 귀속
-- 모든 도서는 회원가입 되어있는 회원이 서점에 등록되어있는 도서를 구매할 수 있: 구매관계 테이블(BOOKSALE)

-- 기본키 제약조건
ALTER TABLE PUBLISHER
    ADD CONSTRAINT PK_publisher_pubno
    PRIMARY KEY (PUBNO);
    
ALTER TABLE BOOK
    ADD CONSTRAINT PK_book_bookno
    PRIMARY KEY (BOOKNO);
    
ALTER TABLE CLIENT
    ADD CONSTRAINT PK_client_clientno
    PRIMARY KEY (CLIENTNO);
    
ALTER TABLE BOOKSALE
    ADD CONSTRAINT PK_booksale_bsno
    PRIMARY KEY (BSNO);
    

-- 외래키 제약조건
ALTER TABLE BOOK
    ADD CONSTRAINT FK_book_publisher
    FOREIGN KEY (PUBNO) REFERENCES PUBLISHER(PUBNO);
 
ALTER TABLE BOOKSALE
    ADD CONSTRAINT FK_bookSale_client
    FOREIGN KEY (clientNo) REFERENCES CLIENT(clientNo);    
    
ALTER TABLE BOOKSALE
    ADD CONSTRAINT FK_bookSale_book
    FOREIGN KEY (bookNO) REFERENCES BOOK(bookNO);  
    

SELECT * FROM BOOKSALE;

--------------------------------------------------------------------------------

-- BOOK 테이블에서 모든 행 검색
-- (*) 모든
SELECT * FROM BOOK;

-- BOOK 테이블에서 도서명, 도서가격만 검색
SELECT BOOKNAME, BOOKPRICE FROM BOOK;

-- BOOK 테이블에서 저자 검색
SELECT BOOKAUTHOR FROM BOOK;

-- BOOK 테이블에서 저자 검색 DISTINCT 중복 삭제
SELECT DISTINCT BOOKAUTHOR FROM BOOK;


--------------------------------------------------------------------------------

/*
WHERE 조건절: 검색의 세분화
조건 사용 연산자
비교: = < > <= >= !=
범위: BETWEEN
리스트에 포함: IN/NOT IN
NULL: IS NULL/IS NOT NULL
논리: AND/OR
패턴매칭: LIKE
*/

-- 비교: = < > <= >= !=
-- 저자가 홍길동인 도서의 도서명, 저자 반환
SELECT BOOKNAME, BOOKAUTHOR FROM BOOK
WHERE BOOKAUTHOR='홍길동';

-- 도서가가 30000원 이상인 도서의 도서명, 가격, 재고 반환
SELECT BOOKNAME, BOOKPRICE, BOOKSTOCK FROM BOOK
WHERE 30000 <= BOOKPRICE;

-- 도서 재고가 3권 이상이고 5권 이하인 도서의 도서명과 재고 반환
-- 범위: BETWEEN 
SELECT BOOKNAME, BOOKSTOCK FROM BOOK
WHERE 3 <= BOOKSTOCK AND BOOKSTOCK <= 5;

SELECT BOOKNAME, BOOKSTOCK FROM BOOK
WHERE BOOKSTOCK BETWEEN 3 AND 5;

-- 리스트에 포함: IN/NOT IN: 속성명 IN (값1, 값2, ...)-> 리스트
-- 서울출판사('1') 와 도서출판 강남('2') 의 도서명과 출판사 번호 출력
SELECT BOOKNAME, PUBNO FROM BOOK
WHERE PUBNO IN('1', '2');

-- 서울출판사('1') 와 도서출판 강남('2') 이 아닌 도서명과 출판사 번호 출력
SELECT BOOKNAME, PUBNO FROM BOOK
WHERE PUBNO NOT IN('1', '2');

-- NULL: IS NULL/IS NOT NULL
-- 모든 클라이언트의 이름과 취미 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT;

-- 취미 정보가 NULL 인 클라이언트의 이름과 취미 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY IS NULL;

-- 취미 정보가 NULL 이 아닌 클라이언트의 이름과 취미 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY IS NOT NULL;

-- 취미에 공백값이 저장되어 있는 클라이언트의 이름과 취미 반환
SELECT CLIENTNAME, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY = ' ';

-- 논리: AND/OR
-- 저자가 홍길동 이면서 재고가 3권 이상인 도서 정보 반환
SELECT * FROM BOOK
WHERE BOOKAUTHOR='홍길동' AND 3 <= BOOKSTOCK;

SELECT * FROM BOOK
WHERE BOOKAUTHOR='홍길동' OR BOOKAUTHOR='성춘향';

SELECT * FROM BOOK
WHERE BOOKAUTHO IN('홍길동', '성춘향');

-- 패턴매칭: LIKE
-- WHERE 컬럼명 LINK '패턴'
-- % : 0개 이상의 문자를 가진 문자열, _ : 1개의 문자

-- '홍%' 홍으로 시작하는 문자열
-- '%길%' 길을 포함하는 문자열
-- '%동' 동으로 끝나는 문자열 
-- '____' 4개의 문자로 이루어진 문자열

-- 출판사 이름에 출판사 문자열이 포함된 출판사 정보 출력
SELECT * FROM PUBLISHER
WHERE PUBNAME LIKE '%출판사%';

-- 출생년도가 1990년대인 고객의 정보 반환
SELECT * FROM CLIENT
WHERE CLIENTBIRTH LIKE '199%';

-- 이름이 4글자인 고객의 정보 반환
SELECT * FROM CLIENT
WHERE CLIENTNAME LIKE'____';

-- NOT LIKE
-- 도서명에 안드로이드가 포함되지 않는 도서의 정보
SELECT * FROM BOOK
WHERE BOOKNAME NOT LIKE '%안드로이드%';

--------------------------------------------------------------------------------

-- ORDER BY
-- 특정 열의 값을 기준으로 질의 결과 정렬 
-- 가장 마지막에 진행되는 연산
-- 기준열을 두개 이상 나열 가능: 우선기준-> 두번째-> 세번째 
-- ASC 오름차순 (default)
-- DESC 내림차순

-- 도서 정보를 도서명 순으로 반환
SELECT * FROM BOOK
ORDER BY BOOKNAME;

-- 내림차순
SELECT * FROM BOOK
ORDER BY BOOKNAME DESC;

-- 조건절 뒤에 ORDER BY
SELECT BOOKNAME, BOOKAUTHOR, BOOKSTOCK FROM BOOK
WHERE 20000 <= BOOKPRICE
ORDER BY BOOKPRICE;

-- 정렬 조건 2개 이상 나열
-- 도서 재고를 기준으로 내림차순 정렬-> 재고가 동일한 경우 저자를 기준으로 오름차순 정렬 
SELECT * FROM BOOK
ORDER BY BOOKSTOCK DESC, BOOKAUTHOR ASC;

--------------------------------------------------------------------------------

-- 집계 함수
-- SUM()/AVG()/COUNT()/COUNT(*)/MAX()/MIN()

-- SUM()
-- 도서의 총 재고 수량 출력
SELECT SUM(BOOKSTOCK) AS "SUM OF BOOKSTOCK" FROM BOOK; -- 테이블 반환-> 컬럼명 존재 연산식 컬럼명으로 반환
SELECT SUM(BOOKSTOCK) AS "총 재고량" FROM BOOK; 

-- 모든 컬럼은 컬럼의 별명 생성 가능 AS
-- 컬럼 AS "별명"

-- 2번 고객이 주문한 총 도서주문
SELECT SUM(BSQTY) AS "총 주문수량" 
FROM BOOKSALE
WHERE CLIENTNO='2';

-- 2번 고객이 주문한 총 도서주문과 주문 도서명
-- 총 주문수량 1개의 튜플
-- 도서번호는 3개의 튜플
-- GROUP BY 절을 포함하고 있는 경우가 아니면 모든 컬럼이 집계함수를 사용해야함
/*
SELECT SUM(BSQTY) AS "총 주문수량" , BOOKNO
FROM BOOKSALE
WHERE CLIENTNO='2';
*/

SELECT SUM(BSQTY) AS "총 주문수량", AVG(BSQTY) AS "평균 주문수량"
FROM BOOKSALE
WHERE CLIENTNO='2';
