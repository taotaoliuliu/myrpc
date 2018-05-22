package com.nettyrpc.test.mysql;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource ds;
	//private Statement stmt;
	//private RusultSet conn;
	//private static String url;
	//private static String user;
	//private static String password;
	private JdbcUtils(){}
	static{
		try {
			/*InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			InputStream in2 = JdbcUtils.class.getClass().getResourceAsStream("a.txt");
			Properties prop = new Properties();
			System.out.println(in2);
			System.out.println(in);
			prop.load(in);
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			String url = prop.getProperty("url");
			String driver = prop.getProperty("driverClass");
			
			Class.forName(driver);*/
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			ds=cpds;
			 //conn = DriverManager.getConnection(url, user, password);
			//DriverManager.r
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static DataSource getDataSource()
	{
		return ds;
	}
	public static Connection getConnetion() throws SQLException
	{	Connection conn=ds.getConnection();
		return conn;
	}
	public static void close(Connection conn,Statement stmt,ResultSet rs)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
