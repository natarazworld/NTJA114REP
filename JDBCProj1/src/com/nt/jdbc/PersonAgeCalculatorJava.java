//PersonAgeCalculator.java
package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonAgeCalculatorJava {
  private  static final String  GET_DOB="SELECT DOB  FROM  PS_PERSON_INFO WHERE PID=? ";
  
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
			/*//register  jdbc driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");*/
			
			//register  jdbc driver s/w
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1", "root","root");
			
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(GET_DOB);
			//set values to query param
			if(ps!=null)
				ps.setInt(1,pid);
			//execute  the SQL query
			 if(ps!=null)
				   rs=ps.executeQuery();
			 //process the Result
			  if(rs!=null) {
				  if(rs.next()) {
					  //get DOB 
					  java.util.Date sqdob=rs.getDate(1);
					  //get sys date
					  java.util.Date   sysDate=new java.util.Date();
					  float age=(sysDate.getTime()-sqdob.getTime())/(1000.0f*60.0f*60.0f*24.0f*365.0f);
					  System.out.println("person age::"+age);
						  }//if
				  else {
					  System.out.println("person not found");
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
