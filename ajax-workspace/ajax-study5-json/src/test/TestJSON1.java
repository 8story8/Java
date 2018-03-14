package test;

import org.json.JSONObject;

import model.MemberVO;

public class TestJSON1 {
	public static void main(String[] args) {
		JSONObject json1 = new JSONObject();
		json1.put("name", "아이유");
		json1.put("address", "판교");
		System.out.println(json1.toString());
		MemberVO mvo = new MemberVO("java", null, "김문일", "판교");
		// VO 객체를 JSON 객체로 만들떄는 생성자를 이용
		JSONObject json2 = new JSONObject(mvo);
		System.out.println(json2.toString());
	}
}
