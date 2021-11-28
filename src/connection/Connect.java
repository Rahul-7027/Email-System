package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connect {

	private static Connection connection=null;
	static{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		
		 String url ="jdbc:mysql://localhost:3306/mymail"; 
		 String user ="root"; 
		 String password ="root";
		 
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mymail","root","root");
		System.out.println("bhartirawat"+ connection);
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public static Connection getConnection(){
		
		return connection;

	}
}
