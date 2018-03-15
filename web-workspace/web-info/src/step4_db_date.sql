-- step4_db_date.sql
/*
date : Oracle 시간 데이터 타입
sysdate : 현재 시간
*/
-- dual table : Oracle에서 제공하는 기본 Table(varchar2 컬럼 하나로 구성)
select sysdate from dual;
select to_char(sysdate, 'YYYY/MM/DD HH24:MI:SS') from dual;

-- 연, 월, 일만 조회
select to_char(sysdate, 'YYYY/MM/DD') from dual;

-- 직접 Table을 만들어서 Test해본다.
create table date_test(
	id varchar2(50) primary key,
	mydate date not null
)

-- id : mydate는 현재 시간으로 insert해본다.
insert into date_test values('java', sysdate);
select * from date_test;

-- id가 java인 대상의 mydate를 년, 월, 일, 시, 분, 초까지 조회한다.
select to_char(sysdate, 'YYYY/MM/DD HH24:MI:SS') from date_test where id = 'java';

-- 특정 시간을 insert해본다.
-- 문자열 형식의 날짜 정보를 date 타입으로 insert하기 위해 to_date() 함수를 이용
insert into date_test values('spring', to_date('2017/1/1 9:00:10', 'YYYY/MM/DD HH:MI:SS'));

-- 시간 연산이 가능하다.
select id, sysdate-mydate from date_test;