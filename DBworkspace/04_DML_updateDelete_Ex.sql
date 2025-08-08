
-- book 테이블에 행 삽입
-- book 테이블에서 도서명이 '데이터베이스' 인 행의 가격을 22000 으로 변경
-- book 테이블에서 발행일이 2018년도인 행 삭제

INSERT INTO BOOK VALUES(6, 'JAVA 프로그래밍', 30000, '2021-03-10', '1');
INSERT INTO BOOK VALUES(7, '파이썬 데이터 과학', 24000, '2018-02-15', '2');

UPDATE BOOK SET BOOKPRICE=22000 WHERE BOOKNAME='데이터베이스';
DELETE FROM BOOK WHERE '2017-12-31' < BOOKDATE AND BOOKDATE < '2019-01-01';



--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

-- 종합 연습문제
-- 고객 테이블 생성/ 주문 테이블 생성
-- 고객 테이블 전화번호 NOT NULL
-- 고객 테이블 성별 나이 추가
-- 고객 주문 테이블에 데이터 삽입 3개씩
-- 주문 테이블에서 상품번호가 2인 행의 주문 수량을 3으로 수정

CREATE TABLE CUSTOMER (
    custNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    custName VARCHAR2(30) NOT NULL,
    custTel VARCHAR2(30),
    custAddress VARCHAR2(40)
);

CREATE TABLE ORDERPRODUCT (
    orderNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    orderDate DATE ,
    orderQty NUMBER(3),
    custNo VARCHAR2(10) NOT NULL,
    prdNo NUMBER(4) NOT NULL,
    CONSTRAINT FK_ORDERPRODUCT_CUSTOMER FOREIGN KEY (custNo) REFERENCES CUSTOMER(custNo),
    CONSTRAINT FK_ORDERPRODUCT_PRODUCT FOREIGN KEY (prdNo) REFERENCES PRODUCT(prdNo)
);

ALTER TABLE CUSTOMER MODIFY custTel VARCHAR2(30) NOT NULL;

ALTER TABLE CUSTOMER
ADD (custGender VARCHAR2(10) DEFAULT '남' CHECK (custGender = '남' OR custGender = '여'),
     custAge Number(2));
    
INSERT INTO CUSTOMER VALUES ('1001', '홍길동', '010-1111-1111', '강원도 평창', '남', 22);
INSERT INTO CUSTOMER VALUES ('1002', '이몽룡', '010-2222-2222', '서울시 종로구', '남', 23);    
INSERT INTO CUSTOMER VALUES ('1003', '성춘향', '010-3333-3333', '서울시 강남구', '여', 22);

INSERT INTO ORDERPRODUCT VALUES ('1', '2018-01-10', 3, '1003', '3');
INSERT INTO ORDERPRODUCT VALUES ('2', '2018-03-03', 1, '1001', '7');
INSERT INTO ORDERPRODUCT VALUES ('3', '2018-04-05', 3, '1002', '2');

UPDATE ORDERPRODUCT SET orderQty=3 WHERE prdNo='2'; 