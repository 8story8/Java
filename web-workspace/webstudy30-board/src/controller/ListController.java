package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import model.ListVO;
import model.PagingBean;

public class ListController  implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		int totalContent = BoardDAO.getInstance().getTotalContent();
		String pageNo = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		
		if(pageNo == null){
			pagingBean = new PagingBean(totalContent);
		}
		else{
			pagingBean = new PagingBean(totalContent, Integer.parseInt(pageNo));
		}
		
		ArrayList<BoardVO> list = BoardDAO.getInstance().getPostingList(pagingBean);
		ListVO lvo = new ListVO(list, pagingBean);
		request.setAttribute("lvo", lvo);
		return "board/list.jsp";
	}
}







