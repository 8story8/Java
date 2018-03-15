package step5;

import java.util.ArrayList;

public class StringService 
{
	private ArrayList<String> al = new ArrayList<String>();

	public void addFile(String file) 
	{
		al.add(file);
	}
	
	public void printName(String ext) 
	{
		for(int i = 0; i < al.size(); i++)
		{
			if(al.get(i).endsWith(ext))
			{
				System.out.println(al.get(i).substring(0, al.get(i).lastIndexOf(".")));
			}
		}	
	}
}
