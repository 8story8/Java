package step6;

import java.io.IOException;
import java.util.ArrayList;

public class TestSerialService3 
{
	public static void main(String[] args) 
	{
		String path = "C:\\java-kosta\\test\\serial\\FoodList.obj";
		
		SerialListService service = new SerialListService(path);
		
		ArrayList<FoodVO> al1 = new ArrayList<FoodVO>();
		
		al1.add(new FoodVO("족발", 33000));
		al1.add(new FoodVO("커피", 1500));
		al1.add(new FoodVO("맥주", 5000));
		
		try 
		{
			service.outputList(al1);
			System.out.println("List 직렬화 완료");
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		} 
	}
}
