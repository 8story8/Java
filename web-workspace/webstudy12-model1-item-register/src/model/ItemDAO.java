package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


// Singleton Pattern 적용 : System상에서 한 번 객체를 생성하고 공유하여 사용한다.


public class ItemDAO
{
	private static ItemDAO dao = new ItemDAO();
	private ItemDAO(){ }
	public static ItemDAO getInstance(){
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DBInfo.URL,"scott","tiger");
	}
	
	public void registerItem(ItemVO itemVO) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con=getConnection();
			
			pstmt=con.prepareStatement("insert into item(item_no, name, maker, price) values(item_seq.nextval, ?, ?, ?)");
			pstmt.setString(1, itemVO.getName());
			pstmt.setString(2, itemVO.getMaker());
			pstmt.setInt(3, itemVO.getPrice());
			pstmt.executeUpdate();
		}
		finally {
			closeAll(pstmt, con);
		}
	}
	
	public ArrayList<ItemVO> getAllItemList() throws SQLException{
		ArrayList<ItemVO> list = new ArrayList<ItemVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			
			pstmt = con.prepareStatement("select item_no,name from item order by item_no desc");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ItemVO vo = new ItemVO(rs.getString(1),rs.getString(2));
				list.add(vo);
			}
		}
		finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public ItemVO findItemByNo(String itemNo) throws SQLException{
		ItemVO vo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con=getConnection();
			
			pstmt = con.prepareStatement("select name, maker, price from item where item_no = ?");
			pstmt.setString(1, itemNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo = new ItemVO(itemNo, rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		}
		finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException{
		closeAll(null, pstmt,con);
	}
	
	public void closeAll(ResultSet rs ,PreparedStatement pstmt, Connection con) throws SQLException{
		if(rs != null){
			rs.close();
		}
		
		if(pstmt != null){
			pstmt.close();
		}
		
		if(con!=null){
			con.close();
		}
	}
}















