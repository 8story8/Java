package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet
{
	private static final long serialVersionUID = 7038930396979654605L;

  @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	  response.setContentType("text/html; charset = utf-8");
	  PrintWriter out = response.getWriter();
	  out.print("<html>");
	  out.print("<body bgcolor = yellow>");
	  out.print("<h3>");
	  out.print("등록 OK <br>");
	  out.print("이름 " + request.getParameter("memberName") + "<br>");
	  out.print("주소 " + request.getParameter("memberAddr"));
	  out.print("</h3></body></html>");
	  out.close();
}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
	  request.setCharacterEncoding("utf-8");
	  
  	  response.setContentType("text/html; charset = utf-8");
  	  PrintWriter out = response.getWriter();
  	  out.print("<html>");
  	  out.print("<body bgcolor = yellow>");
  	  out.print("<h3>");
  	  out.print("등록 OK <br>");
  	  out.print("이름 " + request.getParameter("memberName") + "<br>");
  	  out.print("주소 " + request.getParameter("memberAddr"));
  	  out.print("</h3></body></html>");
  	  out.close();
  }
}
