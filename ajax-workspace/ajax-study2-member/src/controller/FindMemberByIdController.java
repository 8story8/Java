package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberByIdController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String id=request.getParameter("memberId");
		MemberVO vo=MemberDAO.getInstance().findMemberById(id);
		if(vo==null)
			return "findMemberById_fail.jsp";
		else{
			request.setAttribute("vo", vo);
			return "findMemberById_ok.jsp";
		}
	}
}
