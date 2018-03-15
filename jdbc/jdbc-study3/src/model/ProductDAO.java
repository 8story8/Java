package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO(Data Access Object)

public class ProductDAO 
{
	public ProductDAO() throws ClassNotFoundException
	{
		Class.forName(DBInfo.DRIVER);
	}
	
	public ProductVO findProductById(String id) throws SQLException 
	{
		ProductVO vo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement("select name, maker, price from product where id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				vo = new ProductVO(id, rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
	
	public void registerProduct(ProductVO pvo) throws SQLException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			sql.append("insert into product values(?, ?, ? ,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pvo.getId());
			pstmt.setString(2, pvo.getName());
			pstmt.setString(3, pvo.getMaker());
			pstmt.setInt(4, pvo.getPrice());
			
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(pstmt, con);
		}
	}
	
	public ArrayList<ProductVO> getProductListByPrice(int lowPrice, int highPrice) throws SQLException 
	{
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select * from product where price >= ? and price <= ? order by price desc");
			pstmt.setInt(1, lowPrice);
			pstmt.setInt(2, highPrice);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				list.add(new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public ArrayList<String> getProductMakerKind() throws SQLException 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select distinct maker from product");
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				list.add(rs.getString(1));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public ArrayList<ProductVO> getProductListDiscountPrice(int percent) throws SQLException 
	{
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select id, name, maker, price-price/? from product order by price desc");
			pstmt.setInt(1, percent);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				list.add(new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(pstmt != null)
		{
			pstmt.close();
		}
		
		if(con != null)
		{
			con.close();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(rs != null)
		{
			rs.close();
		}
		
		closeAll(pstmt, con);
	}

	
}
