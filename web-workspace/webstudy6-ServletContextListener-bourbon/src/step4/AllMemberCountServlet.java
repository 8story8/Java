package step4;

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
 * Servlet implementation class AllMemberCountServlet
 */
public class AllMemberCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String db_url, db_user, db_password;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * JDBC 개발 단계
	 * 1. Driver Loading -> init() Constructor에서는 Servlet의 초기 Parameter를 사용할 수 없다.
	 * 						   -> 이유는 ServletConfig는 Constructor 호출 다음에 이루어지는 init(ServletConfig) 호출시에 전달되기 때문이다.
	 * 2. Connection
	 * 3. PreparedStatement
	 * 4. ResultSet
	 * 5. close
	 */
    
    // Web Container가 호출하는 init(ServletConfig)에서 아래 메서드를 호출
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
        	
        db_url = getServletConfig().getServletContext().getInitParameter("db_url");
        db_user = getServletConfig().getServletContext().getInitParameter("db_user");
        db_password = getServletConfig().getServletContext().getInitParameter("db_password");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletConfig로부터 Servlet 이름을 반환받는다.
		String servletName = this.getServletConfig().getServletName();
		try 
		{
			Connection con = DriverManager.getConnection(db_url, db_user, db_password);
			PreparedStatement pstmt = con.prepareStatement("select count(*) from member");
			ResultSet rs = pstmt.executeQuery();
			
			out.print("현재 Servlet : " + servletName);
			if(rs.next())
			{
				out.print("<h3> 총 회원수 : " + rs.getInt(1) + "</h3>");
			}
		} 
		catch (SQLException e) 
		{
			out.print(servletName + " DB 연동시 문제 발생");
			e.printStackTrace();
		}
		out.close();
	}

}
