
/* SPRING SECURITY 를 적용할 경우 
 * 회원 가입시 비즈니스 계층(서비스)에서  회원가입과 권한을 함께 insert하도록 처리한다 (트랜잭션 처리 필요!)
 */
drop table security_member;
create table security_member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null,
	enabled number default 1 not null 
)
delete from security_member;
commit
select * from security_member;


-- 아이디는 userid , 패스워드는 password , 
--탈퇴여부(0은 탈퇴, 1은 가입상태)는 enabled 로 별칭주면 된다 
insert into security_member(id,password,name,address,enabled) 
values('java','1234','아이유','판교',1);

select id,password,name,address,enabled from security_member
where id='java' and enabled=1;

/*
 * SPRING SECURITY는 권한이 일치하는 대상에 대해 인가하기 때문에 
   관리자 권한 즉, ROLE_ADMIN을 보유하고 있더라도 
   사용자 권한인 ROLE_USER를 보유하고 있지 않을 경우 접근을 못하게 된다 
   따라서 한 유저는 여러개의 권한(1:n)을 보유할 수 있어야 하므로 테이블을 생성한다 
 */
drop table authorities;
create table authorities(
	username varchar2(100) not null,
	authority varchar(30) not null,
	constraint fk_authorities foreign key(username) references security_member(id),
	constraint member_authorities primary key(username,authority)
)
delete from authorities;
insert into authorities(username,authority) values('java','ROLE_ADMIN');
insert into authorities(username,authority) values('java','ROLE_MEMBER');

select * from authorities;

commit







