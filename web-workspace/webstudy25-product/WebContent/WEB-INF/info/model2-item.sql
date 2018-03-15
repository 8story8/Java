create table MVC_Item(
	itemNo number primary key,
	itemName varchar2(30) not null,
	itemMaker varchar2(30) not null,
	itemPrice number not null,
	itemDate date not null
);

create sequence MVC_Item_seq;

select * from MVC_Item;
insert into MVC_Item values(mvcItem_seq.nextval, 'Galaxy S8', 'Samsung', 120, sysdate);