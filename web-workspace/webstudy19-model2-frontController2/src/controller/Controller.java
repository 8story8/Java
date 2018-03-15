package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
모든 Controller 업무를 처리하는 Class들이 구현해야 하는 Interface
--> DispatcherServlet과 모든 Controller들이,
	 단일한 메세지 방식으로 소통하기 위해 표준화하는 Interface
*/

public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
