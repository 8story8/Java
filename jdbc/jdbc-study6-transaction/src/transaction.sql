/*
Transaction ó��(or ����)
 : �۾� ������ ���� 
 
 �ֿ� ���
 DCL(Data Control Language)
 commit : ���� DB�� �۾� ������ �ݿ�
 rollback : �۾� ������ ���
 
 JDBC�� Auto Commit�� �⺻
 Transaction ��� �ʿ��� ��쿡�� 
 Auto Commit �Ӽ��� �����Ͽ� ���� Commit Mode�� ������ ��,
 (connection.setAutoCommit(false))
 �۾� ���� ������ ��� �۾��� ���������� ����Ǹ�
 connection.commit(); --> ���� db�� �ݿ�
 ������ �߻��Ǹ�
 connection.rollback(); --> �۾� ���
 
 ex1) ������ü()
 	  {
 	  	try
 	  	{
 	  		��ݾ���
 	  		�Աݾ���
 	  		commit
 	  	}
 	  	catch()
 	  	{
 	  		rollback
 	  	}
 	 }
 	 
 ex2) �ű�ī��߱�()
		{
			try
			{
				ī��߱�
				����Ʈ����
				commit
			catch()
			{
				rollback
			}
		}
*/

create table card(
	id varchar2(100) primary key,
	name varchar2(100) not null
);

create table point(
	id varchar2(100) primary key,
	point number not null
);

select * from card;
select * from point;

delete from card;
delete from point;
commit