package model;

import java.util.ArrayList;

public class MemberDAO {
	public MemberVO findMemberById(String id){
		MemberVO mvo = null;
		if(id.equals("java")){
			mvo = new MemberVO("java", "1234", "아이유", "판교");
		}
		else if(id.equals("spring")){
			mvo = new MemberVO("spring", "abcd", "bourbon", "tokyo");
		}
		else if(id.equals("ajax")){
			mvo = new MemberVO("ajax", "4321", "vermouth", "berlin");
		}
		return mvo;
	}
	
	public ArrayList<MemberVO> findMemberListByAddress(String address){
		  ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		  if(address.equals("판교")){
		   list.add(new MemberVO("java",null,"이현근","판교"));   
		   list.add(new MemberVO("ajax",null,"김성환","판교"));   
		   list.add(new MemberVO("jquery",null,"임경수","판교"));
		   list.add(new MemberVO("git",null,"김지원","판교"));
		  }else if(address.equals("종로")){
		   list.add(new MemberVO("spring",null,"한지선","종로"));
		   list.add(new MemberVO("mybatis",null,"강정호","종로"));
		  }
		  return list;
		 }
}
