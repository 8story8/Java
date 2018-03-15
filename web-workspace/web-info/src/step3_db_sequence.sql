/*
Oracle Sequence
- Unique값을 생성하기 위한 용도
- 주로 Primary Key값 생성시 사용한다.
- 일련의 번호를 순차적으로 증가시킨다.
- Table과 독립적으로 생성되고 저장된다.
*/

-- sequence 생성
create sequence seq_test;

-- sequence 삭제
drop sequence seq_test;

/*
다음 sequence값을 반환 : 시퀀스명.nextval
dual table : Oracle에서 제공하는 기본 테이블
			    varchar2 타입의 컬럼 하나로 구성된 테이블로서,
			    주로 함수 실행을 위해 사용된다.
 */
select seq_test.nextval from dual;

create table car(
	car_no number primary key,
	model varchar2(100) not null,
	price number default 0
);

-- car 테이블에서 이용할 car sequence 생성
create sequence car_seq;

-- sequence를 이용해 차 번호를 생성해 입력한다.
insert into car(car_no, model, price) values(car_seq.nextval, 'k5', 1000);
insert into car(car_no, model, price) values(car_seq.nextval, 'sm5', 1200);

/*
Table : memo
Column : 		memo_no, 	title, 			content
Type : 			number 		varchar2 		varchar2
Constraints : 	pk				not null		not null

memo_no : sequence를 이용(sequence명 : memo.seq)
*/

create sequence memo_seq;

create table memo(
	memo_no number primary key,
	title varchar2(100) not null,
	content varchar2(100) not null
);

insert into memo(memo_no, title, content) values(memo_seq.nextval, '안녕', '오냐');

select * from car;
