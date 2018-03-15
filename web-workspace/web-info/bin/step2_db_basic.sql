/*
Table �����
Table�� : typetest, column : name, money
Data Type : varchar(9) ���ڿ� ������ Ÿ�� 9�� ������ ����, �ѱ��� 3��
			    number ���� ������ Ÿ��
Constraints : PK(Primary Key) -> Unique + Not Null
*/

create table typetest(
	name varchar2(9) primary key,
	money number not null
);

insert into typetest values('javaking', 100);

-- name�� javaking�� ����� money�� ��ȸ
select money from typetest where name = 'javaking';

-- insert test, Table ������ �ִ� 9�ڷ� ���������Ƿ� Error
insert into typetest values('Barack Obama', 200);

-- insert ok
insert into typetest values('Barack', 200);
insert into typetest values('����ȣ', 200);

-- insert fail, �ִ� 9�� �ѱ� 3�ڱ��� ���
insert into typetest values('�ְ���ȣ', 200);

-- ��ȸ�� ����
select name, money, money * 2 from typetest;

/*
DDL(create, drop, alter)
alter : Table ���� ���� 
*/

drop table typetest;

-- default 0�� ���� �����̹Ƿ� ������ ������ insert���� ������ �⺻�� 0�� �߰��ȴ�.
create table test1(
	id varchar2(100) primary key,
	hit number default 0
)

-- id�� java�� ������ insert
insert into test1(id) values('java');

-- alter�� �̿��� table���� ����
alter table test1 rename to test2;

-- alter�� �̿��� column���� ����
/*
alter table ���̺��
rename column �����ؾ��� column�� to ���ο� column��;
*/
alter table test2 rename column hit to count; 

/*
Table�� : product
column�� : id, name, maker, price
Data Type : id, name, maker�� ��� varchar2(100)
			    price�� number
Constraints : id�� primary key, �������� not null

Table ���� �� ��ȸ ���
id		name			maker		price
a		Galaxy S7 	Samsung 	150
b		Galaxy S6	Samsung 	100
c		iPhone 6		Apple 		120
*/

create table product(
	id varchar2(100) primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
);

insert into product values('a', 'Galaxy S7', 'Samsung', 150);
insert into product values('b', 'Galaxy S6', 'Samsung', 100);
insert into product values('c', 'iPhone 6', 'Apple', 120);

-- oracle function
-- product �� ����
select count(*) from product;

-- product price �ְ� ��ȸ
select max(price) from product;

-- product price ������ ��ȸ
select min(price) from product;

-- product price ��հ� ��ȸ
select avg(price) from product;

-- product price ��հ��� �Ҽ��� ���ϰ� ���� �� �ø��Ͽ� ��ȸ
select round(avg(price)) from product;

-- product price ��հ��� �Ҽ��� ���ϸ� ������ �ø��Ͽ� ��ȸ
select ceil(avg(price)) from product;

-- product price ��հ��� �Ҽ��� ���ϸ� ������ ��ȸ
select floor(avg(price)) from product;

-- ����
-- price ��������
select * from product order by price asc;
-- price ��������
select * from product order by price desc;

-- price�� 130������ product ������ ��ȸ
select * from product where price <= 130;

-- maker�� Samsung�� product�� id, name, price�� ��ȸ
-- price�� ������������ ��ȸ
select id, name, price from product where maker = 'Samsung' order by price asc;

-- price�� 100�� �ʰ��ϰ� 120������ ��ǰ�� ��ȸ
select * from product where price > 100 and price <= 120;

-- ��������
select id from product;   -- id a, b, c�� ����
select count(*) from product where id = 'a';
select count(*) from product where id = 'd';

-- maker ���� ��ȸ
select maker from product;

-- distinct ����(�ߺ� ���� �� ������ ��ȸ)
select distinct maker from product; 

-- ��ȸ�� ��Ī
select count(*) as ��ǰ�� from product;
select name, price, price+100 as �߰����� from product;

-- ���ΰ��� ��ȸ
select id, name, maker, price as ����, price-(price/10) as ���ΰ� from product order by price desc;