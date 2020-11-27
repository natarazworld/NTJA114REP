package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonAgeCalculatorMysql {
	private  static final String  CALCULATE_AGE="SELECT  DATEDIFF(now(),DOB)/365.0 FROM PS_PERSON_INFO WHERE PID=? ";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int pid=0;
			if(sc!=null) {
				System.out.println("Enter person id::");
				pid=sc.nextInt();
			}
			//register  jdbc driver s/w
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1", "root","root");
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(CALCULATE_AGE);
			//set values to query param
			if(ps!=null)
				ps.setInt(1,pid);
			//execute  the SQL query
			 if(ps!=null)
				   rs=ps.executeQuery();
			 //process the Result
			  if(rs!=null) {
				  if(rs.next()) {
					  float age=rs.getFloat(1);
					  System.out.println("Person age::"+age);
				  }
				  else {
					  System.out.println("Person not found");
				  }
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
				if(ps!=null)
					ps.close();
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
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally
	}//main
}//class
