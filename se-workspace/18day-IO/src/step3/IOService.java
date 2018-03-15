package step3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class IOService 
{
	private String path;

	public IOService(String path)
	{
		this.path = path;
		new File(this.path).getParentFile().mkdirs();   // 디렉토리 생성
	}

	public ArrayList<String> readList() throws IOException 
	{
		ArrayList<String> al = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String data = br.readLine();
		
		while(data != null)
		{
			al.add(data);
			data = br.readLine();
		}
		br.close();
		return al;
	}
	
	public void writeList(ArrayList<String> al) throws IOException 
	{
		PrintWriter pw = new PrintWriter(new FileWriter(path));
		
		for(int i = 0; i < al.size(); i++)
		{
			pw.println(al.get(i));
		}
		
		pw.close();
	}
}
