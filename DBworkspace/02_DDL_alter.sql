-- ALTER TABLE (ADD/DROP/MODIFY/RENAME)

-- ALTER TABLE ADD
ALTER TABLE product1 ADD (prodUITPrice NUMBER(8), prodStock NUMBER(12));

-- 열의 데이터 형식 변경: ALERT TABLE 테이블명 MODIFY 속성명 변경타입
ALTER TABLE product1 MODIFY prodUITPrice NUMBER(4);

-- 열의 제약조건 NOT NULL-> NULL :: MODIFY
ALTER TABLE product1 MODIFY prodName VARCHAR2(30) NULL;

-- 열 이름 변경 ALTER TABLE 테이블명 RENAME COLUMN 기존 컬럼명 to 새로운 컬럼명
ALTER TABLE product1 RENAME COLUMN prodUITPrice TO prodUPrice;

-- 열 삭제
ALTER TABLE product1 DROP COLUMN prodStock;

-- 기본키 삭제: 기본키는 반드시 있어야 하는건 아님 논리적 특징 유지하기 위함
-- 학생 테이블-> 교수 테이블 참조: 외부테이블 참조 기본키 참조 오류로 기본키 제약조건 삭제 불가능
ALTER TABLE department DROP PRIMARY KEY;

-- 제약조건(참조제약) 무시 무조건 기본키 삭제
-- 참조하는 외래키 제약조건 같이 삭제 됨
ALTER TABLE department DROP PRIMARY KEY CASCADE;

-- 제약조건 추가
ALTER TABLE department 
ADD CONSTRAINT PK_department_deptNo PRIMARY KEY (deptNo);

ALTER TABLE student
ADD CONSTRAINT FK_department_deptNo FOREIGN KEY (deptNo) REFERENCES department(deptNo);

-- 외래키 제약조건 삭제: DROP CONSTRAINT 제약조건 이름
ALTER TABLE student DROP CONSTRAINT FK_student_department;

-- 기본키 삭제: 참조하고 있는 다른 테이블 없으면 무조건 삭제 가능
-- 기본키 삭제하려고 할때 참조하는 테이블의 참조 제약조건 삭제 후 삭제 가능
-- 강제 CASCADE
ALTER TABLE department DROP PRIMARY KEY;



--------------------------------------------------------------------------------
-- 테이블 제약조건 확인 쿼리
-- 일반 유저 설정 제약조건: USER_CONSTRAINTS 에 모든 정보 포함
-- 일반 유저는 조회 권한을 가지고 있음

SELECT * FROM USER_CONSTRAINTS; -- 해당 USER 소유 테이블에 모든 제약조건 확인
SELECT * FROM USER_CONSTRAINTS
WHERE TAVLE_NAME='student'; -- 해당 USER 소유한 테이블 제약조건 확인

-- 제약조건 타입
-- C : Check on a table, Check, NOT NULL
-- P : Primary Key
-- F : Foreign Key

--------------------------------------------------------------------------------

-- 데이터가 삭제되는 경우 삭제되는 레코드가 다른 테이블에서 참조되는 경우 데이터 삭제 제약 받음
-- on delete cascade 를 통해서 제약 무시, 참조 테이블 데이터 같이 삭제
ALTER TABLE student
ADD CONSTRAINT FK_STUDENT_DEPARTMENT
FOREIGN KEY (deptNo) REFERENCES department (deptNo)
on delete cascade;



--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

-- 테이블 삭제: 테이블 모든 구조와 데이터 삭제
-- 데이터 삭제: DML의 DELETE 사용
-- DROP TABLE 테이블명 [PURGE/CASCADE CONSTRAINTS]
-- PURGE 복구 가능한 임시테이블 생성하지 않고 영구 삭제
-- CASCADE CONSTRAINTS 제약조건 무시 강제 삭제

DROP TABLE department;
DROP TABLE department CASCADE CONSTRAINTS;

-- 참조 제약조건 상관없는 테이블
DROP TABLE product;








