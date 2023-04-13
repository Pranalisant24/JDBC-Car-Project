package Car;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Cardao {
	Scanner sc= new Scanner(System.in);
	public void save(Cardto user) {
		Connection con=null;
		con=ForConnection.getConnection();
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into car value(?,?,?)");
			
	        ps.setInt(1, user.getId());
	        ps.setString(2, user.getName());
	        ps.setString(3, user.getColor());
	      
	        int result=ps.executeUpdate();
	        
	        if (result > 0) {
				System.out.println("Data is Inserted");
			}
	        else {
				System.err.println("Data is Not Inserted");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void update(Cardto update) {
		Connection con=null;
		con=ForConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("update car set name=? where id=? ");
			
			ps.setString(1, update.getName());
		    ps.setInt(2, update.getId());
			
			int result=ps.executeUpdate();
			
			if (result > 0) {
				System.out.println("Successfully Updated");
			}
			else {
				System.err.println("Not Update");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void showcarbyid(Cardto byid) {
		Connection con=null;
		con=ForConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from car where id=? ");

			ps.setInt(1, byid.getId());
			
		    ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Id "+rs.getInt(1));
				System.out.println("Name :"+rs.getString(1));
				System.out.println("Color :"+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showallcar() {
		Connection con=null;
		con=ForConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("Select * from car ");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("ID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Color : "+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		Connection con=null;
		con=ForConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("delete from car where id=? ");
		
			ps.setInt(1,id );
			
			int rs=ps.executeUpdate();
			
			if (rs > 0) {
				System.out.println("Data is deleted");
			}
			else {
				System.err.println("Data is Not Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
