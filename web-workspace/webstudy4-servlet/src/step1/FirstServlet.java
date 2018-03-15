package step1;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{
	private static final long serialVersionUID = 3697569929092716508L;
	
	// Client가 get 방식으로 요청하면 doGet()을 실행한다.
	// request : 클라이언트 요청 정보
	// response : 클라이언트에게 응답하기 위한 정보
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// 클라이언트에게 응답할 정보를 지정(한글 처리 명령 포함)
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor = lightgreen>");
		out.print("<h3>FirstServlet doGet() 메서드가 응답</h3>");
		// 클라이언트가 보낸 userName을 반환받는다.
		String name = request.getParameter("userName");
		out.print("클라이언트가 보낸 이름은 " + name);
		out.print("</body></html>");
		out.close();
		System.out.println("FirstServlet doGet()");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// post 방식의 요청은 클라이언트 정보가 http body 부분에 저장되어 오므로,
		// 별도의 한글 처리가 필요하다.
		request.setCharacterEncoding("utf-8");
		
		// 응답할 정보를 설정
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor = orange>");
		out.print("<h3>FirstServlet doPost() 메서드가 응답</h3>");
		String name = request.getParameter("userName");
		out.print("클라이언트가 보낸 이름은 " + name);
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
