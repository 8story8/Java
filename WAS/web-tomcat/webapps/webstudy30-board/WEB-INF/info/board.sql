create table board(
	no number primary key,
	title varchar2(100) not null,
	writer varchar2(100) not null,
	password varchar2(20) not null,
	content clob not null,
	hits number default 0,
	time_posted date not null
)

drop table board;
drop sequence board_seq;
create sequence board_seq nocache;

insert into board(no,title,writer,password,content,time_posted)
values(board_seq.nextval,'첫번째게시물',
'아이유','1234','오늘은 리스트까지만',sysdate);

insert into board(no,title,writer,password,content,time_posted)
values(board_seq.nextval,'두번째게시물',
'정준영','1234','야탑에 오세요',sysdate);

select * from board;

SELECT no,title,writer,hits,to_char(time_posted,'YYYY.MM.DD') as time_posted from board order by no desc