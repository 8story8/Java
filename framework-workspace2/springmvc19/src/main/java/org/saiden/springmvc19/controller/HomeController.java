package org.saiden.springmvc19.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("{viewName}.do")
	public String showView1(@PathVariable String viewName){
		System.out.println("@PathVariable : " + viewName);
		return viewName + ".tiles";
	}
	
	@RequestMapping("{dirName}/{viewName}.do")
	public String showView2(@PathVariable String dirName, @PathVariable String viewName){
		System.out.println("@PathVariable : " + dirName + "/" + viewName);
		return dirName + "/" + viewName + ".tiles";
	}
}
