package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*create or replace PROCEDURE P_AUTHENTICATION 
(
  UNAME IN VARCHAR2 
, PWD IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
  CNT NUMBER(3);
BEGIN
  
  SELECT COUNT(*) INTO CNT FROM USERSLIST WHERE USERNAME=UNAME AND PASSWORD=PWD;
  IF(CNT<>0) THEN
   RESULT:='VALID CREDENTIALS';
  ELSE
   RESULT:='INVALID CREDENTIALS';
  END IF; 
  
END P_AUTHENTICATION;

*/
public class CallableTest3 {
 private static final String  CALL_PROCEDURE="{CALL P_AUTHENTICATION(?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		try {
			sc=new Scanner(System.in);
			String username=null,password=null;
			if(sc!=null) {
				System.out.println("enter username::");
				username=sc.nextLine();
				System.out.println("Enter password::");
				password=sc.nextLine();
			}
			
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establihs the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_PROCEDURE);
			
			
			if(cs!=null) {
				//register OUT parameter with jdbc types
				cs.registerOutParameter(3, Types.VARCHAR);
				//set values to IN params
				cs.setString(1,username);
				cs.setString(2,password);
				//call PL/SQL procedure
				cs.execute(); 
				//gather  results from OUT params
				 String  result=cs.getString(3);
				 System.out.println("result::"+result);
			}
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
