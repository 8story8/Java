package step2;

public class SuperMan extends ET implements Flyer, Fighter
{
	@Override
	public void fly() 
	{
		System.out.println("���۸��� ����.");
	}

	@Override
	public void fight() 
	{
		System.out.println("���۸��� �Ǵ�� �ο��.");
	}
}
