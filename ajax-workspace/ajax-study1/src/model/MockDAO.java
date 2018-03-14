package model;

public class MockDAO {
	public String getMemberInfo(String id){
		String info = null;
		if(id.equals("java")){
			info = "Bourbon Tokyo";
		}
		else if(id.equals("java")){
			info = "Vermouth Berlin";
		}
		return info;
	}
	
	public String getDeptInfo(String deptNo){
		String info = null;
		switch(deptNo){
		case "10":
			info = "R&D 판교";
			break;
		case "20":
			info = "Sales 강남";
			break;
		case "30":
			info = "Management 종로";
			break;
		}
		return info;
	}
}
