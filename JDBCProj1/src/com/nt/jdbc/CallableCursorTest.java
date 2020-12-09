//CallableCursorTest.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

/*CREATE OR REPLACE PROCEDURE P_GET_EMPDETAILS_BY_INITIALS 
(
  INITIALLETTERS IN VARCHAR2 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
    OPEN DETAILS FOR
        SELECT  EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE INITIALLETTERS;
 END P_GET_EMPDETAILS_BY_INITIALS;
*/
public class CallableCursorTest {
   private static final String  CALL_PROCEDURE="{ CALL  P_GET_EMPDETAILS_BY_INITIALS(?,?)  }";
	public static void main(String[] args) {
	  Scanner sc=null;
	  Connection con=null;
	  CallableStatement cs=null;
	  ResultSet  rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String initialLetters=null;
			if(sc!=null) {
				System.out.println("Enter initial Letters of employee name::");
				initialLetters=sc.next();  //gives S
			}
			//convert input value as required for  SQL query
			initialLetters=initialLetters+"%"; // gives  S%
			
			//register  JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			
			//create CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_PROCEDURE);
			
			//register  OUT parameter with JDBC data type
			if(cs!=null)
				cs.registerOutParameter(2, OracleTypes.CURSOR);
			//set value to IN params
			if(cs!=null)
				cs.setString(1,initialLetters);
			
			//call / execute PL/SQL Procedure
			 if(cs!=null)
				 cs.execute();
			 
			 //gather results from OUT params
			 if(cs!=null)
			     rs=(ResultSet)cs.getObject(2);
			 
			 //process the ResultSet
			 boolean flag=false;
			 if(rs!=null) {
				 while(rs.next()) {
					 flag=true;
					 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getFloat(4)+"  "+rs.getInt(5));
				 }//while
				  if(flag==false)
					  System.out.println("records not found");
				  else
					  System.out.println("records found and displayed");
			 }//if
		}//try
		catch(SQLException se) {
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
				   if(rs!=null)
					   rs.close();
			   }
			   catch(SQLException se) {
				   se.printStackTrace();
			   }
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
