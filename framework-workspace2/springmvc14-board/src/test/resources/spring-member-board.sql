drop sequence spring_board_seq;
create sequence spring_board_seq;

drop table spring_member;

create table spring_member(
 id varchar2(100) primary key,
 password varchar2(100) not null,
 name varchar2(100) not null,
 address varchar2(100) not null
);


insert into spring_member(id,password,name,address) values('bourbon','0000','아무로 토오루','Tokyo');
insert into spring_member(id,password,name,address) values('java','1234','정우성','판교');
insert into spring_member(id,password,name,address) values('spring','1234','전지현','강남');

drop table spring_board;
create table spring_board(
	no number primary key,
	title varchar2(50) not null,
    content clob not null,
	hits number default 0,
	time_posted date not null,
	id varchar2(100) not null,
	constraint spring_board_inst_fk foreign key(id) references spring_member(id)
)
-- 현 시퀀스의 다음 값을 조회 
select spring_board_seq.nextval from dual;

insert into spring_board(no,title,content,time_posted,id) 
values(spring_board_seq.nextval,'방가','ㅋㅋ',sysdate,'java');
insert into spring_board(no,title,content,time_posted,id) 
values(spring_board_seq.nextval,'안녕','치맥',sysdate,'spring');
insert into spring_board(no,title,content,time_posted,id) 
values(spring_board_seq.nextval,'방가','ㅋㅋ',sysdate,'java');
insert into spring_board(no,title,content,time_posted,id) 
values(spring_board_seq.nextval,'안녕','치맥',sysdate,'spring');
insert into spring_board(no,title,content,time_posted,id) 
values(spring_board_seq.nextval,'방가','ㅋㅋ',sysdate,'java');
insert into spring_board(no,title,content,time_posted,id) 
values(spring_board_seq.nextval,'안녕','치맥',sysdate,'spring');
select * from spring_board;
-- 페이징 sql 
SELECT b.no,b.title,b.time_posted,b.hits,b.id,m.name FROM(
	SELECT row_number() over(order by no desc) as rnum,no,title,hits,
	to_char(time_posted,'YYYY.MM.DD') as time_posted,id
	FROM spring_board
	) b,spring_member m where b.id=m.id and rnum between 1 and 5 
order by no desc;


-- 개별 게시물 조회
select b.title,to_char(b.time_posted,'YYYY.MM.DD') as time_posted,b.content,
b.hits,b.id,m.name from spring_board_inst b,spring_member m  where b.id=m.id and b.no=2;

select * from spring_board;







