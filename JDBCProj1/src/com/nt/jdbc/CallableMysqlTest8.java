//CallableMysqlTest7.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*USE `ntaj114db1`;
DROP procedure IF EXISTS `get_prodDetailsByPriceRange`;

DELIMITER $$
USE `ntaj114db1`$$
CREATE PROCEDURE `get_prodDetailsByPriceRange` (In start float, In end float)
BEGIN

select pid,pname,price,qty,status from product where price>=start and price<=end;

END$$

DELIMITER ;
*/
public class CallableMysqlTest8 {
  private static final String CALL_PROCEDURE="{ call  get_prodDetailsByPriceRange(?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			float start=0,end=0;
			if(sc!=null) {
				System.out.println("Enter Price  start range::");
				start=sc.nextFloat();
				System.out.println("Enter Price end range::");
				end=sc.nextFloat();
			}
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1","root","root");
			//Create CallableStatement obj having pre-compiled SQL query
			  if(con!=null)
				  cs=con.prepareCall(CALL_PROCEDURE);
			  //set values to IN params
			  if(cs!=null) {
				  cs.setFloat(1,start);
				  cs.setFloat(2,end);
			  }
				//execute PL/SQL procedure
			  if(cs!=null)
				  cs.execute();
			  
			  //gather results from OUT params
			  if(cs!=null) {
				   ResultSet rs=cs.getResultSet();
				   boolean flag=false;
				   if(rs!=null) {
					   while(rs.next()) {
						   flag=true;
						   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3)+"  "+rs.getFloat(4)+" "+rs.getString(5));
					   }//while
					   if(flag==false)
						   System.out.println("no records are found");
					   else
						   System.out.println("records are found and displayed");
				   }//if
				   
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
