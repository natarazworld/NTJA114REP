package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*CREATE OR REPLACE PROCEDURE P_GET_STUDENTDETAILS_BY_NO 
(
  NO IN NUMBER 
, NAME OUT VARCHAR2 
, ADDRS OUT VARCHAR2 
) AS 
BEGIN
  
  SELECT SNAME,SADD INTO NAME,ADDRS FROM STUDENT WHERE SNO=NO;
  
END P_GET_STUDENTDETAILS_BY_NO;
*/
public class CallableTest2 {
     private static final String CALL_PROCEDURE="{CALL P_GET_STUDENTDETAILS_BY_NO(?,?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int no=0;
			if(sc!=null) {
				System.out.println("Enter Student number ::");
				no=sc.nextInt(); //gives 1001
			}
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			 //create CallableStaement object having query as the pre-compiled SQL query
			 if(con!=null)
				 cs=con.prepareCall(CALL_PROCEDURE);
			 //regsiter  OUT parameters with JDBC type
				 if(cs!=null) {
					 cs.registerOutParameter(2, Types.VARCHAR);
					 cs.registerOutParameter(3,Types.VARCHAR);
				 }
			 //set values to IN params
			 if(cs!=null)
				 cs.setInt(1, no);
			 //execute or call PL/SQL function
			 if(cs!=null)
				 cs.execute();
			 //gather results from  OUT params
			 if(cs!=null) {
				 System.out.println("student name:: "+cs.getString(2));
				 System.out.println("Student address::"+cs.getString(3));
			 }
			 
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()==1403)
				  System.out.println("record not found");
			else if(se.getErrorCode()==911)
				  System.out.println("problem is Query Syntax");
			else
			 se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
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
