package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableRSTest {
  private static  final String GET_STUDENTS="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")) {
			if(con!=null)
				//try(Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY)){
				try(Statement st=con.createStatement(1005,1007)){
					if(st!=null)
						try(ResultSet rs=st.executeQuery(GET_STUDENTS)){
							  if(rs!=null) {
						          System.out.println("Records (top- bottom)");
						          while(rs.next()) {
						        	  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          }//while
						          System.out.println("Records (botton-top");
						          while(rs.previous()) {
						        	  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          }//while
						          System.out.println("first record");
						          rs.first();
						          System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          System.out.println("last record");
						          rs.last();
						          System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          
						          System.out.println("Displyaing records  directly/randomdly");
						          rs.absolute(4);
						          System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          rs.absolute(-3);
						          System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          rs.relative(2);
						          System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          rs.relative(-3);
						          System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
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
