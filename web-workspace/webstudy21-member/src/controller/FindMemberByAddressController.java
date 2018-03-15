package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberByAddressController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String address=request.getParameter("memberAddress");
		ArrayList<MemberVO> list
		=MemberDAO.getInstance().findMemberListByAddress(address);
		String url=null;
		if(list.isEmpty()){
			url="findMemberByAddress_fail.jsp";
		}else{
			url="findMemberByAddress_ok.jsp";
			request.setAttribute("list", list);
		}
		return url;
	}

}
