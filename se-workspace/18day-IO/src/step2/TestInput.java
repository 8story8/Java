package step2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestInput 
{
	public static void main(String[] args) 
	{
		
		try 
		{
			// ���Ͽ� ����Ǵ� �Է� Node Stream
			FileReader fr = new FileReader("C:\\java-kosta\\test\\���� �޴�.txt");
	
			// �Է� Processing Stream
			BufferedReader br = new BufferedReader(fr);
			
			// �� ���ξ� �Է�
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());   // �� �̻� �Է¹��� ������ ������ null�� ��ȯ
			br.close();
			System.out.println("�Է� �۾� �Ϸ�!");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
