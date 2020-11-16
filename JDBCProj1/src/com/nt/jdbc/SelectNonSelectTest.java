//SelectNonSelectTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String query=null;
			if(sc!=null) {
				System.out.println("Enter SELECT OR NON-SELECT SQL Query:: (Student)");
				query=sc.nextLine();
			}
            System.out.println();			 
			//register JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");  //optional
			//establish  the the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//create STaement object
			if(con!=null)
				st=con.createStatement();
			//execute the Query
			boolean flag=false;
			if(st!=null)
			   flag=st.execute(query);
			if(flag==true)  // if(flag)
			{
			 System.out.println("SELECT SQL Query is executed");
			   //get ResultSet object
			 rs=st.getResultSet();
			 //process the ResultSet 
			 boolean empty=false;
			 while(rs.next()) {
				 empty=true;
				 System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getString(4));
			 }
			 if(empty==true)
				  System.out.println("Records are retrieved and displayed");
			 else
				 System.out.println("Records not found (Empty RS object)");
			}//if
			else {
				System.out.println("Non-select SQL query is executed");
				//get update count
				int  count=st.getUpdateCount();
				System.out.println("No.of records that are efffeced::"+count);
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
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
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
