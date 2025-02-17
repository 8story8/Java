package controller;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){ }
	public static HandlerMapping getInstance(){
		return instance;
	}
	
	public Controller create(String command){
		Controller c=null;
		
		if(command.equals("list")){
			c = new ListController();
		}
		else if(command.equals("login")){
			c = new LoginController();
		}
		else if(command.equals("logout")){
			c = new LogoutController();
		}
		else if(command.equals("showContent")){
			c = new ShowContentController();
		}
		else if(command.equals("write")){
			c = new WriteController();
		}
		else if(command.equals("showContentNotHit")){
			c = new ShowContentNotHitController();
		}
		else if(command.equals("delete")){
			c = new DeleteController();
		}
		else if(command.equals("updateView")){
			c = new UpdateViewController();
		}
		else if(command.equals("update")){
			c = new UpdateController();
		}
		
		return c;
	}
}










