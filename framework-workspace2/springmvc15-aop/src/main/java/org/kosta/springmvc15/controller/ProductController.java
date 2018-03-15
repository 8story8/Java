package org.kosta.springmvc15.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.springmvc15.model.ProductService;
import org.kosta.springmvc15.model.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	@Resource
	private ProductService productService;
	
	@RequestMapping("home.do")
	public String home(){
		return "home";
	}
	
	@RequestMapping(value = "registerProduct.do", method = RequestMethod.POST)
	public String registerProduct(ProductVO pvo){
		productService.registerProduct(pvo);
		return "redirect:findProductById.do?id="+pvo.getId();
	}
	
	@RequestMapping("findProductById.do")
	public String findProductById(String id, Model model){
		model.addAttribute("pvo", productService.findProductById(id));
		return "register_product_result";
	}
	
	@RequestMapping("findProductListByType.do")
	public String findProductListByType(String type, String keyword, Model model){
		List<ProductVO> list = productService.findProductListByType(type, keyword);
		
		if(list.isEmpty()){
			model.addAttribute("lvo", "isEmpty");
		}
		else{
			model.addAttribute("lvo", list);
		}
		
		return "product_list";
	}
}
