package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		String mpass=request.getParameter("mpass");
		
		MemberVO mvo = MemberDAO.getInstance().login(mid, mpass);
		
		HttpSession session=request.getSession();
		session.setAttribute("mvo", mvo);

		return "redirect:member/login_result.jsp";
	}
}





