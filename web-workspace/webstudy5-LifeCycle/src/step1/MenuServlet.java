package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public MenuServlet() 
	{
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		String selectedMenu[] = request.getParameterValues("food");
		for (int i = 0; i < selectedMenu.length; i++) {
			out.print(selectedMenu[i] + " ");;
		}
		out.print("주문하셨습니다!");
		out.close();
	}
}
