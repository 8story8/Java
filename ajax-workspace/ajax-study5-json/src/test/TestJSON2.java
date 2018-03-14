package test;

import org.json.JSONArray;

public class TestJSON2 {
	public static void main(String args[]){
		// JSONArray Test
		JSONArray ja = new JSONArray();
		ja.put("bourbon");
		ja.put("vermouth");
		ja.put("jin");
		ja.put("kir");
		System.out.println(ja.toString());
	}
}
