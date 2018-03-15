package model;

import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/**
 * DBCP
 * WAS에서 제공하는 DBCP(DataBase Connection Pool)을 생성해 사용한다.
 * WAS별로 제공하는 DBCP는 다양하므로 javax.sql.DataSource 인터페이스 타입으로 관리한다.
 *
 * @author kosta
 *
 */

public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource dataSource;
	
	private DataSourceManager(){
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dbcp.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dbcp.setUsername("scott");
		dbcp.setPassword("tiger");
		dataSource = dbcp;
	}
	
	public static DataSourceManager getInstance(){
		return instance;
	}
	
	public DataSource getDataSource(){
		return dataSource;
	}
}
