package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id=request.getParameter("memberId");
		String password=request.getParameter("memberPass");
		MemberVO vo=MemberDAO.getInstance().login(id, password);
		String url=null;
		if(vo!=null){
			HttpSession session=request.getSession();
			session.setAttribute("mvo", vo);
			url="redirect:login_ok.jsp";
		}else{
			url="redirect:login_fail.jsp";
		}
		return url;
	}

}





