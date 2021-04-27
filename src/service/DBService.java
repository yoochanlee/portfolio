package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	//BasicDataSource객체의 기능을 사용할 수 있는 interface
	//사용할 수 있는 설명서
	
	DataSource ds = null;
	
	//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static DBService single = null;

	public static DBService getInstance() {

		if (single == null)
			single = new DBService();
		return single;
	}

	private DBService() {
		// TODO Auto-generated constructor stub
		//JNDI를 이용한 자원의 정보를 획득...
		
		try {
			//1.JNDI획득하기위한 객체생성
			InitialContext ic = new InitialContext();
			
			//2.Resource가 기록된 위치를 검색
			Context ctx = (Context) ic.lookup("java:comp/env");
			
			//3.Context내의 자원(DataSource) 검색 
			ds = (DataSource) ctx.lookup("jdbc/Oracle_test");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
	}
	
	
	
	
	
	
	
	
}
