package utility;

import java.sql.*;

public class DBConnection 
{
   private static final String  URL="jdbc:mysql://localhost:3306/smart_complaint_db";
   private static final String USERNAME="root";
   private static final String PASSWORD="AratiSQL@8";
   
   public static Connection getConnection()
   {
	   Connection conn=null;
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		   
		System.out.println("database connected");		   
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return conn;
   }
}
