package model;

import java.util.ArrayList;

public class CarDAO {
	private static CarDAO instance = new CarDAO();
	private CarDAO(){ }
	public static CarDAO getInstance(){
		return instance;
	}
	
	public ArrayList<CarVO> getCarList(){
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		list.add(new CarVO("SM5", 500));
		list.add(new CarVO("K7", 400));
		list.add(new CarVO("Sonata", 200));
		return list;
	}
}
