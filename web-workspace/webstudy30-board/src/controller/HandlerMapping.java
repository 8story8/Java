package controller;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){
		Controller c=null;
		if(command.equals("list")){
			c=new ListController();
		}else if (command.equals("write")) {
			c = new WriteController();
		}else if(command.equals("showContentNotHit")){
				c=new ShowContentNotHitController();
		} else if (command.equals("showContent")) {
			c = new ShowContentController();
		}else if(command.equals("deleteCheckPassword")){
			c=new DeleteCheckPasswordController();
		}else if(command.equals("deletePosting")){
			c=new DeletePostingController();
		}else if(command.equals("updateCheckPassword")){
			c=new UpdateCheckPasswordController();
		}else if(command.equals("updateView")){
			c=new UpdateViewController();
		}else if(command.equals("updatePosting")){
			c=new UpdatePostingController();
		}
		return c;
	}
}










