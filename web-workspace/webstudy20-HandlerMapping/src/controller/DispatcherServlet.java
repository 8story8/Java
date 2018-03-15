package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		requestProcess(request, response);

	}
	
	/**
	 * 1. Client 요청 분석
	 * 2. HandlerMapping(Factory)를 이용해 Controller 구현체 생성을 의뢰하여,
	 *    Controller 인터페이스 타입으로 반환받는다.
	 * 3. 개별 Controller 구현체의 Controller 메서드를 실행한다.
	 * 4. 예외 처리 try, catch문을 작성하고,
	 *    예외 발생시 서버상에서 메세지를 출력하고 error.jsp로 응답한다.(redirect)
	 * 5. Controller 메서드 실행 후 반환되는 URL에 의거하여,
	 *    Client에 응답할 View를 forward 또는 redirect 방식으로 응답한다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String command = request.getParameter("command");
		Controller controller = HandlerMapping.getInstance().create(command);
		
		try 
		{
			String url = controller.execute(request, response);
			if(url.startsWith("redirect:")){
				response.sendRedirect(url.trim().substring(9));
			}
			else{
				request.getRequestDispatcher(url).forward(request, response);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}
