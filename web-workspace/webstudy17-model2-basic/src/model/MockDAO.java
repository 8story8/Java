package model;

import java.util.ArrayList;

// DAO는 실제 DB와 연동하지 않는다.

public class MockDAO 
{
	private static MockDAO instance = new MockDAO();
	private MockDAO() { }
	public static MockDAO getInstance(){
		return instance;
	}
	
	public String findById(String id){
		String result = null;
		
		if(id.equals("java")){
			result = "아이유, 판교";
		}
		
		return result;
	}
	
	public void insert(String name, String addr){
		System.out.println(name + ", " + addr + "를 DB에 입력 완료!");
	}
	
	public ArrayList<String> findByAddress(String addr){
		ArrayList<String> list = new ArrayList<String>();
		
		if(addr.equals("판교")){
			list.add("bourbon");
			list.add("V");
			list.add("vermouth");
		}
		
		return list;
	}
}
