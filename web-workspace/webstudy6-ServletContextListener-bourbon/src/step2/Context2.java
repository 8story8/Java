package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context2
 */
public class Context2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Context2() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletConfig 로 부터 서블릿 이름을 반환 받는다
		String name = this.getServletConfig().getServletName();
		// ServletConfig 로 부터 ServletContext 객체를 반환받는다
		ServletContext context = this.getServletConfig().getServletContext();
		// ServletContext로 부터 웹어플리케이션명을 반환받는다
		String webAppName = context.getContextPath();
		
		out.print("<h3>");
		out.print(name+"<br><br>");
		out.print("<a href=index.html> "+webAppName+"</a><br><br>");
		out.print(context.getInitParameter("db_driver")+"<br>");
		
		// ServletContext에 Context1이 setting한 kosta_info 와 kosta_star 정보를
		// 반환받아 출력한다
		String a1 = (String) context.getAttribute("kosta_info");
		String a2 = (String) context.getAttribute("kosta_star");
		out.print("ServletContext getAttribute() 결과: ");
		out.print(a1+" "+a2);
		out.print("<br><a href=Context3> Context3에서 Enumerator Test </a><br>" );

		
		out.print("</h3>");
		out.close();
	}

}
