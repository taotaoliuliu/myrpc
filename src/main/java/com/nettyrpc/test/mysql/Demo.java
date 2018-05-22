package com.nettyrpc.test.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	
	
		private static String url="jdbc:mysql://192.168.137.80:3306/oadata";
		private static String user="root";
		private static String password="123456";
		
		private static String driver="com.mysql.jdbc.Driver";
	
		public static void main(String[] args) {
		
		
		
		try {
			
	/*			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			//CallableStatement prepareCall = connection.prepareCall("select id,name from t_student");
			
			PreparedStatement prepareStatement = connection.prepareStatement("select id,name from t_student");
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			
			
			
			System.out.println(resultSet);
			System.out.println(connection);
			
			connection.close();
			*/
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			Connection connetion = JdbcUtils.getConnetion();
			
			
		//	DataSource dataSource = JdbcUtils.getDataSource();
			
			
			String sql =" select * from t_student";
			
			PreparedStatement prepareStatement = connetion.prepareStatement(sql);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			
			
		while(resultSet.next()){
				int id = resultSet.getInt("id");
				
				String name = resultSet.getString("name");
				
				System.out.println(id+"########"+name);
				
			}
			
			
		connetion.close();
			
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		@Test
		public void testGetData()
		{
			
			try {
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-application.xml"); 

				//dataSource
				
				DataSource dataSource	=(DataSource)ctx.getBean("dataSource");
				
				System.out.println(dataSource);
				
				Connection connetion = dataSource.getConnection();
				
				
				String sql =" select * from t_student";
				
			//	sql="insert into t_student values(9,ddddddd)";
				
				PreparedStatement prepareStatement = connetion.prepareStatement(sql);
				
				ResultSet resultSet = prepareStatement.executeQuery();
				
				
				
while(resultSet.next()){
					int id = resultSet.getInt("id");
					
					String name = resultSet.getString("name");
					
					System.out.println(id+"########"+name);
					
				}
			} catch (BeansException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			
			
		}

		
		
		@Test
		public void testInsertData()
		{
			
			try {
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-application.xml"); 

				//dataSource
				
				DataSource dataSource	=(DataSource)ctx.getBean("dataSource");
				
				System.out.println(dataSource);
				
				Connection connetion = dataSource.getConnection();
				
				
				String sql =" select * from t_student";
				
				sql="insert into t_student (id,name) values (12,'fdffff')";
				
				PreparedStatement prepareStatement = connetion.prepareStatement(sql);
				
				
				boolean execute = prepareStatement.execute();
				
				System.out.println(execute);
				

			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
}
