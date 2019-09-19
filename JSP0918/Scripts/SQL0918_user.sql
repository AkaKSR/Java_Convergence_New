show tables;
create table memo(
	idx int primary key auto_increment,
	name varchar(20) not null,
	password varchar(50) not null,
	memo text not null,
	regdate timestamp default now(),
	ip varchar(20) not null
);

show tables;
desc memo;

insert into memo (name,password,memo,regdate,ip)
values ('한사람','1234','blablablablablabla',now(),'192.168.5.24');

select * from memo;