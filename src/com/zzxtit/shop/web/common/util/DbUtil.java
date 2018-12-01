package com.zzxtit.shop.web.common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.druid.pool.DruidDataSource;

public class DbUtil {
	
	private static DruidDataSource dds;
	private static final String ORACLE_URL = "jdbc:mysql://localhost:3306/zzxtit";
	private static final String ORACLE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String ORACLE_USERNAME = "root";
	private static final String ORACLE_PASSWORD = "root";
	
	static {
		dds=new DruidDataSource();
		dds.setUrl(ORACLE_URL);
		dds.setDriverClassName(ORACLE_DRIVER);
		dds.setUsername(ORACLE_USERNAME);
		dds.setPassword(ORACLE_PASSWORD);
	}
	
	public static DruidDataSource getDataSource() {
		return dds;
	}
	
	public static Connection getConn() {
		try {
			return dds.getPooledConnection().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection con,Statement statement,ResultSet rs) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
