/*
Table 만들기
Table명 : typetest, column : name, money
Data Type : varchar(9) 문자열 데이터 타입 9는 영문자 기준, 한글은 3자
			    number 숫자 데이터 타입
Constraints : PK(Primary Key) -> Unique + Not Null
*/

create table typetest(
	name varchar2(9) primary key,
	money number not null
);

insert into typetest values('javaking', 100);

-- name이 javaking인 대상의 money를 조회
select money from typetest where name = 'javaking';

-- insert test, Table 생성시 최대 9자로 제한했으므로 Error
insert into typetest values('Barack Obama', 200);

-- insert ok
insert into typetest values('Barack', 200);
insert into typetest values('강정호', 200);

-- insert fail, 최대 9는 한글 3자까지 허용
insert into typetest values('최강정호', 200);

-- 조회시 연산
select name, money, money * 2 from typetest;

/*
DDL(create, drop, alter)
alter : Table 정보 변경 
*/

drop table typetest;

-- default 0은 제약 조건이므로 별도의 정보를 insert하지 않으면 기본값 0이 추가된다.
create table test1(
	id varchar2(100) primary key,
	hit number default 0
)

-- id가 java인 정보를 insert
insert into test1(id) values('java');

-- alter를 이용해 table명을 변경
alter table test1 rename to test2;

-- alter를 이용해 column명을 변경
/*
alter table 테이블명
rename column 변경해야할 column명 to 새로운 column명;
*/
alter table test2 rename column hit to count; 

/*
Table명 : product
column명 : id, name, maker, price
Data Type : id, name, maker는 모두 varchar2(100)
			    price는 number
Constraints : id는 primary key, 나머지는 not null

Table 생성 후 조회 결과
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
-- product 총 수량
select count(*) from product;

-- product price 최고가 조회
select max(price) from product;

-- product price 최저가 조회
select min(price) from product;

-- product price 평균가 조회
select avg(price) from product;

-- product price 평균가를 소수점 이하가 있을 때 올림하여 조회
select round(avg(price)) from product;

-- product price 평균가를 소수점 이하를 버리고 올림하여 조회
select ceil(avg(price)) from product;

-- product price 평균가를 소수점 이하를 버리고 조회
select floor(avg(price)) from product;

-- 정렬
-- price 오름차순
select * from product order by price asc;
-- price 내림차순
select * from product order by price desc;

-- price가 130이하인 product 정보를 조회
select * from product where price <= 130;

-- maker가 Samsung인 product의 id, name, price를 조회
-- price를 오름차순으로 조회
select id, name, price from product where maker = 'Samsung' order by price asc;

-- price가 100을 초과하고 120이하인 상품을 조회
select * from product where price > 100 and price <= 120;

-- 존재유무
select id from product;   -- id a, b, c가 존재
select count(*) from product where id = 'a';
select count(*) from product where id = 'd';

-- maker 종류 조회
select maker from product;

-- distinct 종류(중복 제거 후 종류만 조회)
select distinct maker from product; 

-- 조회시 별칭
select count(*) as 상품수 from product;
select name, price, price+100 as 추가가격 from product;

-- 할인가로 조회
select id, name, maker, price as 원가, price-(price/10) as 할인가 from product order by price desc;