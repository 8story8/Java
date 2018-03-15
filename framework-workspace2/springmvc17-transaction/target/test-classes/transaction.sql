drop table member_tx;
create table member_tx(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null
);

insert into member_tx values('bourbon', '1234', '아무로 토오루', 'Tokyo');

drop table point_tx;
create table point_tx(
	id varchar2(100) primary key,
	point number not null,
	point_type varchar2(100) not null,
	constraint fk_tx_id foreign key(id) references member_tx
);

insert into point_tx values('bourbon', 100, 'CGV');

-- 부모키가 없습니다.
insert into point_tx values('vermouth', 100, 'CGV');

select * from member_tx;
select * from point_tx;

delete from point_tx;
delete from member_tx;