//CallableMysqlTest6.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `get_prodDetails_ById`(In id int, out name varchar(15), out rate float, out vol float, out state varchar(15))
BEGIN
   select pname,price,qty,status into name,rate,vol,state  from  product where pid=id;
END
*/

public class CallableMysqlTest7 {
  private static final String CALL_PROCEDURE="{ call get_prodDetails_ById (?,?,?,?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			int id=0;
			if(sc!=null) {
				System.out.println("Enter Product id::");
				id=sc.nextInt();
			}
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1","root","root");
			//Create CallableStatement obj having pre-compiled SQL query
			  if(con!=null)
				  cs=con.prepareCall(CALL_PROCEDURE);
			  
			  //register OUT parameters with JDBC types
			  if(cs!=null) {
				  cs.registerOutParameter(2,Types.VARCHAR);
				  cs.registerOutParameter(3,Types.FLOAT);
				  cs.registerOutParameter(4,Types.FLOAT);
				  cs.registerOutParameter(5,Types.VARCHAR);
			  }
			  //set values to IN params
			  if(cs!=null) {
				  cs.setInt(1,id);
			  }
				//execute PL/SQL procedure
			  if(cs!=null)
				  cs.execute();
			  //gather results from OUT params
			  if(cs!=null) {
				  System.out.println("product name ::"+cs.getString(2));
				  System.out.println("product price::"+cs.getFloat(3));
				  System.out.println("product qty::"+cs.getFloat(4));
				  System.out.println("product status::"+cs.getString(5));
			  }
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
