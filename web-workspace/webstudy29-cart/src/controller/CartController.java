package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DuplicateItemException;
import model.ItemDAO;
import model.ItemVO;

public class CartController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		String url = "addCart_result.jsp";
		
			if(session.getAttribute("cartList") == null){
				ArrayList<ItemVO> initList = new ArrayList<ItemVO>();
				initList.add(ItemDAO.getInstance().findItemByNo(itemNo));
				session.setAttribute("cartList", initList);
			}
			else{
				ArrayList<ItemVO> cartList = (ArrayList<ItemVO>) session.getAttribute("cartList");
					try{
						for(int i = 0; i < cartList.size(); i++){
							if(itemNo == cartList.get(i).getItemNo()){
								throw new DuplicateItemException();
							}
						}
						cartList.add(ItemDAO.getInstance().findItemByNo(itemNo));
						session.setAttribute("cartList", cartList);
						url = "addCart_result.jsp";
					}
					catch(DuplicateItemException e){
						url =  "duplicate_cart.jsp";
					}
			}
			return url;
	}
}


