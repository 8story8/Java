package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompanyDAO;

public class EmpNoListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("empNoList", CompanyDAO.getInstance().getEmpNoList());
		return "employee.jsp";
	}
}
