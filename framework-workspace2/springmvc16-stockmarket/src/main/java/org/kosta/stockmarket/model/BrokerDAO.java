package org.kosta.stockmarket.model;


import java.util.List;


public interface BrokerDAO {		
	public CustomerVO login(CustomerVO cvo) ;	
	public List<StockVO> getStockList() ;	
	public List<SharesVO> getSharesList(String id);
	public int getSharesCount(SharesVO svo);
	public void insertBuyShares(SharesVO svo);
	public void updateBuyShares(SharesVO svo);
	public Object getSharesQuantity(SharesVO svo);
	public void updateSellShares(SharesVO svo);
	public void deleteSellShares(SharesVO svo);
}














