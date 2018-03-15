package org.kosta.stockmarket.model;

import java.util.List;


public interface BrokerService {	
	public CustomerVO login(CustomerVO cvo) ;   
    public List<StockVO> getStockList() ;  
    public List<SharesVO> getSharesList(String id);
    public void buyStock(SharesVO svo);
    public void sellStock(SharesVO svo) throws InvalidTransactionException;
}
