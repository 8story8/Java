
create table report(
	keyword varchar2(100) primary key,
	count number default 1
);

select r.* from (select RANK() OVER(order by count desc) as rank, keyword, count from report) r where r.rank between 1 and 5;

insert into report values('삼성', 1);
insert into report values('Galaxy S7', 2);
insert into report values('LG', 2);
insert into report values('G7', 3);
insert into report values('Apple', 4);

select RANK() OVER(order by count desc) as rank, keyword, count from report;

select * from report;

-- RANK() OVER() 함수
-- rank() over() : 순위 조회 기능 
drop table persontest;
create table persontest(
 name varchar2(30) primary key,
 age number not null
)
insert into persontest values('태연',27);
insert into persontest values('유리',23);
insert into persontest values('태진아',57);
insert into persontest values('아이유',23);
insert into persontest values('손연재',20);
insert into persontest values('김연아',24);
insert into persontest values('박지성',30);

select name,age,rank() over(order by age desc) as ranking from persontest;

-- 3위까지만 조회해보자 
-- subquery 이름 나이 순위 
select name,age,ranking from(
 select name,age,rank() over(order by age desc) as ranking from persontest
 ) where ranking<=3