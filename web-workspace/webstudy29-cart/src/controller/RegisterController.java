package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDAO;
import model.ItemVO;

public class RegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("detail");
		
		ItemVO ivo = new ItemVO(name, maker, price, detail);
		ItemDAO.getInstance().registerItem(ivo);
		
		return "redirect:item_register_result.jsp";
	}
}
