package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet{
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
	 	  response.setContentType("text/html; charset = utf-8");
	 	  PrintWriter out = response.getWriter();
	 	  out.print("<html>");
	 	  out.print("<body bgcolor = yellow>");
	 	  out.print("<h3>");
	 	  String id = request.getParameter("id");
	 	  String nick = request.getParameter("nick");
	 	  if(id != null){
	 		  out.print(id);
	 	  }
	 	  if(nick != null){
	 		  out.print(" " + nick);
	 	  }
	 	  out.print("</h3></body></html>");
	 	  out.close();
	 }
}
