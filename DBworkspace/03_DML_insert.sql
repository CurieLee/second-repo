-- 데이터 조작어 (DML)
-- 데이터 입력/삭제/수정/검색

-- INSERT : 테이블에 데이터(튜플) 저장하는 조작
-- INSERT INTO 테이블명(열 이름 리스트) VALUES(값 리스트): 부분열만 저장 가능 - null 허용하는 열 생략 가능

-- INSERT INTO 테이블명 VALUES(값 리스트): 값 리스트에 모든 열의 값이 칼럼 순서에 맞게 나열

-- STUDENT TABLE insert 열 이름 나열 순서 상관없음 값 리스트->열 리스트 순서 따름
INSERT INTO STUDENT (stdNo, stdName, grade, deptNo)
VALUES ('20150000', '변학도', 4, '1');
-- 값 문자열 홑따옴표







--------------------------------------------------------------------------------
-- 시퀀스
-- 오라클 데이터베이스 객체로 유일한 값의 일련번호 생성
-- 지정한 수치로 증가하거나 감소
-- 기본키에 자동 증가값을 사용할때 유용
-- 최대 15개까지 생성 가능
-- 테이블과 독립적으로 저장 생성
-- 하나의 시퀀스 여러 테이블에서 사용 가능

--  시퀀스 적용할 테이블 생성
DROP TABLE board;
CREATE TABLE  board(
    bNo NUMBER PRIMARY KEY,
    bSubject VARCHAR2(30) NOT NULL,
    bname   VARCHAR2(20) NOT NULL
    );
    
CREATE SEQUENCE NO_SEQ;

-- 데이터 추가
INSERT INTO board VALUES(NO_SEQ.NEXTVAL, '추석', '홍길동');
INSERT INTO board VALUES(NO_SEQ.NEXTVAL, '미세먼지', '홍길동');
INSERT INTO board VALUES(NO_SEQ.NEXTVAL, '휴가', '홍길동');

SELECT * FROM BOARD;

-- 시퀀스 값 검색
SELECT NO_SEQ.CURRVAL FROM DUAL;

-- 시퀀스 수정
ALTER SEQUENCE NO_SEQ
    MAXVALUE 1000;
    
-- 수정 결과 검색: 구조에 대한 검색, 시퀀스 정보 저장 테이블 USER_SEQUENCES
SELECT SEQUENCE_NAME, MAX_VALUE
FROM USER_SEQUENCES;

-- 시퀀스 삭제: DROPO SEQUENCE 시퀀스명
DROP SEQUENCE NO_SEQ;

SELECT SEQUENCE_NAME FROM USER_SEQUENCES;

-- DUAL 테이블
-- 오라클 자체에서 제공되는 테이블
-- 1개의 행과 1개의 열만 있는 더미 테이블
-- SYS 소유지만 모든 사용자가 사용할 수 있음
-- 간단한 함수 계산 결과값 확인용
SELECT CURRENT_DATE FROM DUAL;

--------------------------------------------------------------------------------
-- data import
-- 텍스트 파일을 읽어서 테이블 생성 및 데이터 구성
-- 제약조건 추가
ALTER TABLE PRODUCT
	ADD CONSTRAINT PK_PRODUCT_PRDNO
    PRIMARY KEY(PRDNO);





    