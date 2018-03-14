package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.CarDAO;
import model.CarDTO;
import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class JSONArrayServlet2
 */
@WebServlet("/FindMemberListServlet")
public class FindMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String address = request.getParameter("address");
		ArrayList<MemberVO> list = new MemberDAO().findMemberListByAddress(address);
		// list를 JSONArray로 생성
		JSONArray arr = new JSONArray(list);
		out.println(arr.toString());
	}
}
