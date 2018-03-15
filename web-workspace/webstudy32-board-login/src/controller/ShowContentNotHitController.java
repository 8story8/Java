package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class ShowContentNotHitController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no=Integer.parseInt(request.getParameter("no"));		
		BoardVO bvo = BoardDAO.getInstance().getBoardByNo(no);	
		request.setAttribute("bvo", bvo);
		return "board/show_content.jsp";
	}
}







