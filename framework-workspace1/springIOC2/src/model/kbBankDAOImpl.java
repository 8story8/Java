package model;

public class kbBankDAOImpl implements BankDAO {
	@Override
	public void deposit(int money) {
		// TODO Auto-generated method stub
		System.out.println("국민은행 "+money+"원 입금처리");
	}
}
