package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarDAO;
import model.ListVO;
import model.PagingBean;

public class ListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ListVO listVO = new ListVO();
		listVO.setCarList(CarDAO.getInstance().getCarList());
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setStartPage(1);
		pagingBean.setNowPage(3);
		pagingBean.setEndPage(5);
		
		listVO.setPagingBean(pagingBean);
		
		request.setAttribute("listVO", listVO);
		return "list.jsp";
	}
}
