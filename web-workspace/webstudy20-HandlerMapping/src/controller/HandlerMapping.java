package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Client의 요청을 처리할 Controller 구현 객체 생성을 전담하는 Factory 객체
 * @author kosta
 *
 */
public class HandlerMapping{

	private static HandlerMapping hm = new HandlerMapping();
	private HandlerMapping(){ }
	public static HandlerMapping getInstance() {
		return hm;
	}
	
	public Controller create(String command){
		Controller controller = null;
		if(command.equals("find")){
			controller = new FindController();
		}
		else if(command.equals("findByAddress")){
			controller = new FindByAddressController();
		}
		else if(command.equals("insert")){
			controller = new InsertController();
		}
		else if(command.equals("update")){
			controller = new UpdateController();
		}
		return controller;
	}
}
