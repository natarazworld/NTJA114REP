//PostgreSQLApp.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLApp {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//Load jdbc driver class (optional)
			//Class.forName("org.postgresql.Driver");
			//establish the connection
			//con=DriverManager.getConnection("jdbc:postgresql:NTAJ114DB","postgres","tiger");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/NTAJ114DB","postgres","tiger");
			//create statment obj
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL query
			if(st!=null)
				rs=st.executeQuery("SELECT PID,PNAME,PRICE,QTY FROM PRODUCT");
			//process the ResultSet
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3)+"   "+rs.getFloat(4));
				}//while
			}//if
				
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally

	}//main
}//class
