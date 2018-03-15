package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextTestServlet
 */
public class ContextTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		// ServletContext 객체를 반환(ServiceConfig로부터)
		ServletContext context = this.getServletConfig().getServletContext();
		// ServletContext의 초기 Parameter를 반환
		String driver = context.getInitParameter("db_driver");
		// ServletConfig로부터 현재 Servlet 이름을 반환
		String name = getServletConfig().getServletName();
		
		try
		{
			Class.forName(driver);
			out.print("<h2>" + name + " " + driver);
			out.print(" Loading OK</h2>");
			out.print("<br><br><a href = ContextTestServlet2>");
			out.print("ContextTestServlet2</a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.close();
	}
}
