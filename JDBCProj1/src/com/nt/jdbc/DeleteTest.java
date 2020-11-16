package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
 *   Application to delete record from student db table based on the given student number  
 */
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			System.out.println("Enter student number::");
			int no=sc.nextInt();  //gives 101
			//Load jdbc driver class to register  JDBC driver s/w (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			 //create Statement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL query
			        //delete  from  student where  sno=101
			  String query="DELETE  FROM STUDENT WHERE  SNO="+no;
			  System.out.println(query);
			  //send and execute SQL query in Db s/w
			  int count=0;
			  if(st!=null)
				     count=st.executeUpdate(query);
			  //proccess the results
			  if(count==0)
				   System.out.println("Record not found to delete");
			  else
			    System.out.println("no.of records that are delted::"+count);
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
			//close jdbc objs and stream objs
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
