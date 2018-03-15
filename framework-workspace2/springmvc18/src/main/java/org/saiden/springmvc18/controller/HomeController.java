package org.saiden.springmvc18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home.do")
	public String home(){
		// System.out.println("tiles view 응답");
		// tilesbase는 tiles-config.xml의 definition name이다.
		// tiles config의 definition name을 반환하면 tiles viewResolver 방식으로 응답한다.
		return "tilesbase.tiles";
	}
	
	@RequestMapping("test.do")
	public String test(){
		// tiles-config.xml의 definition name이 아니므로 viewResolver order에 따라
		// InternalResourceViewResolver 방식으로 응답된다.
		// /WEB-INF/views/test.jsp
		return "test.tiles";
	}
	
	@RequestMapping("home2.do")
	public String home2(){
		return "home2.tiles";
	}
	
	@RequestMapping("home3.do")
	public String home3(){
		return "home3.tiles";
	}
	
	@RequestMapping("home4.do")
	public String home4(){
		return "home4.tiles";
	}
	
	/*
	 * @PathVariable Annotation
	 * 요청 URL 정보를 변수로 할당받기 위한 Annotation
	 * 요청 URL과 일치하는 URL Mapping Method가 존재하면
	 * 그 Method가 우선적으로 실행되고,
	 * 존재하지 않으면 @PathVariable Method가 실행된다.
	 */
/*	@RequestMapping("{viewName}.do")
	public String showView1(@PathVariable String viewName){
		System.out.println("@PathVariable : " + viewName);
		return viewName + ".tiles";
	}*/
	
	@RequestMapping("{dirName}/{viewName}.do")
	public String showView2(@PathVariable String dirName, @PathVariable String viewName){
		System.out.println("@PathVariable : " + dirName + "/" + viewName);
		return dirName + "/" + viewName + ".tiles";
	}
	
}
