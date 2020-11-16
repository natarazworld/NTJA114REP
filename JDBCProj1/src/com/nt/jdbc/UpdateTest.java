package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		
		Scanner sc=null;
		Statement st=null;
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
			//convert input values as required for the sql Query
			newAddrs="'"+newAddrs+"'";  //gives 'new delhi'
			
			//Load jdbc driver class  (optional)
			 //Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			//establisht the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
			 st=con.createStatement();
			//prepare SQL query
			   //update student set sadd='vizag' ,avg=84.55 where sno=9001;
			 String query="UPDATE STUDENT SET SADD="+newAddrs+" ,AVG="+newAvg+" WHERE SNO="+no;
			 System.out.println(query);
			//send and execute SQL query to Db s/w
			 int count=0;
			 if(st!=null)
				 count=st.executeUpdate(query);
			 
			 
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
