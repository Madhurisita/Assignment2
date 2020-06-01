import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductMinMax {

	
		  static Connection con;
		    static
			{
		       try
		       {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=admin");
				
		       } 
		       catch (ClassNotFoundException | SQLException e)
		       {
				e.printStackTrace();
			}
			}
		
		    
		    public void maxproduct() throws ClassNotFoundException 
			{
		try {
			
			Statement stmt=null;
			ResultSet rs=null;
			String query="select * from product_data where product_price= (select max(product_price) from product_data )";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			
			while(rs.next())
			{
				int id=rs.getInt("product_id");
				String name=rs.getString("product_name");
				double value=rs.getDouble("product_price");
				System.out.println(id+" "+name+" "+value);
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void minproduct() throws ClassNotFoundException {
		try {
			
			Statement stmt=null;
			ResultSet rs=null;
			String query="select * from product_data where product_price= (select min(product_price) from product_data )";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			
			while(rs.next())
			{
				int id=rs.getInt("product_id");
				String name=rs.getString("product_name");
				double value=rs.getDouble("product_price");
				System.out.println(id+" "+name+" "+value);
				
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}

}
