/*
Transaction 처리(or 제어)
 : 작업 단위를 제어 
 
 주요 용어
 DCL(Data Control Language)
 commit : 실제 DB에 작업 내용을 반영
 rollback : 작업 내용을 취소
 
 JDBC는 Auto Commit이 기본
 Transaction 제어가 필요한 경우에는 
 Auto Commit 속성을 해제하여 수동 Commit Mode로 변경한 후,
 (connection.setAutoCommit(false))
 작업 단위 내에서 모든 작업이 정상적으로 수행되면
 connection.commit(); --> 실제 db에 반영
 문제가 발생되면
 connection.rollback(); --> 작업 취소
 
 ex1) 계좌이체()
 	  {
 	  	try
 	  	{
 	  		출금업무
 	  		입금업무
 	  		commit
 	  	}
 	  	catch()
 	  	{
 	  		rollback
 	  	}
 	 }
 	 
 ex2) 신규카드발급()
		{
			try
			{
				카드발급
				포인트지급
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