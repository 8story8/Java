package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ItemServiceImpl implements ItemService {
	private ItemDAO itemDAO;
	
	public ItemServiceImpl(ItemDAO itemDAO) {
		super();
		this.itemDAO = itemDAO;
	}
	@Override
	public Map<String, Object> getListAndAvgPriceInfo(String maker) throws SQLException {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", itemDAO.getItemListByMaker(maker));
		map.put("avgPriceInfo", itemDAO.getAvgPriceByMaker(maker));
		return map;
	}

}






