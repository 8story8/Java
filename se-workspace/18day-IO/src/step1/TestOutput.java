package step1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestOutput 
{
	public static void main(String[] args) 
	{
		try 
		{
			// ���Ͽ� ����Ǵ� Node Stream : ������ ������ ����
			// �� ��° Parameter�� true�� append
			FileWriter fw = new FileWriter("C:\\java-kosta\\test\\memo.txt", true);
			
			// ���ڿ��� ����ϱ� ���� Processing Stream
			PrintWriter pw = new PrintWriter(fw);
			pw.println("�氡�氡 IO");
			System.out.println("�۾� �Ϸ�");
			pw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
