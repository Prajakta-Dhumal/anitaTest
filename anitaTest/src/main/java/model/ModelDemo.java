package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelDemo 
{
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swatitest?user=root&password=sql@123");
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public double getBill(String itemName, String deliveryType) 
	{
		PreparedStatement pstmt;
		ResultSet rs;
		double bill=0;
		String query="select price from groceryitem where grocery_name=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,itemName);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(deliveryType.equalsIgnoreCase("regular")) 
				{
				   bill=rs.getDouble(1)+50;	
					
				}
				else 
				{
					bill=rs.getDouble(1)+70;
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill;
		
	}
	

}
