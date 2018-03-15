package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDAO;
import model.ItemVO;

public class FindController implements Controller{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		ItemVO ivo = ItemDAO.getInstance().findItemByNo(itemNo);
		request.setAttribute("ivo", ivo);
		return "detail_item.jsp";
	}
}
