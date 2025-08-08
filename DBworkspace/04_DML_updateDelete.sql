-- update
-- 특정 열의 값을 수정하는 명령어
-- 기본형식
-- UPDATE 테이블명 SET 속성명=값-> 특정 속성열의 모든 값을 동일한 값으로 변경
-- WHERE절을 사용-> 특정 튜플 지정

-- PRDNO 가 5인 상품을 찾아서 PRDNAME 을 UHD TV 로 변
UPDATE PRODUCT SET PRDNAME='UHD TV' WHERE PRDNO='5';

-- DELETE 문
-- 테이블의 기존 행을 삭제하는 명령어
-- DELETE FROM 테이블명 [WHERE 조건];-> 조건 생략시 테이블 모든 데이터 삭제
-- WHERE 조건 특정 튜플 삭제
-- DELETE 문으로 테이블 행 삭제-> 구성요소는 남아있음

-- DELETE FROM PRODUCT; -- 테이블의 모든 행 삭제
-- 상품명이 그늘막 텐트인 행 삭제
DELETE FROM PRODUCT WHERE PRDNAME='그늘막 텐트';

-- DELETE 문의 반환 결과는 몇개 행이 삭제되었는지에 대한 내용 포함
-- 삭제한 내용이 없으면 0개 행 삭제되었다는 결과 

SELECT * FROM PRODUCT;

-- DML 삽입 삭제 수정: 반환 결과가 성공한 튜플의 수 반환