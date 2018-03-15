package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping(){ };
	public static HandlerMapping getInstance(){
		return instance;
	}
	
	public Controller create(String command){
		Controller controller = null;
		if(command.equals("list")){
			controller = new ListController();
		}
		else if(command.equals("find")){
			controller = new FindController();
		}
		else if(command.equals("login")){
			controller = new LoginController();
		}
		else if(command.equals("logout")){
			controller = new LogoutController();
		}
		else if(command.equals("register")){
			controller = new RegisterController();
		}
		else if(command.equals("cart")){
			controller = new CartController();
		}
		else if(command.equals("delete")){
			controller = new DeleteController();
		}
		
		return controller;
	}
}
