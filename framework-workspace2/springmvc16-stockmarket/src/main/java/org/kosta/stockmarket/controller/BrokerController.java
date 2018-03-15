package org.kosta.stockmarket.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.stockmarket.model.BrokerService;
import org.kosta.stockmarket.model.CustomerVO;
import org.kosta.stockmarket.model.InvalidTransactionException;
import org.kosta.stockmarket.model.SharesVO;
import org.kosta.stockmarket.model.StockVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BrokerController  {
	
	@Resource
	private BrokerService brokerService;
	
	@RequestMapping("stockMarket.do")
	public ModelAndView home(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("cvo") == null){
			return new ModelAndView("stock_market","stockList",brokerService.getStockList());
		}
		else{
			ModelAndView mv = new ModelAndView(); 
			
			List<StockVO> stockList = brokerService.getStockList();
			mv.addObject("stockList", stockList);
			
			CustomerVO cvo=(CustomerVO) session.getAttribute("cvo");
			
			List<SharesVO> sharesList = brokerService.getSharesList(cvo.getId());
			mv.addObject("sharesList", sharesList);
			mv.setViewName("stock_market");
			
			return mv;
		}			
	}		
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(CustomerVO paramVO, HttpServletRequest request) {		
		CustomerVO cvo = brokerService.login(paramVO);		
		
		if(cvo != null) {			
			HttpSession session = request.getSession();
			session.setAttribute("cvo", cvo);
			
			return new ModelAndView("redirect:stockMarket.do");
		}
		else{			
			return new ModelAndView("login_fail");
		}		
	}	
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		
		if(session != null){
			session.invalidate();
		}
		
		return "redirect:stockMarket.do";
	}
	
	@RequestMapping(value = "trade.do", method = RequestMethod.POST)
	@ResponseBody
	public Object trade(SharesVO svo, String tradeType){		
		if(tradeType.equals("buy")){
			brokerService.buyStock(svo);
		}
		else{
			try {
				brokerService.sellStock(svo);
			} 
			catch (InvalidTransactionException e) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("error","fail");
				map.put("message", e.getMessage());
				return map;
			}
		}
		
		return brokerService.getSharesList(svo.getId());
	}
}


















