create table memo_test(
	idx int primary key auto_increment,
	name varchar(20) not null,
	password varchar(50) not null,
	memo text not null,
	regdate timestamp default now(),
	ip varchar(20) not null
);

desc memo_test;

insert into memo_test (name,password,memo,regdate,ip)
values ('한사람','1234','Test',now(),'localhost');

select * from memo_test;