package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.CustomerDAO;
import model.CustomerVO;

public class CustomerController extends MultiActionController {
	private CustomerDAO customerDAO;
	public CustomerController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	/*
	 * findCustomerByID() 
	 * -> views/find_ok.jsp 검색결과 
	 * -> views/find_fail.jsp 고객이 존재하지 않습니다.
	 */
	public ModelAndView findCustomerById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		CustomerVO cvo = customerDAO.findCustomerById(id);
		if (cvo == null)
			return new ModelAndView("find_fail");
		else
			return new ModelAndView("find_ok", "cvo", cvo);
	}
}





