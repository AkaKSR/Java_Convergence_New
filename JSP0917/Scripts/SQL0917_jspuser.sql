-- 테이블 목록 확인하기
show tables;

-- 모든 필드 모든 레코드 보이기
select
	*
from
	hr_employees;

/*
 * create: 만들기
 * alter: 수정하기
 * drop: 삭제하기
 * 
 * expression
 * database: 데이터베이스
 * table: 테이블
 */

-- 테이블 만들기
# create table 테이블명 (필드명 자료형(길이) 제약조건,.....)
/*
 * not null: 해당 필드는 null 값을 저장할 수 없게 된다.
 * unique: 해당 필드는 서로 다른 값을 가져야만 한다.
 * primary key: 해당 필드가 not null과 unique 제약 조건의 특징을 모두 가진다.
 * foreign key: 하나의 테이블을 다른 테이블에 의존하게 만든다.
 * default: 해당 필드의 기본값을 설정한다.
 */
create table Reservation(
	id int primary key auto_increment,
	name varchar(30) not null,
	ReserveDate date,
	roomnum int
);

create table Customer(
	id int primary key auto_increment,
	name varchar(30) not null,
	age int,
	address varchar(20)
);

show tables;

-- 테이블 구조확인
-- desc 테이블명
desc Reservation;
desc customer;

-- 데이터 넣기
-- insert into 테이블명 (필드명,...) values (데이터....);
insert into reservation(name, ReserveDate, roomnum) values ('홍길동', '2016-01-05', 2014);
insert into reservation(name, ReserveDate, roomnum) values ('임꺽정', '2016-02-12', 918);
insert into reservation(name, ReserveDate, roomnum) values ('장길산', '2016-01-16', 1208);
insert into reservation(name, ReserveDate, roomnum) values ('홍길동', '2016-03-17', 504);

insert into customer(name, age, address) values ('홍길동', 17, '서울');
insert into customer(name, age, address) values ('임꺽정', 11, '인천');
insert into customer(name, age, address) values ('장길산', 13, '서울');
insert into customer(name, age, address) values ('전우치', 17, '수원');

-- 테이블 읽기
select * from reservation;
select * from customer;

-- 변경 내용을 DB에 적용
commit;

-- 테이블 수정
-- 1. 열 추가하기
--    alter table 테이블이름 add 필드이름 필드타입
alter table customer add zipcode varchar(20);

-- 2. 열 삭제하기
--    alter table 테이블이름 drop 필드이름
alter table customer drop zipcode;

-- 3. 열 수정하기
--    alter table 테이블이름 modify column 필드이름 필드타입
alter table customer modify column address varchar(50);

-- Customer 테이블 구조확인
desc customer;

create table temp(
	idx int primary key auto_increment,
	name varchar(50) not null
);

show tables;

-- 테이블 삭제
--  drop table 테이블명;
drop table temp;

-- select 결과로 테이블 생성
-- create table 생성할테이블명 as select (가져올필드값, ....) from 참조할테이블명
-- 이 경우 Key와 Extra가 사라진 상태로 생성된다.
create table temp as select id, name from customer;

drop table temp;

show tables;

INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(5, '이순신', '2016-02-16', 1108);
INSERT INTO Reservation(ID, Name) values (6, '김유신');
INSERT INTO Reservation(ID) values (6); -- name이 not null이라 에러

select * from reservation;

INSERT INTO Reservation(Name) values ('김유신');

-- 수정하기
-- update 테이블명 set 필드명=값, .... where 조건
-- 주의사항
-- 조건을 쓰지 않으면 모든 레코드가 수정된다.
select * from reservation;
create table temp as select * from customer;
select * from temp;

-- 나이를 모두 1살씩 증가 시키기
update temp set age = age+1;
update temp set age = age+1 where address='서울';

-- 레코드 삭제
-- delete from 테이블명 where 조건
-- 주의사항
-- 조건을 생략하면 전체 레코드 모두 삭제
delete from temp where name='장길산';
select * from temp;
delete from temp;
select * from temp;

-- 레코드 선택
-- select 필드명 from 테이블명 [where 조건]
select * from temp;

select *
from hr_employees;

-- limit 시작인덱스, 갯수
select *
from hr_employees limit 0, 5;
select *
from hr_employees limit 10, 5;

-- order by: 정렬
-- order by 필드명, ....
-- order by 필드명 [desc], ....
select * from hr_employees order by last_name; -- 오름차순
select * from hr_employees order by last_name desc; -- 내림차순

-- 부서 오름차순 연봉 내림차순
select first_name, last_name, department_id, salary
from hr_employees order by `DEPARTMENT_ID`, `SALARY` desc;

-- select문에 where로 조건 대입
select
	`FIRST_NAME`, `LAST_NAME`, `SALARY`
from
	hr_employees
where
	`DEPARTMENT_ID`=20;

-- where 조건문에 or 대입
-- 이 경우 해당 조건에 만족하는 결과만 출력
select
	`FIRST_NAME`, `LAST_NAME`, `SALARY`, `DEPARTMENT_ID`
