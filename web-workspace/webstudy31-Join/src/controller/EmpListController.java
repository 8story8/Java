package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmpDAO;
import model.EmpVO;

public class EmpListController  implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		ArrayList<EmpVO> empList = EmpDAO.getInstance().getEmpList();
		request.setAttribute("empList", empList);
		return "list.jsp";
	}
}







