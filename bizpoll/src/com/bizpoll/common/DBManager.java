package com.bizpoll.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;
		
		// data source 를 이용한 connection
		try {
			Context initContext = new InitialContext();
			// initContext의 lookup메서드를 이용해서 "java:/comp/env"에 해당하는 객체를 찾아서 envContext에 삽
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			
			//envContext의 lookup메서드를 이용해서 "jdbc/myoracle"에 해당하는 객체를 찾아서 ds에 삽입
			DataSource  ds = (DataSource) envContext.lookup("jdbc/myoracle"); //jndi 방식
			
			//getConnection메서드를 이용해서 커션 풀로 부터 커넥션 객체를 얻어내어 conn변수에 저장
			conn = ds.getConnection();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
