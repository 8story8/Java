package step2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMemberByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try 
		{
			MemberVO vo = MemberDAO.getInstance().findMember(request.getParameter("memberId"));
			
			if(vo == null)
			{
				out.print(request.getParameter("memberId") + " 아이디에 해당하는 회원 없음!");
			}
			else
			{
				out.print("아이디 : " + vo.getId() + "<br>");
				out.print("이름 : " + vo.getName() + "<br>");
				out.print("주소 : " + vo.getAddress());
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		out.close();
	}

}
