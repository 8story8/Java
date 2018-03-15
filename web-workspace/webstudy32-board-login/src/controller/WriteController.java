package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;
import model.MemberVO;

public class WriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String title = request.getParameter("title");
		String content = request.getParameter("content");	
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		BoardVO bvo = new BoardVO(title, content, mvo);
		BoardDAO.getInstance().insertBoard(bvo);
		
		return "redirect:DispatcherServlet?command=showContentNotHit&no="+bvo.getNo();
	}
}







