
-- INSERT 연습문제
-- INSERT 문을 사용하여 student 테이블에 다음과 같이 행 삽입하고 SELECT 문으로 조회
-- 속성과 값을 모두 나열하는 방법
INSERT INTO student(stdNo, stdName, stdBirth, deptNo)
VALUES('20160001', '홍길동', '1997-01-01', '1');
-- 값만 나열하는 방법
INSERT INTO student VALUES('20150002', '성춘향', 3, '3', '1996-01-10');
-- 나머지는 전체 한번에 저장
INSERT ALL 
    INTO student VALUES('20140004', '이몽룡', 2, '2', '1996-03-03')
    INTO student VALUES('20160002', '변학도', 4, '1', '1995-05-07')
    INTO student VALUES('20150003', '손흥민', 3, '2', '1997-11-11')
SELECT * FROM DUAL;

SELECT * FROM STUDENT;