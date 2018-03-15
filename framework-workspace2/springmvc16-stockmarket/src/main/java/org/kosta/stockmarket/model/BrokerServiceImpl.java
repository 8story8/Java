package org.kosta.stockmarket.model;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service
public class BrokerServiceImpl implements BrokerService{
	@Resource
	private BrokerDAO brokerDAO;
	
	@Override
	public CustomerVO login(CustomerVO cvo){
		return brokerDAO.login(cvo);
	}   
	
	@Override
    public List<StockVO> getStockList(){
		return brokerDAO.getStockList();
	}
    
	@Override
	public List<SharesVO> getSharesList(String id) {		
		return brokerDAO.getSharesList(id);
	}
	
	@Override
	public void buyStock(SharesVO svo) {
		int count=brokerDAO.getSharesCount(svo);
		
		if(count==0){
			brokerDAO.insertBuyShares(svo);
		}
		else{
			brokerDAO.updateBuyShares(svo);
		}
	}
	
	@Override
	public void sellStock(SharesVO svo) throws InvalidTransactionException {
		Object retValue = brokerDAO.getSharesQuantity(svo);	
		
		if(retValue==null){
			throw new InvalidTransactionException(svo.getSymbol() + " 주식을 보유하고 있지 않아 매도할 수 없습니다!");
		}
		
		int quantity = (Integer) retValue;
		
		if(quantity == svo.getQuantity()){
			brokerDAO.deleteSellShares(svo);
		}
		else if(quantity > svo.getQuantity()){					
			brokerDAO.updateSellShares(svo);
		}
		else if(quantity < svo.getQuantity()){			
			throw new InvalidTransactionException(svo.getSymbol() + " 주식의 보유 수량보다 매도 수량이 많아 처리할 수 없습니다!");
		}	
	}    	
}








