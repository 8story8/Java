/*
SQL(Structured Query Language) : ������ ���� ���
											  DataBase ���� ���
1. DDL(Data Definition Language) 
   create : table ����
   drop : table ����
   alter : table ���� ����
2. DML(Data Definition Language)
   insert : ���� �߰�
   update : ���� ����
   delete : ���� ����
3. DQL(Data Query Language)
   select : ���� ��ȸ
4. DCL(Data Control Language)
   commit : Transaction(�۾� ����)�� �۾� ����� ������ �ݿ�
   rollback : Transaction�� �۾� ����� ����ϰ� ������� ����
   grant : ���� �ο�
*/

-- member table�� ȸ�� ������ ����
insert into member(id, password, name, address)
values('saiden', 'tkd2el16', '������', '�̱ݿ�');

-- member table�� ������ ��ȸ
select * from member;

-- member table�� ����
drop table member;

-- member table�� ����
/*
member : ���̺��
id, password, name, address : �÷���

������ Ÿ��
varchar2(100) : Oracle ���ڿ� Ÿ��
number : Oracle ���� Ÿ��

���� ����
--> primary key : Unique + not null
     not null : null�� ������� �ʴ´�.
*/

create table member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100)
);

-- member table�� ȸ�� ������ ����
-- ORA-00001 : ���Ἲ ���� ����(SCOTT.SYS_C004001)�� ����˴ϴ�.
-- ���� ���� Error�� �����ؾ� �Ѵ�.
-- id�� �ߺ��ǹǷ� Error�� ���� �߰��� ���� �ʴ´�.
insert into member(id, password, name, address)
values('saiden', 'tkd2el16', '���Ű ���̼�', '����');

insert into member(id, password, name, address)
values('sasaki', 'tkd2el16', '���Ű ���̼�', '����');

insert into member(id, password, name, address)
values('crocodile', '1234', 'ũ��Ŀ����', '�˶�ٽ�Ÿ');

-- name �÷��� not null ���� ������ �־ �ݵ�� name�� insert�ؾ� �Ѵ�.
-- Error�� �߻�
insert into member(id, password, address)
values('sasaki', 'tkd2el16', '����');

-- ����, address�� ������ ���� ������ �����Ƿ� insert���� �ʾƵ� �ȴ�.
insert into member(id, password, name)
values('crocodile', '1234', 'ũ��Ŀ����');

-- ��ü ȸ�� ����
select * from member;

-- ȸ�� �� ��ȸ
select count(*) from member;

-- ȸ�� �̸� ��ȸ
select name from member;

-- ȸ�� ���̵�� �ּ� ��ȸ
select id, address from member;

-- ���̵� sasaki�� ȸ���� �̸��� �ּҸ� ��ȸ
select name, address from member where id = 'sasaki';

-- ���̵� crocodile�̰� �н����尡 1234�� ȸ���� �̸��� �ּҸ� ��ȸ
select name, address from member where id = 'crocodile' and password = '1234';

-- ȸ�� �ּҰ� null�� ȸ���� ��ȸ
select id, name from member where address is null;

-- ȸ�� �ּҰ� not null�� ȸ���� ��ȸ
select id, name from member where address is not null;

-- ���� ���� update
update member set id = 'pig', name = '����' where id = 'crocodile';

-- ���� ��� Ȯ�� id�� pig�� member�� name�� ��ȸ
select name from member where id = 'pig';

-- address�� null�� member�� �ּҸ� �Ǳ��� ����
update member set address = '�Ǳ�' where address is null;

-- address�� �Ǳ��� member�� id, name ������ ��ȸ
select id, name from member where address = '�Ǳ�';

-- member ������ �߰�
insert into member(id, password, name, address) values('jdbc', 'abcd', '����', '��õ');

-- id�� jdbc�� member�� ��ȸ
select * from member where id = 'jdbc';

-- ���� address�� ��� ȸ�� �̸��� ���Ƿ� ����
update member set name = '����' where address = '����';

-- ũ��Ŀ���� �̸��� ȸ�� �̸��� Ȳ�������� ����
update member set name = '���ö�ְ�' where name = 'ũ��Ŀ����';

-- ���� : delete
delete from member where name = '����';

-- ���� DB�� �۾� ����� �ݿ�
commit

-- ����
select id, password, name, address from member
order by id asc;

-- address�� �Ǳ��� ȸ���� �� ��ȸ
select count(*) from member where address = '�Ǳ�';















