package org.kosta.controller;

import javax.annotation.Resource;

import org.kosta.model.CustomerDAO;
import org.kosta.model.CustomerVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CustomerController {
	@Resource
	private CustomerDAO customerDAO;
	@RequestMapping("findCustomerById.do")
	public String findCustomerById(String id,Model model){
		CustomerVO cvo=customerDAO.findCustomerById(id);
		String url=null;
		if(cvo==null)
			url="find_fail";
		else{
			url="find_ok";
			model.addAttribute("cvo",cvo);
		}			
		return url;
	}
}
