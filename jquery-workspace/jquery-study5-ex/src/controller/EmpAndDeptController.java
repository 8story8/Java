package controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.CompanyDAO;

public class EmpAndDeptController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String empNo = request.getParameter("empNo");
		
		HashMap<String, String> map = CompanyDAO.getInstance().getEmpAndDeptInfo(empNo);
		JSONObject json = new JSONObject(map);
		out.println(json.toString());
		return "AjaxView";
	}

}
