package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no=Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardVO bvo=new BoardVO();
		bvo.setNo(no);
		bvo.setTitle(title);
		bvo.setContent(content);
		BoardDAO.getInstance().updateBoard(bvo);			
		return "redirect:DispatcherServlet?command=showContentNotHit&no="+bvo.getNo();
	}

}







