package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmpDAO;
import model.EmpVO;

public class EmpDetailController  implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String empNo = request.getParameter("empNo");
		EmpVO evo = EmpDAO.getInstance().findEmpByNo(empNo);
		request.setAttribute("evo", evo);
		return "detail_emp.jsp";
	}
}







