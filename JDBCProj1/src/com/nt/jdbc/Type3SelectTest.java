package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Type3SelectTest {
  private static  final String GET_STUDENTS="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) {
		//Load jdbc driver class
		try {
			Class.forName("ids.sql.IDSDriver");
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn=accdsn")) {
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
