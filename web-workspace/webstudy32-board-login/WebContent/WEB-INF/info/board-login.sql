create table mem(
   mid varchar2(100) primary key,
   mname varchar2(100) not null,
   mpass varchar2(100) not null
)

insert into mem values('user', 'bourbon', '1');
insert into mem values('admin', 'jin', '1');

create table mboard(
   no number primary key,
   title varchar2(100) not null,
   content clob not null,
   hits number default 0,
   time_posted date not null,
   mid varchar2(100) not null,
   constraint fk_mid foreign key(mid) references mem(mid)
)

insert into mboard values(mboard_seq.nextval, '안녕^^', '잘 부탁해;;', 0, sysdate, 'user');
insert into mboard values(mboard_seq.nextval, '응?', '머냐 너?', 0, sysdate, 'admin');
insert into mboard(no, title, content, time_posted, mid) values(mboard_seq.nextval, '나대지마 진심^^', '조심하자!', sysdate, (select mid from mem where mid='admin'));
select * from mboard;
create sequence mboard_seq nocache;