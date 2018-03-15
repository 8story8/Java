create table account(
	num varchar2(13) primary key,
	name varchar2(15) not null,
	password varchar2(30) not null,
	balance number not null
)

create sequence account_seq;

select * from account;


