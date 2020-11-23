package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSUpdateTest {
	 private static  final String  UPDATE_STUDENT_QUERY="UPDATE STUDENT SET SADD=?,AVG=? WHERE SNO=?";
	public static void main(String[] args) {
		
		Scanner sc=null;
		PreparedStatement ps=null;
		Connection con=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int no=0;
			String newAddrs=null;
			float newAvg=0.0f;
			if(sc!=null) {
			   System.out.println("Enter student number::");
			   no=sc.nextInt(); //gives 9001
			   System.out.println("Enter student new Address::");
			                         sc.nextLine();  //Dummy nextLine becoz Eclipse ignores first nextLine()
			   newAddrs=sc.nextLine();  //gives new delhi
			   System.out.println("enter student new Avg::");
			   newAvg=sc.nextFloat(); // gives  89.7
			}
			
			
			//Load jdbc driver class  (optional)
			 //Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			//establisht the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
			 ps=con.prepareStatement(UPDATE_STUDENT_QUERY);
			
			//set values to query params(?)
			if(ps!=null) {
				ps.setString(1, newAddrs);
				ps.setFloat(2,newAvg);
				ps.setInt(3,no);
			}

			int count=0;
			 if(ps!=null)
				 count=ps.executeUpdate();
			 
			 
			   System.out.println("no.of records that are effected::"+count);
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc and stream objs
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
