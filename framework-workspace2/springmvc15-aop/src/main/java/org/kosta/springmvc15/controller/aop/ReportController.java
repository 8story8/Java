package org.kosta.springmvc15.controller.aop;

import javax.annotation.Resource;

import org.kosta.springmvc15.model.aop.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {
	@Resource
	private ReportService reportService;
	
	@RequestMapping("report.do")
	public String report(Model model){
		System.out.println(reportService.selectReport());
		model.addAttribute("rvo", reportService.selectReport());
		return "report";
	}
}
