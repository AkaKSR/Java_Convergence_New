-- 테이블 목록 확인
show tables;

-- 테이블 작성
-- create table 테이블명 (필드명 자료형 제약조건, ....);
create table person(
	-- 필드명 자료형
	-- primary: 기본키
	-- key auto_increment: 키값은 자동으로 입력한다.
	idx int(5) primary key auto_increment,
	-- varchar(): 문자열
	-- not null: 비어있으면 안된다.
	name varchar(20) not null,
	-- default: 기본값
	age int(3) default 0
);

-- 테이블 구조 확인하기
-- desc 테이블명
desc person;

-- 테이블 내용 확인
-- select 필드명, .... from 테이블명 where 조건 ....
select * from person; -- person테이블의 모든 필드, 모든 레코드 표시 

-- 데이터 입력
-- insert into 테이블명 (필드명....) values (값....)
insert into person (name) value ('한사람');

select * from person;

-- 기본키는 중복되면 안된다.
-- insert into person (idx,name,age) value (1,'한사람',23);
insert into person (idx,name,age) value ('','한사람',23);
insert into person (name,age) value ('한사람',23);
insert into person (age,name) value (11,'한사람');

select * from person;

show tables;

desc hr_employees;
select * from hr_employees;

-- 조회명령
-- select 표시할 내용
select 1+1;
select '바보',3+4;
-- select 필드명, ... from 테이블명; -- 모든 레코드의 지정 필드만 확인
-- 필드명에 *을 쓰면 모든 필드
select * from hr_employees; -- hr_employees 테이블의 모든 필드 확인

-- concat: 문자열 더하기
select
-- 	concat(A.FIRST_NAME, A.LAST_NAME) 이름, A.HIRE_DATE 입사일
	concat(FIRST_NAME, ' ', LAST_NAME) 이름, HIRE_DATE 입사일
from
	hr_employees A;

-- 별칭에 공백이 들어가면 에러
-- 별칭에 공백을 넣을려면 "" 안에 넣어줘야 한다.
select
-- 	concat(A.FIRST_NAME, A.LAST_NAME) 이름, A.HIRE_DATE 입사일
-- 	concat(FIRST_NAME, ' ', LAST_NAME) 이 름, HIRE_DATE 입사일
	concat(FIRST_NAME, ' ', LAST_NAME) "이 름", HIRE_DATE 입사일,
	A.`EMAIL`, email
from
	hr_employees A;
	
select
	dept.`DEPARTMENT_ID`, dept.`DEPARTMENT_NAME`
from
	hr_departments DEPT;
	
select * from person;