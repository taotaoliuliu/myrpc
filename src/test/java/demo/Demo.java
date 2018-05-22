package demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

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

}
