package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("pw");
		MemberVO mvo=MemberDAO.getInstance().login(id, password);
		String url=null;
		
		if(mvo != null){
			HttpSession session=request.getSession();
			session.setAttribute("mvo", mvo);
			url="redirect:index.jsp";
		}
		else{
			url="redirect:login_fail.jsp";
		}
		return url;
	}
}