from
	hr_employees
where
	`DEPARTMENT_ID`=10 or `DEPARTMENT_ID`=20;

-- or 대신에 in 사용
-- 결과는 or를 사용하는것과 동일
select
	`FIRST_NAME`, `LAST_NAME`, `SALARY`
from
	hr_employees
where
	`DEPARTMENT_ID` in (10,20);

-- <, >와 and를 사용하는 조건
select
	`FIRST_NAME`, `LAST_NAME`, `SALARY`
from
	hr_employees
where
	`SALARY` > 5000 and `SALARY` < 7000;

-- between (A) and (B)
-- A 이상 B 이하의 값을 출력하는 조건
select
	`FIRST_NAME`, `LAST_NAME`, `SALARY`
from
	hr_employees
where
	`SALARY` between 5000 and 7000;

-- distinct: 중복 제거
select name from reservation;
select distinct name from reservation; -- 중복된 값은 제외하고 보여준다.

-- 별칭 지정
select name 이름 from reservation;
select name "이 름" from reservation;
select name as "이 름" from reservation;

select concat(name,' ',roomnum) "이름(방번호)" from reservation order by 1;
select * from reservation where roomnum is not null;
select * from reservation where roomnum is null;

-- 1. 연봉이 12000 이상되는 직원들의 LAST_NAME 및 연봉을 조회한다.
select
	`LAST_NAME`, `SALARY`
from
	hr_employees
where
	`SALARY`> 12000;

-- 2. 사원번호가 176 인 사람의 LAST_NAME 과 부서 번호를 조회한다.
select
	`LAST_NAME`, `DEPARTMENT_ID`
from
	hr_employees
where
	`EMPLOYEE_ID`=176;
	
-- 3. 연봉이 5000 에서 12000의 범위 이외인 사람들의 LAST_NAME 및 연봉을 조회힌다.
select
	`LAST_NAME`, `SALARY`
from
	hr_employees
where
	`SALARY` not between 5000 and 12000;
	
-- 4. 1998/02/20 일부터 1998/05/01 사이에 고용된 사원들의 LAST_NAME 사번, 고용일자를 조회한다.
-- 고용일자 순으로 정렬한다.
select
	`LAST_NAME`, `EMPLOYEE_ID`, `HIRE_DATE`
from
	hr_employees
where
	`HIRE_DATE` between "1998-02-20" and "1998-05-01" order by `HIRE_DATE`;

select
	`LAST_NAME`, `EMPLOYEE_ID`, `HIRE_DATE`
from
	hr_employees
where
	`HIRE_DATE`>='1998/02/20' and `HIRE_DATE`<= '1998/05/01' order by `HIRE_DATE`;
	
select
	`LAST_NAME`, `EMPLOYEE_ID`, `HIRE_DATE`
from
	hr_employees
where
	year(`HIRE_DATE`)=1998 and month(`HIRE_DATE`) in (2, 3, 4, 5);

-- 5. 20 번 및 50 번 부서에서 근무하는 모든 사원들의 
-- LAST_NAME 및 부서 번호를 알파벳순으로 조회한다.
select
	`LAST_NAME`, `DEPARTMENT_ID`
from
	hr_employees
where
	`DEPARTMENT_ID` in (20, 50) order by `LAST_NAME`;

-- 6. 20 번 및 50 번 부서에 근무하며, 연봉이 5000 ~ 12,000 사이인 사원들의 LAST_NAME 및 연봉을 조회한다.
select
	`LAST_NAME`, `SALARY`
from
	hr_employees
where
	`DEPARTMENT_ID` in (20, 50) and `SALARY` between 5000 and 12000;

-- 7. 1994년도에 고용된 모든 사람들의 LAST_NAME 및 고용일을 조회한다.
select
	`LAST_NAME`, `HIRE_DATE`
from
	hr_employees
where
	year(`HIRE_DATE`)=1994;
	
-- 8. 매니저가 없는 사람들의 LAST_NAME 및 JOB_ID 를 조회한다.
select
	`LAST_NAME`, `JOB_ID`
from
	hr_employees
where
	`MANAGER_ID` is null;

-- Ex. 이번달 입사자 출력(연도 무시)
select
	`FIRST_NAME`, `LAST_NAME`, `HIRE_DATE`
from
	hr_employees
where
	month(`HIRE_DATE`)=month(now());

-- 9. 커미션을 버는 모든 사원들의 LAST_ANME, 연봉 및 커미션을 조회한다.
-- 연봉 역순, 커미션 역순차로 정렬한다.
select
	`LAST_NAME`, `SALARY`, `COMMISSION_PCT`
from
	hr_employees
where
	`COMMISSION_PCT` is not null order by `SALARY` desc, `COMMISSION_PCT` desc;

-- 10. LAST_NAME 의 네번째 글자가 a 인 사원들의 LAST_NAME 을 조회한다.
select
	`LAST_NAME`
from
	hr_employees
where
	`LAST_NAME` like '___a%';

