package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class ItemDAO {
	private DataSource dataSource;
	
	private static ItemDAO instance = new ItemDAO();
	private ItemDAO(){
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static ItemDAO getInstance() throws ClassNotFoundException{
		return instance;
	}
	
	private Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

	public void registerItem(ItemVO ivo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = getConnection();
			
			pstmt = con.prepareStatement("insert into item values(item_seq.nextval, ?, ?, ?, ?)");
			pstmt.setString(1, ivo.getItemName());
			pstmt.setString(2, ivo.getItemMaker());
			pstmt.setInt(3, ivo.getItemPrice());
			pstmt.setString(4, ivo.getItemDetail());
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(pstmt, con);
		}
	}
	
	public ArrayList<ItemVO> getAllProductList() throws SQLException{
		ArrayList<ItemVO> list = new ArrayList<ItemVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			
			pstmt = con.prepareStatement("select itemNo, itemName, itemMaker from item order by itemNo desc");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				list.add(new ItemVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public ItemVO findItemByNo(int itemNo) throws SQLException{
		ItemVO ivo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			
			pstmt = con.prepareStatement("select itemName, itemMaker, itemPrice, itemDetail from item where itemNo = ?");
			pstmt.setInt(1, itemNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				ivo = new ItemVO(itemNo, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return ivo;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException{
		if(pstmt != null){
			pstmt.close();
		}
		
		if(con != null){
			con.close();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException{
		if(rs != null){
			rs.close();
		}
		closeAll(pstmt, con);
	}
}
