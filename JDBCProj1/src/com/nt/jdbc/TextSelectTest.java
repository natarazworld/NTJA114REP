package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TextSelectTest {
  private static  final String GET_STUDENTS="SELECT * FROM file1.csv";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:Text:///E:\\AdvJava")) {
			if(con!=null)
				try(PreparedStatement ps=con.prepareStatement(GET_STUDENTS)){ 
					if(ps!=null)
						try(ResultSet rs=ps.executeQuery(GET_STUDENTS)){
							  if(rs!=null) {
						          System.out.println("Records (top- bottom)");
						          while(rs.next()) {
						        	  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          }//while
							     }//if
						}//try3
					
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
