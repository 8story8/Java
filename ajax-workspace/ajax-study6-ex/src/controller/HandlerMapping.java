package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping(){ };
	public static HandlerMapping getInstance(){
		return instance;
	}
	
	public Controller create(String command){
		Controller controller = null;
		if(command.equals("empNoList")){
			controller = new EmpNoListController();
		}
		else if(command.equals("empAndDept")){
			controller = new EmpAndDeptController();
		}
		
		
		return controller;
	}
}
