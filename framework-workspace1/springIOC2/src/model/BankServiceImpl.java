package model;
/**
 * Controller -- BankService -- BankDAO 
 * @author KOSTA
 *
 */
public class BankServiceImpl implements BankService {
	private BankDAO bankDAO;
	//Spring Container로부터 DAO 객체를 주입받도록 한다 (DI : Dependency Injection)
	public BankServiceImpl(BankDAO bankDAO) {
		super();
		this.bankDAO = bankDAO;
		System.out.println("spring container로부터 주입받는다 "+bankDAO);
	}
	@Override
	public void deposit(int money) {
		bankDAO.deposit(money);
	}
}





