package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class UpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MockDAO.getInstance().updateNick(request.getParameter("nickName"));
		return "redirect:update_result.jsp";
	}

}
