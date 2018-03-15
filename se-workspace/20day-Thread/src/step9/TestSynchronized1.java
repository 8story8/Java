package step9;

/*
���� Thread ȯ�濡�� �׽�Ʈ
(���������� �����ϹǷ� ���� ����.)
*/

class Toilet
{
	private boolean seat;   // Default Initialization false
	
	public void use(String user) throws InterruptedException
	{
		if(seat == false)
		{
			Thread.sleep(1000);
			System.out.println(user + " ����");
			Thread.sleep(1000);
			seat = true;
			System.out.println(user + " ���");
			Thread.sleep(2000);
			seat = false;
			System.out.println(user + " ����");
		}
		else
		{
			System.out.println(user + "�� ���� ȭ��� ��� ���̹Ƿ� ��� �Ұ�!");
		}
	}
}

public class TestSynchronized1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Toilet t = new Toilet();
			
			t.use("�Ƿη�");
			t.use("ũ��Ŀ����");
		} 
		catch (InterruptedException ie) 
		{
			ie.printStackTrace();
		}
	}
}
