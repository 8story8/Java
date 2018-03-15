package step5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialService 
{
	private String path;
	
	SerialService(String path)
	{
		this.path = path;
	}
	
	public void registerMember(MemberVO memberVO) throws IOException 
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.path));
		oos.writeObject(memberVO);
		oos.close();
	}

	public MemberVO readMemberVO() throws IOException, ClassNotFoundException 
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.path));
	    MemberVO mvo = (MemberVO) ois.readObject();
	    ois.close();
	    return mvo;
	}
}
