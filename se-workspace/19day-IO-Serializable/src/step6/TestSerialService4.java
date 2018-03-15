package step6;

import java.io.IOException;
import java.util.ArrayList;

public class TestSerialService4 
{

	public static void main(String[] args) 
	{
		String path = "C:\\java-kosta\\test\\serial\\FoodList.obj";
		
		SerialListService service = new SerialListService(path);
		try 
		{
			ArrayList<FoodVO> al = service.inputList();
			
			for(int i = 0; i < al.size(); i++)
			{
				System.out.println(al.get(i).getName() + " " + al.get(i).getPrice());
			}
			
			System.out.println("List 역직렬화 완료");
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();
		}
	}
}
