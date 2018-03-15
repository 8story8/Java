package org.kosta.stockmarket.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BrokerDAOImpl implements BrokerDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	public CustomerVO login(CustomerVO cvo) {
		return sqlSessionTemplate.selectOne("broker.login", cvo);
	}

	public List<StockVO> getStockList() {
		return sqlSessionTemplate.selectList("broker.getStockList");
	}

	@Override
	public List<SharesVO> getSharesList(String id) {
		return sqlSessionTemplate.selectList("broker.getSharesList",id);
	}
	
	@Override
	public int getSharesCount(SharesVO svo) {		
		return sqlSessionTemplate.selectOne("broker.getSharesCount",svo);
	}
	
	@Override
	public void insertBuyShares(SharesVO svo) {		
		sqlSessionTemplate.insert("broker.insertBuyShares",svo);
	}
	
	@Override
	public void updateBuyShares(SharesVO svo) {		
		sqlSessionTemplate.update("broker.updateBuyShares",svo);
	}
	
	@Override
	public Object getSharesQuantity(SharesVO svo) {
		return sqlSessionTemplate.selectOne("broker.getSharesQuantity",svo);
	}
	
	@Override
	public void updateSellShares(SharesVO svo) {		
		sqlSessionTemplate.update("broker.updateSellShares",svo);
	}
	
	@Override
	public void deleteSellShares(SharesVO svo) {
		sqlSessionTemplate.delete("broker.deleteSellShares",svo);
	}
}






