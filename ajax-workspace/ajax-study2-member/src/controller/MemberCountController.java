package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class MemberCountController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		int memberCount = MemberDAO.getInstance().memberCount();
		out.println(memberCount);
		out.close();
		return "AjaxView";
	}

}
