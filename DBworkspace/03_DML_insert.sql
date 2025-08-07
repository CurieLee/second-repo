-- 데이터 조작어 (DML)
-- 데이터 입력/삭제/수정/검색

-- INSERT : 테이블에 데이터(튜플) 저장하는 조작
-- INSERT INTO 테이블명(열 이름 리스트) VALUES(값 리스트): 부분열만 저장 가능 - null 허용하는 열 생략 가능

-- INSERT INTO 테이블명 VALUES(값 리스트): 값 리스트에 모든 열의 값이 칼럼 순서에 맞게 나열

-- STUDENT TABLE insert 열 이름 나열 순서 상관없음 값 리스트->열 리스트 순서 따름
INSERT INTO STUDENT (stdNo, stdName, grade, deptNo)
VALUES ('20150000', '변학도', 4, '1');
-- 값 문자열 홑따옴표
