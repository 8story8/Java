package step3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context3
 */
public class Context3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Context3() {
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletConfig로부터 Servlet 이름을 반환받는다.
		String name = this.getServletConfig().getServletName();
		// ServletConfig로부터 ServletContext 객체를 반환받는다.
		ServletContext context = this.getServletConfig().getServletContext();
		// ServletContext로부터 웹어플리케이션명을 반환받는다.
		String webAppName = context.getContextPath();
		
		out.print("<h3>");
		out.print(name+"<br><br>");
		out.print("<a href=index.html> "+webAppName+"</a><br><br>");
		out.print(context.getInitParameter("db_driver")+"<br><br>");
		
		// ServletContext에 저장되어 있는 모든 Attribute를 출력한다.
		Enumeration<String> en = context.getAttributeNames();
		while(en.hasMoreElements()){
			String attName=en.nextElement();
			out.print("name: "+attName+"<br>");
			Object attValue = context.getAttribute(attName);
			out.println("attValue: "+attValue+"<hr>");
		}
		
		out.close();
	}

}
