/*
SQL(Structured Query Language) : 구조적 질의 언어
											  DataBase 제어 언어
1. DDL(Data Definition Language) 
   create : table 생성
   drop : table 삭제
   alter : table 정보 수정
2. DML(Data Definition Language)
   insert : 정보 추가
   update : 정보 수정
   delete : 정보 삭제
3. DQL(Data Query Language)
   select : 정보 조회
4. DCL(Data Control Language)
   commit : Transaction(작업 단위)의 작업 결과를 실제로 반영
   rollback : Transaction의 작업 결과를 취소하고 원래대로 복구
   grant : 권한 부여
*/

-- member table에 회원 정보를 삽입
insert into member(id, password, name, address)
values('saiden', 'tkd2el16', '문성준', '미금역');

-- member table의 정보를 조회
select * from member;

-- member table을 삭제
drop table member;

-- member table을 생성
/*
member : 테이블명
id, password, name, address : 컬럼명

데이터 타입
varchar2(100) : Oracle 문자열 타입
number : Oracle 숫자 타입

제약 조건
--> primary key : Unique + not null
     not null : null을 허용하지 않는다.
*/

create table member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100)
);

-- member table에 회원 정보를 삽입
-- ORA-00001 : 무결성 제약 조건(SCOTT.SYS_C004001)에 위배됩니다.
-- 위와 같은 Error가 존재해야 한다.
-- id가 중복되므로 Error가 나고 추가가 되지 않는다.
insert into member(id, password, name, address)
values('saiden', 'tkd2el16', '사사키 하이세', '도쿄');

insert into member(id, password, name, address)
values('sasaki', 'tkd2el16', '사사키 하이세', '도쿄');

insert into member(id, password, name, address)
values('crocodile', '1234', '크로커다일', '알라바스타');

-- name 컬럼에 not null 제약 조건이 있어서 반드시 name을 insert해야 한다.
-- Error가 발생
insert into member(id, password, address)
values('sasaki', 'tkd2el16', '도쿄');

-- 가능, address는 별도의 제약 조건이 없으므로 insert하지 않아도 된다.
insert into member(id, password, name)
values('crocodile', '1234', '크로커다일');

-- 전체 회원 정보
select * from member;

-- 회원 수 조회
select count(*) from member;

-- 회원 이름 조회
select name from member;

-- 회원 아이디와 주소 조회
select id, address from member;

-- 아이디가 sasaki인 회원의 이름과 주소를 조회
select name, address from member where id = 'sasaki';

-- 아이디가 crocodile이고 패스워드가 1234인 회원의 이름과 주소를 조회
select name, address from member where id = 'crocodile' and password = '1234';

-- 회원 주소가 null인 회원을 조회
select id, name from member where address is null;

-- 회원 주소가 not null인 회원을 조회
select id, name from member where address is not null;

-- 정보 수정 update
update member set id = 'pig', name = '돼지' where id = 'crocodile';

-- 수정 결과 확인 id가 pig인 member의 name을 조회
select name from member where id = 'pig';

-- address가 null인 member의 주소를 판교로 수정
update member set address = '판교' where address is null;

-- address가 판교인 member의 id, name 정보를 조회
select id, name from member where address = '판교';

-- member 정보를 추가
insert into member(id, password, name, address) values('jdbc', 'abcd', '설현', '부천');

-- id가 jdbc인 member를 조회
select * from member where id = 'jdbc';

-- 도쿄 address에 사는 회원 이름을 루피로 수정
update member set name = '루피' where address = '도쿄';

-- 크로커다일 이름의 회원 이름을 황윤상으로 수정
update member set name = '도플라밍고' where name = '크로커다일';

-- 삭제 : delete
delete from member where name = '설현';

-- 실제 DB에 작업 결과를 반영
commit

-- 정렬
select id, password, name, address from member
order by id asc;

-- address가 판교인 회원의 수 조회
select count(*) from member where address = '판교';















