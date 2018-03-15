package org.saiden.springmvc12.controller;

import javax.annotation.Resource;

import org.saiden.springmvc12.model.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Resource
	private CarService carService;
	
	@RequestMapping("home.do")
	public String home(Model model){
		model.addAttribute("totalCarCount", carService.getTotalCarCount());
		return "home";
	}
	
	@RequestMapping("carList.do")
	public String carList(Model model){
		model.addAttribute("carList", carService.getAllCarList());
		return "carList";
	}
}
