package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.DADD;

import model.MockDAO;

public class InsertController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		MockDAO.getInstance().insert(name, addr);
		String url = "redirect:insert_result.jsp";
		return url;
	}
}
