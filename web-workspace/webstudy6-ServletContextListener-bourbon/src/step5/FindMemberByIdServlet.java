package step5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String db_url, db_user, db_password;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMemberByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException
    {
    	/*	 
    	String db_driver = getServletContext().getInitParameter("db_driver");
    	
    	try 
    	{
			Class.forName(db_driver);
			System.out.println(db_driver + " Loading");
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		}
		*/
    	
    	db_url = getServletContext().getInitParameter("db_url");
    	db_user = getServletContext().getInitParameter("db_user");
    	db_password = getServletContext().getInitParameter("db_password");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try 
		{
			Connection con = DriverManager.getConnection(db_url, db_user, db_password);
			PreparedStatement pstmt = con.prepareStatement("select name, address from member where id = ?");
			pstmt.setString(1, request.getParameter("memberId"));
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				out.print("<h3>");
				out.print("아이디 : " + request.getParameter("memberId") + "<br>");
				out.print("이름 : " +  rs.getString(1) + "<br>");
				out.print("주소 : " +  rs.getString(2) + "<br>");
				out.print("</h3>");
			}
			else
			{
				out.print("<h3>");
				out.print(request.getParameter("memberId") + " 아이디에 해당하는 회원은 없습니다!");
				out.print("</h3>");
			}
		} 
		catch (SQLException e) 
		{
			out.print("DB 연동시 문제 발생");
			e.getStackTrace();
		}
		out.close();
	}

}
