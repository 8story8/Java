package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
	public ArrayList<ItemVO> getItemListByMaker(String maker) throws SQLException;
	public int getAvgPriceByMaker(String maker) throws SQLException;
}
