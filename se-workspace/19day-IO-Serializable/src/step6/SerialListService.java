package step6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialListService 
{
	private String path;
	public SerialListService(String path)
	{
		super();
		this.path = path;
	}
	
	public void outputList(ArrayList<FoodVO> al) throws FileNotFoundException, IOException 
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.path));
		oos.writeObject(al);
		oos.close();
	} 
	
	public ArrayList<FoodVO> inputList() throws IOException, ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.path));
		
		@SuppressWarnings("unchecked")
		ArrayList<FoodVO> al = (ArrayList<FoodVO>) ois.readObject();
		ois.close();
		return al;
	}
}
