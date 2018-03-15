package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateViewController implements Controller {
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int no=Integer.parseInt(request.getParameter("no"));
		BoardVO vo = BoardDAO.getInstance().getPostingByNo(no);		
		request.setAttribute( "bvo", vo);
		return "/board/update.jsp";
	}
}






