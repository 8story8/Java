package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ExDAO {
	private DataSource dataSource;
	public ExDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;		
		System.out.println("spring container로부터 "
		+dataSource+" 주입받음");
	}
	public void find() throws SQLException{
		Connection con=dataSource.getConnection();
		System.out.println(con+" dbcp로부터 빌려옴");
		con.close(); // dbcp에 반납
	}
}







