package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlSelectTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
	 try {
		  //register jdbc driver s/w (optional)
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 //establish the connection
			/*
			 * con=DriverManager.getConnection("jdbc:mysql:///ntaj114db", "root", "root");
			 *
			 */
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj114db", "root", "root");
		 //create JDBC Statement object
		 if(con!=null)
			 st=con.createStatement();
		 //send and execute SQL query in Db s/w
		  if(st!=null) 
			  rs=st.executeQuery("SELECT SNO,SNAME,SADD,AVG FROM STUDENT");
		    //process the RS object
		  boolean flag=false;
		  if(rs!=null) {
			  while(rs.next()) {
				  flag=true;
				  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			  }//while
		  }//if
		  if(flag==false)
			  System.out.println("Table is empty");
		  else
			  System.out.println("Records are retrieved and displayed");
	 }//try
	 catch(SQLException se) {
		 se.printStackTrace();
	 }
	 catch(ClassNotFoundException  cnf) {
		 cnf.printStackTrace();
	 }
	 catch(Exception  e) {
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
				 rs.close();
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
