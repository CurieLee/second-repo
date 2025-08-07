-- 테이블 생성
-- 동일DB(동일 계정) 동일명 테이블 존재 x
-- 기본키 제약조건
-- 1 속성 설정시 기본키 지정
CREATE TABLE product1 (
    prodNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    prodName VARCHAR2(30) NOT NULL,
    prodPrice NUMBER(8),
    prodCompany VARCHAR2(30)
);

-- 2 기본키 따로 설정
/*
CREATE TABLE product2 (
    prodNo VARCHAR2(10) NOT NULL,
    prodName VARCHAR2(30) NOT NULL,
    prodPrice NUMBER(8),
    prodCompany VARCHAR2(30),
    PRIMARY KEY(prodNo)
);

-- 3 제약 이름과 같이 설정: 제약 변경이나 삭제시 유용
CREATE TABLE product3 (
    prodNo VARCHAR2(10) NOT NULL CONSTRAINT PK_product_prodNo PRIMARY KEY, 
    prodName VARCHAR2(30) NOT NULL,
    prodPrice NUMBER(8),
    prodCompany VARCHAR2(30)
);
*/

-- 4 따로 설정 제약명 추가
CREATE TABLE product2 (
    prodNo VARCHAR2(10),
    prodName VARCHAR2(30) NOT NULL,
    prodPrice NUMBER(8),
    prodCompany VARCHAR2(30),
    CONSTRAINT PK_product_prodNo PRIMARY KEY(prodNo)
);

------------------------------------------------------------------
-- 출판사 테이블 생성-> 도서 테이블 생성 (외래키 참조 필드)
-- 외래키 입력 값은 참조 테이블의 기본키와 일치해야함
-- 외래키의 도메인과 참조 테이블의 기본키 도메인 일치함

-- DROP TABLE 반대로 도서 테이블 삭제-> 출판사 테이블 삭제

/* 출판사 테이블 생성 (출판사 번호, 출판사 명)
제약조건: 기본키 not null
*/

CREATE TABLE publisher (
    pubNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    pubName VARCHAR2(30) NOT NULL
);


/* 도서 테이블 생성 (도서번호, 도서명, 가격, 발행일, 출판사번호)
제약조건: 기본키 외래키 기본값 체크
*/
-- 외래키 필드는 참조 테이블에서는 기본키
CREATE TABLE book (
    bookNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookName VARCHAR2(30) NOT NULL,
    bookPrice NUMBER(8) DEFAULT 10000 CHECK(1000 < bookPrice),
    bookDate DATE,
    pubNo VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_book_publisher FOREIGN KEY (pubNo) REFERENCES publisher(pubNo)
);

------------------------------------------------------------------
/* 학생과 학과 테이블 생성하고 데이터 입력 (각 3개씩)
제약조건: 기본키 학생 학과에 소속 학생 이름 학과 이름 not null 학년 기본값 4 범위 1~4
*/

CREATE TABLE department (
    deptNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    deptName VARCHAR2(30) NOT NULL,
    profName VARCHAR2(30)
);

CREATE TABLE student (
    stdNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    stdName VARCHAR2(30) NOT NULL,
    grade NUMBER(8) DEFAULT 4 CHECK(0 < grade AND grade < 5),
    deptNo VARCHAR2(10),
    CONSTRAINT FK_student_department FOREIGN KEY (deptNo) REFERENCES department(deptNo)
);

-- 교수 테이블
CREATE TABLE professor (
	profNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    profName VARCHAR2(30) NOT NULL,
    profPosition VARCHAR2(30),
    profTel VARCHAR2(13),
    deptNo VARCHAR2(10) NOT NULL,
    FOREIGN KEY (deptNo) REFERENCES department(deptNo)
);

-- 과목 테이블
CREATE TABLE course (
	courseId VARCHAR2(10) NOT NULL PRIMARY KEY,
    courseName VARCHAR2(30) NOT NULL,
    courseCredit INT,
    profNo VARCHAR2(10) NOT NULL,
    FOREIGN KEY (profNo) REFERENCES professor(profNo)
);

-- 성적 테이블
CREATE TABLE SCORES(
	stdNo VARCHAR2(10) NOT NULL,
	courseID VARCHAR2(10) NOT NULL,
	score NUMBER(3),
	grade VARCHAR2(2),
	CONSTRAINT PK_SCORES_STDNO_COURSEID PRIMARY KEY (stdNo, courseID),
	CONSTRAINT FK_SCORES_STUDENT FOREIGN KEY (stdNo) REFERENCES student (stdNo),
	CONSTRAINT FK_SCORES_COURSE FOREIGN KEY (stdNo) REFERENCES course (courseID)
);