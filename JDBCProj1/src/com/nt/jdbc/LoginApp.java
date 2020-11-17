package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String user=null, pwd=null;
			if(sc!=null) {
				System.out.println("Enter username:::");
				user=sc.nextLine(); //gives  raja
				System.out.println("Enter password::");
				pwd=sc.nextLine(); //gives rani
			}
			//convert input values as required for the sQL query
			 user="'"+user+"'"; //gives  'raja'
			 pwd="'"+pwd+"'"; //gives 'rani'
			 //register  JDBC driver s/w  (optional)
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //etablush the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 //create JDBC Statement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL query
			         // SELECT COUNT(*) FROM USERSLIST WHERE  USERNAME='raja' AND PASSWORD='rani'
			 String query="SELECT COUNT(*) FROM USERSLIST WHERE  USERNAME="+user+" AND PASSWORD="+pwd;
			 System.out.println(query);
			 //send and execute SQL query in DB s/w
			 if(st!=null)
				 rs=st.executeQuery(query);
			 //process the ResultSet obj
			 int count=0;
			 if(rs!=null) 
			       rs.next();
			 count=rs.getInt(1);
			 if(count==0)
				        System.out.println("Invalid Credentials");
			 else
				 System.out.println("Valid Credentials");
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
