package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import sun.print.PrinterJobWrapper;

public class idCheckAjaxController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		boolean flag = MemberDAO.getInstance().idcheck(id);
		if(flag){
			out.println(id + "는 존재합니다!");
		}
		else{
			out.println(id + "는 존재하지 않습니다!");
		}
		out.close();
		return "AjaxView";
	}

}
