package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemDAO;
import model.ItemVO;

public class DeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		System.out.println("아나 시발" + itemNo);
		ArrayList<ItemVO> cartList = (ArrayList<ItemVO>) session.getAttribute("cartList");
		
		for(int i = 0; i < cartList.size(); i++){
			if(itemNo == cartList.get(i).getItemNo()){
				cartList.remove(i);
				break;
			}
		}
		
		session.setAttribute("cartList", cartList);
		return "redirect:cart.jsp";
	}
}
