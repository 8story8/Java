package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class WriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String content = request.getParameter("content");	
		//BoardVO(String title, String writer, String password, String content)
		BoardVO vo = new BoardVO(title,writer,password,content);		
		//for(int i=0;i<31;i++)
		BoardDAO.getInstance().posting(vo);
		
		//System.out.println("게시물 등록성공.."+vo);
		String path="redirect:DispatcherServlet?command=showContentNotHit&no="+vo.getNo();
		return path;
	}

}







