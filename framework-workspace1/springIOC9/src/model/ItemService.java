package model;

import java.sql.SQLException;
import java.util.Map;

public interface ItemService {
	public Map<String,Object> getListAndAvgPriceInfo(String maker) throws SQLException;
}
