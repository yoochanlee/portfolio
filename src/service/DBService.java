package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	//BasicDataSource��ü�� ����� ����� �� �ִ� interface
	//����� �� �ִ� ����
	
	DataSource ds = null;
	
	//single-ton : ��ü 1���������ؼ� ���(����)����
	static DBService single = null;

	public static DBService getInstance() {

		if (single == null)
			single = new DBService();
		return single;
	}

	private DBService() {
		// TODO Auto-generated constructor stub
		//JNDI�� �̿��� �ڿ��� ������ ȹ��...
		
		try {
			//1.JNDIȹ���ϱ����� ��ü����
			InitialContext ic = new InitialContext();
			
			//2.Resource�� ��ϵ� ��ġ�� �˻�
			Context ctx = (Context) ic.lookup("java:comp/env");
			
			//3.Context���� �ڿ�(DataSource) �˻� 
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
