package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensitveRSTest {
  private static  final String GET_STUDENTS="SELECT * FROM STUDENT";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")) {
			if(con!=null)
				//try(Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY)){
				//try(Statement st=con.createStatement(1005,1007)){
				try(PreparedStatement ps=con.prepareStatement(GET_STUDENTS, 
						                                                                                              ResultSet.TYPE_SCROLL_INSENSITIVE,
						                                                                                              ResultSet.CONCUR_READ_ONLY)){ 
					if(ps!=null)
						try(ResultSet rs=ps.executeQuery(GET_STUDENTS)){
							  if(rs!=null) {
						          System.out.println("Records (top- bottom)");
						          int count=0;
						          while(rs.next()) {
						        	//  rs.refreshRow();
						        	  if(count==0) {
						        		  System.out.println("App is in sleep state , So go to Db table and modify the records");
						        		  Thread.sleep(40000);
						        	  }
						        	  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						        	  count++;
						          }//while
							  }
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
