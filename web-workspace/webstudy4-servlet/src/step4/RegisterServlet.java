package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		 request.setCharacterEncoding("utf-8");
	 	  response.setContentType("text/html; charset = utf-8");
	 	  PrintWriter out = response.getWriter();
	 	  out.print("<html>");
	 	  out.print("<body bgcolor = yellow>");
	 	  out.print("<h3>");
	 	  String memId = request.getParameter("memId");
	 	  String memName= request.getParameter("memName");
	 	  String memAddress = request.getParameter("memAddress");
	 	  String gender = request.getParameter("gender");
	 	  String blood = request.getParameter("blood");
	 	  out.print("회원가입 처리완료<br>");
	 	  out.print("아이디 : " + memId + "<br>");
	 	  out.print("이름 : " + memName + "<br>");
	 	  out.print("주소 : " + memAddress  + "<br>");
	 	  out.print("성별 : " + gender  + "<br>");
	 	  out.print("혈액형 : " + blood  + "<br>");
	 	  out.print("</h3></body></html>");
	 	  out.close();
	 }
}
