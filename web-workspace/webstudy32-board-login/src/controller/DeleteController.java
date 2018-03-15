package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class DeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no=request.getParameter("no");
		BoardDAO.getInstance().deleteBoard(Integer.parseInt(no));
		
		return "redirect:DispatcherServlet?command=list";
	}
}






