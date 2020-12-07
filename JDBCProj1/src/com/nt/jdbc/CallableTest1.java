package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*CREATE OR REPLACE PROCEDURE P_FIRST(  X IN NUMBER , Y IN NUMBER , Z OUT NUMBER ) AS 
BEGIN
   Z:=X+Y;
END ;
*/
public class CallableTest1 {
  private static final String CALL_PROCEDURE="{CALL P_FIRST(?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			int first=0,second=0;
			if(sc!=null) {
				System.out.println("Enter First value::");
				first=sc.nextInt();
				System.out.println("enter second value::");
				second=sc.nextInt();
			}
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//Create CallableStatement obj having pre-compiled SQL query
			  if(con!=null)
				  cs=con.prepareCall(CALL_PROCEDURE);
			  //register OUT parameters with JDBC types
			  if(cs!=null)
				  cs.registerOutParameter(3,Types.INTEGER);
			  //set values to IN params
			  if(cs!=null) {
				  cs.setInt(1,first);
				  cs.setInt(2,second);
			  }
				//execute PL/SQL procedure
			  if(cs!=null)
				  cs.execute();
			  //gather results from OUT params
			  if(cs!=null)
				  System.out.println("Sum ::"+cs.getInt(3));
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
				if(cs!=null)
					cs.close();
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
