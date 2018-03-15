package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdatePostingController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int no=Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		BoardVO vo=new BoardVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		BoardDAO.getInstance().updatePosting(vo);			
		String path="redirect:DispatcherServlet?command=showContentNotHit&no="+vo.getNo();
		return path;
	}

}







