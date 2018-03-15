package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextTestServlet2
 */
public class ContextTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextTestServlet2() {
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
			out.print("<br><br><a href = ContextTestServlet>");
			out.print("ContextTestServlet</a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.close();
	}
	
	// ServletConfig를 할당하는 아래의 Parameter가 있는 init() 메서드를 Overriding할 때에는,
	// 반드시 super.init(ServletConfig);를 명시해야 한다.
	// 그러므로 init() 메서드 Overriding해야 할 때에는 가급적 API에서 권장하는 데로,
	// Parameter가 없는 init()을 Overriding한다.
	/*
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행^^");
	}
	*/
}
