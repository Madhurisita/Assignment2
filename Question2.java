package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER CATEGORY");
		System.out.println("1: ELECTRONICS");
		System.out.println("2: COM");
		String cat=sc.next();

		Connection con=null;
		Statement stmt=null;
		ResultSet rs= null;
		
			
		String query="select  product_name from product_data where product_category='electronics'";		

		System.out.println();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=admin");
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				
				String name=rs.getString("product_name");
				
				System.out.println(	name);

				
				System.out.println("-------------------------------");
			}
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} 
				catch (SQLException e)
				{
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
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

}
