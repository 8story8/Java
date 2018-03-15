package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String message = "";
		String color = "";
		
		if (userAge >= 19) 
		{
			color = "red";
			message = userName + "님 " + userAge + "세 성인입니다!";
		} 
		else 
		{
			color = "yellow";
			message = userName + "님 " + userAge + "세 미성년입니다!";
		}
		
		out.print("<html>");
		out.print("<body bgcolor = " + color + ">");
		out.print("<h3>" + message + "</h3>");
		out.print("</body></html>");
		out.close();
	}
}
