package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*CREATE OR REPLACE FUNCTION FX_DELTE_STUDENTS_BY_CITIES 
(
  CITY1 IN VARCHAR2 
, CITY2 IN VARCHAR2 
) RETURN NUMBER AS 
BEGIN

  DELETE FROM  STUDENT WHERE  SADD IN (CITY1,CITY2);

return SQL%ROWCOUNT;
END FX_DELTE_STUDENTS_BY_CITIES;
*/
public class CallableFunctionTest1 {
  private static final String  CALL_FUNCTION="{?=call FX_DELTE_STUDENTS_BY_CITIES  (?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String  city1=null,city2=null;
			
			if(sc!=null) {
				System.out.println("Enter city1 ::");
				city1=sc.next();
				System.out.println("Enter city2::");
				city2=sc.next();

			}
			//register  JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_FUNCTION);

			if(cs!=null) {
				//register   OUT , return params with JDBC data types
				cs.registerOutParameter(1, Types.INTEGER);   //return param
				//set values to IN params
				cs.setString(2,city1);
				cs.setString(3,city2);
				//execute /call PL/SQL function
				cs.execute();
				//gather results from return,out params
				System.out.println("no.of records that  are effected::"+cs.getInt(1));  //return param
			}
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()==1403)
				System.out.println("record not found");
			else
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
