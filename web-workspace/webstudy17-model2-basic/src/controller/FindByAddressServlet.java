package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * Servlet implementation class FindByAddressServlet
 */
@WebServlet("/FindByAddressServlet")
public class FindByAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getParameter("addr");
		ArrayList<String> list = MockDAO.getInstance().findByAddress(addr);
		String url = null;
		
		request.setAttribute("addr", addr);
		request.setAttribute("list", list);
		
		if(list.size() == 0){
			url = "findByAddress_fail.jsp";
		}
		else{
			url = "findByAddress_ok.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
