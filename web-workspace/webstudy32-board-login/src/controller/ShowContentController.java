package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class ShowContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		//조회수를 증가시킨다. 
		BoardDAO.getInstance().updateHit(no);
		// 개별 게시물 조회  
		BoardVO bvo = BoardDAO.getInstance().getBoardByNo(no);	
		request.setAttribute("bvo", bvo);
		return "board/show_content.jsp";
	}
}






