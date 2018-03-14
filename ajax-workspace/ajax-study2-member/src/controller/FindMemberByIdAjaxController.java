package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberByIdAjaxController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String memberId = request.getParameter("memberId");
		MemberVO mvo = MemberDAO.getInstance().findMemberById(memberId);
		if(mvo == null){
			out.println("회원 정보가 존재하지 않습니다!");
		}
		else{
			out.println(mvo.getId() + " " + mvo.getName() + " " + mvo.getAddress());
		}
		out.close();
		return "AjaxView";
	}

}
