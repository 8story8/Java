package controller;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class FindByAddressController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		String addr = request.getParameter("addr");
		ArrayList<String> list = MockDAO.getInstance().findByAddress(addr);
		String url = null;
		
		if(list.isEmpty()){
			url = "findByAddress_fail.jsp";
		}
		else{
			request.setAttribute("list", list);
			url = "findByAddress_ok.jsp";
		}
		
		return url;
	}
}
