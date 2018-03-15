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
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		requestProcess(request, response);
	}
	
	public void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Client가 어떤 Service를 원하는지 분석
		String command = request.getParameter("command");
		String url = null;
		boolean isRedirect = false;
		if(command.equals("find")){
			String id = request.getParameter("id");
			String result = MockDAO.getInstance().findById(id);
			
			if(result == null){
				url = "find_fail.jsp";
			}
			else{
				url = "find_ok.jsp";
				request.setAttribute("result", result);
			}
		}
		else if(command.equals("insert")){
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			MockDAO.getInstance().insert(name, addr);
			url = "insert_result.jsp";
			isRedirect = true;
		}
		else if(command.equals("findByAddress")){
			String addr = request.getParameter("addr");
			ArrayList<String> list = MockDAO.getInstance().findByAddress(addr);
			
			if(list.isEmpty()){   // list.size() == 0과 동일
				url = "findByAddress_fail.jsp";
			}
			else{
				url = "findByAddress_ok.jsp";
				request.setAttribute("list", list);
				request.setAttribute("addr", addr);
			}
		}
		else if(command.equals("update")){
			String nickName = request.getParameter("nickName");
			MockDAO.getInstance().updateNick(nickName);
			url = "update_result.jsp";
			isRedirect = true;
		}
		
		if(isRedirect){
			response.sendRedirect(url);
		}
		else{
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
