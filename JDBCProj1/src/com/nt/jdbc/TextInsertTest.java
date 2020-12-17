package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TextInsertTest {
  private static  final String INSERT_STUDENT="INSERT INTO file1.csv Values(?,?,?,?)";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:Text:///E:\\AdvJava")) {
			if(con!=null)
				try(PreparedStatement ps=con.prepareStatement(INSERT_STUDENT)){ 
					if(ps!=null) {
					    //set value to query params
					    ps.setInt(1, 527);
					    ps.setString(2, "rajesh");
					    ps.setString(3,"hyd");
					    ps.setFloat(4,89.66f);
					    //execute the Query
					    int result=ps.executeUpdate();
					    //process the Result
					    if(result==0)
					    	 System.out.println("record not inserted");
					    else
					    	System.out.println("record inserted");
						     }//if
				}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//clas
