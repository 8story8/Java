package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDAO;

public class DeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		ItemDAO.getInstance().deleteItemByNo(itemNo);
		
		return "redirect:DispatcherServlet?command=list";
	}
}
