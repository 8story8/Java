package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.ProductDAO;
import model.ProductVO;

public class ProductController extends MultiActionController {
	private ProductDAO productDAO;	
	public ProductController(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response,ProductVO vo){			
		productDAO.register(vo);
		System.out.println(vo);	
		return new ModelAndView("redirect:product.do?command=findProductById&id="+vo.getId());
	}
	public ModelAndView findProductById(HttpServletRequest request,
			HttpServletResponse response) {	
		String id=request.getParameter("id");		
		ProductVO vo=productDAO.findProductById(id);
		return new ModelAndView("register_result", "vo", vo);			
	}
	public ModelAndView findProductByName(HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String word=request.getParameter("word");		
		return new ModelAndView("find_result","list",
				productDAO.findProductByName(word));
	}
	public ModelAndView findProductByMaker(HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String word=request.getParameter("word");		
		return new ModelAndView("find_result","list",
				productDAO.findProductByMaker(word));
	}
}







