package model;

import java.util.ArrayList;

public class TestLoop {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Jin");
		list.add("Vermouth");
		list.add("Bourbon");
		
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
		System.out.println("**jdk 1.5이상에서 지원하는 for문");
		for(String menu : list){
			System.out.println(menu);
		}
		
		System.out.println("********************");
		ArrayList<PersonVO> perList = new ArrayList<PersonVO>();
		perList.add(new PersonVO("Kid", 200));
		perList.add(new PersonVO("Z", 300));
		
		for(PersonVO p : perList){
			System.out.println("이름 : " + p.getName());
			System.out.println("보유 금액 : "  + p.getMoney());
		}
	}
}
