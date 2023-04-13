package Car;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ForConnection {
	public static Connection getConnection() {
		Connection con=null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_project?user=root&password=tiger");

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;

	}   
}

