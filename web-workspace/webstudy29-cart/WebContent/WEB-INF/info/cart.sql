drop table item;

create table item(
	itemNo number primary key,
	itemName varchar2(200) not null,
	itemMaker varchar2(200) not null,
	itemPrice number not null,
	itemDetail varchar2(2000) not null
);

drop sequence item_seq;
create sequence item_seq;

select * from member;

insert into item values(item_seq.nextval, 'Galaxy S8', 'Samsung', 120, '제대로 만들었습니다!');
delete from item where itemNo = '1';
select * from member;