-- 11. LAST_NAME 에 a 및 e 글자가 있는 사원들의 LAST_NAME 을 조회힌다.
select
	`LAST_NAME`
from
	hr_employees
where
	`LAST_NAME` like '%a%' or `LAST_NAME` like '%e%';

-- 12. 연봉이 2,500, 3,500, 7000 이 아니며 직업이 SA_REP 이나 ST_CLERK 인 사람들을 조회한다.
select
	`LAST_NAME`, `JOB_ID`, `SALARY`
from
	hr_employees
where
	`SALARY` not in (2500, 3500, 7000) and `JOB_ID` in ("SA_REP", "ST_CLERK");

/*
13. 직업이 AD_PRESS 인 사람은 A 등급을, 
           ST_MAN 인 사람은 B 등급을,
           IT_PROG 인 사람은 C 등급을,
           SA_REP 인 사람은 D 등급을,
           ST_CLEAK 인 사람은 E 등급을 
           기타는 0 을 부여하여 조회한다.
 */
select
	if(`JOB_ID`='ad_pres', 'A',
		if(`JOB_ID`='st_man', 'B',
			if(`JOB_ID`='it_prog', 'C',
				if(`JOB_ID`='sa_rep', 'D',
					if(`JOB_ID`='st_cleak', 'E', '0'))))) 등급
from
	hr_employees order by 1 desc;

select
	concat(`FIRST_NAME`, ' ', `LAST_NAME`) 이름,
	`JOB_ID` 직업,
	case `JOB_ID`
		when 'ad_pres' then 'A'
		when 'st_man' then 'B'
		when 'it_prog' then 'C'
		when 'sa_rep' then 'D'
		when 'st_cleak' then 'E'
	else
		'0'
	end 등급
from
	hr_employees order by 3 desc;

-- 14. 모든 사원들의 LAST_NAME, 부서 번호 및 부서 이름을 조회한다.
select
	`LAST_NAME`, a.`DEPARTMENT_ID`, b.`DEPARTMENT_NAME`
from
	hr_employees A, hr_departments B
where
	a.`DEPARTMENT_ID` = b.`DEPARTMENT_ID`;

-- 15. 부서번호 30 내의 모든 직업들을 유일한 포맷으로 조회한다. 
--     90 부서 또한 포함한다.
select distinct
	a.`JOB_ID`, b.`LOCATION_ID`
from
	hr_employees A, hr_departments B
where
	a.`DEPARTMENT_ID` in (30, 90);

-- 16. 커미션을 버는 모든 사람들의 
-- LAST_NAME, 부서 명, 지역 ID 및 도시 명을 조회한다.
select
	a.`LAST_NAME`, b.`DEPARTMENT_NAME`, c.`LOCATION_ID`, c.`CITY`
from
	hr_employees A, hr_departments B, hr_locations C
where
	a.`COMMISSION_PCT` is not null
	and
	a.`DEPARTMENT_ID`=b.`DEPARTMENT_ID`
	and
	b.`LOCATION_ID`=c.`LOCATION_ID`;

-- 17. LAST_NAME 이 DAVIES 인 사람보다 후에 고용된 사원들의 LAST_NAME 및 HIRE_DATE 을 조회한다.
select
	`LAST_NAME`, `HIRE_DATE`
from
	hr_employees
where
	`HIRE_DATE` >= (select `HIRE_DATE` from hr_employees where `LAST_NAME`='davies');

-- 18. 자신의 매니저보다 먼저 고용된 사원들의 LAST_NAME 및 고용일을 조회한다. (셀프조인)
select
	a.`LAST_NAME`, a.`HIRE_DATE`, b.`LAST_NAME`, b.`HIRE_DATE`
from
	hr_employees A, hr_employees B
where
	a.`MANAGER_ID`=b.`EMPLOYEE_ID`
	and
	a.`HIRE_DATE`<b.`HIRE_DATE`;

-- 19. 회사 전체의 최대 연봉, 최소 연봉, 연봉 총 합 및 평균 연봉을 자연수로 포맷하여 조회한다.
select
	max(`SALARY`) "최대 연봉",
	min(`SALARY`)"최소 연봉",
	sum(`SALARY`) "연봉 합계",
	round(avg(`SALARY`)) "연봉 평균",
	count(`SALARY`)"사원수"
from
	hr_employees;

-- 20. 각 JOB_ID 별, 최대 연봉, 최소 연봉, 연봉 총 합 및 평균 연봉을 자연수로 포맷하여 조회한다.
select
	`JOB_ID`, max(`SALARY`), min(`SALARY`), sum(`SALARY`), round(avg(`SALARY`))
from
	hr_employees
group by `JOB_ID`;

select
	`JOB_ID`, max(`SALARY`), min(`SALARY`), sum(`SALARY`), round(avg(`SALARY`))
from
	hr_employees
group by `JOB_ID`

select * from hr_employees;
select * from hr_departments;
select * from hr_locations;
select * from hr_jobs;
select * from hr_job_history;