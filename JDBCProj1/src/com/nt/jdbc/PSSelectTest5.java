package com.nt.jdbc;
/*    Java App using JDBC to get highest salary employees details from emp db table 
 * 
 */
import java.sql.Connection;   //ctrl+shift+o  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PSSelectTest5 {
  private static final String   GET_EMP_DETAILS_WITH_MAX_SAL="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//registr jdbc driver by loading jdbc driver class (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			 //create Statement object
			if(con!=null)
				ps=con.prepareStatement(GET_EMP_DETAILS_WITH_MAX_SAL);
			//prepare SQL Query
			
			//send and execute SQL query in DB s/w
			if(ps!=null)
				rs=ps.executeQuery();
			//process the ResultSet
			boolean flag=false;
			if(rs!=null) {
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getFloat(4));
				}//while
			}//if
			if(flag==false)
				System.out.println("No Records found---Db table is empty");
			else
				System.out.println("Records found and displayed");
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
		}//finally

	}//main
}//class
