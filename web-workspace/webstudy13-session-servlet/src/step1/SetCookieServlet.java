package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		// Client측의 Cookie로 현재 시간 정보를 저장한다.
		out.print("<h3>SetCookieServlet에서 Cookie를 전송하여 Client측에 저장</h3>");
		Date time = new Date();
		out.print("현재 시간 정보를 Cookie로 전송 : " + time.toString());
		Cookie cookie = new Cookie("time", time.toString().replace(" ", "-"));
		cookie.setMaxAge(30);   // 유효 시간을 30초 준다.
		response.addCookie(cookie);
		out.print("<br><br><a href = GetCookieServlet>GetCookieServlet으로 이동</a><br>");
		out.close();
	}

}
