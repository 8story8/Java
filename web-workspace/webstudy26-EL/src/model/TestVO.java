package model;

public class TestVO {
	public String getName(){
		System.out.println("getName() 실행");
		return "Kid";
	}
	
	public String findNick(){
		return "Akai Shuichi";
	}
	
	public String getNickName(){
		return "Akai Shuichi";
	}
	
	public boolean isFile(){
		return false;
	}
	
	public int getMoney(){
		return 2400;
	}
}
