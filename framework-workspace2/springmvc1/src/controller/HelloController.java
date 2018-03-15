package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{
	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 실행");
		// view name 을 할당 
		// dispatcher-servlet에서 설정한 ViewResolver에 의해 
		// /views/ok.jsp 로 응답한다 
		//return new ModelAndView("ok");
		/*ModelAndView mv=new ModelAndView();
		mv.setViewName("ok");//응답할 view 정보를 할당 
		//아래 코드는
		//request.setAttibute("info","그대라는 사치"); 를 의미
		mv.addObject("info", "그대라는 사치");
		return mv;*/
		return new ModelAndView("ok","info","그대라는 사치");		
	}	
}















