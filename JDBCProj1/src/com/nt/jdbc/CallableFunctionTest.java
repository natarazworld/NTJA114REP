package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*create or replace FUNCTION FX_GET_STUIDENT_DETAILS_BY_NO 
(
  NO IN NUMBER 
, ADDRS OUT VARCHAR2 
, STAVG OUT FLOAT 
) RETURN VARCHAR2 AS 
  name varchar2(10);
BEGIN
  
  SELECT SNAME,SADD,AVG INTO NAME,ADDRS,STAVG  FROM STUDENT WHERE SNO=no;
  
  return  name;
  
END FX_GET_STUIDENT_DETAILS_BY_NO;
*/
public class CallableFunctionTest {
  private static final String  CALL_FUNCTION="{?=call  FX_GET_STUIDENT_DETAILS_BY_NO (?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int no=0;
			if(sc!=null) {
				System.out.println("Enter student number ::");
				no=sc.nextInt();
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
				cs.registerOutParameter(1, Types.VARCHAR);   //return param
				cs.registerOutParameter(3,Types.VARCHAR);  //out param
				cs.registerOutParameter(4,Types.FLOAT); //out param
				//set values to IN params
				cs.setInt(2,no);
				//execute /call PL/SQL function
				cs.execute();
				//gather results from return,out params
				System.out.println("Student name::"+cs.getString(1));  //return param
				System.out.println("Student address::"+cs.getString(3)); // out param
				System.out.println("Student marks avg::"+cs.getFloat(4)); //out param
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
