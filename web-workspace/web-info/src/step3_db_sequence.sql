/*
Oracle Sequence
- Unique���� �����ϱ� ���� �뵵
- �ַ� Primary Key�� ������ ����Ѵ�.
- �Ϸ��� ��ȣ�� ���������� ������Ų��.
- Table�� ���������� �����ǰ� ����ȴ�.
*/

-- sequence ����
create sequence seq_test;

-- sequence ����
drop sequence seq_test;

/*
���� sequence���� ��ȯ : ��������.nextval
dual table : Oracle���� �����ϴ� �⺻ ���̺�
			    varchar2 Ÿ���� �÷� �ϳ��� ������ ���̺�μ�,
			    �ַ� �Լ� ������ ���� ���ȴ�.
 */
select seq_test.nextval from dual;

create table car(
	car_no number primary key,
	model varchar2(100) not null,
	price number default 0
);

-- car ���̺��� �̿��� car sequence ����
create sequence car_seq;

-- sequence�� �̿��� �� ��ȣ�� ������ �Է��Ѵ�.
insert into car(car_no, model, price) values(car_seq.nextval, 'k5', 1000);
insert into car(car_no, model, price) values(car_seq.nextval, 'sm5', 1200);

/*
Table : memo
Column : 		memo_no, 	title, 			content
Type : 			number 		varchar2 		varchar2
Constraints : 	pk				not null		not null

memo_no : sequence�� �̿�(sequence�� : memo.seq)
*/

create sequence memo_seq;

create table memo(
	memo_no number primary key,
	title varchar2(100) not null,
	content varchar2(100) not null
);

insert into memo(memo_no, title, content) values(memo_seq.nextval, '�ȳ�', '����');

select * from car;
