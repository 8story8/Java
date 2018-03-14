package test;

import java.util.ArrayList;

import org.json.JSONArray;

import model.CarDTO;

public class TestJSON3 {

	public static void main(String[] args) {
		// JSON Array > ArrayList<CarDTO>
		ArrayList<CarDTO> list = new ArrayList<CarDTO>();
		list.add(new CarDTO("SM5", 500));
		list.add(new CarDTO("K7", 700));
		list.add(new CarDTO("BMW", 1000));
		
		// list를 JSONArray로 생성
		JSONArray arr = new JSONArray(list);
		System.out.println(arr.toString());
		/*
		 * [{"price":500,"model":"SM5"},{"price":700,"model":"K7"},{"price":1000,"model":"BMW"}]
		 * Client JavaScript에서는
		 * var carList = JSON.parse(xhr.responseText);
		 * alert(carList[0].model);   // SM5
		 */
	}
}
