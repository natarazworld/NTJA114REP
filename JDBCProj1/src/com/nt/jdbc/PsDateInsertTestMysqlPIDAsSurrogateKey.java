package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PsDateInsertTestMysqlPIDAsSurrogateKey {
  private static final String  PERSON_INSERT_QUERY="INSERT INTO PS_PERSON_INFO(PNAME,DOB,DOJ,DOM) VALUES(?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//read inputs
		 sc= new Scanner(System.in);
			String pname=null,sdob=null,sdom=null,sdoj=null;
			if(sc!=null) {
				System.out.println("enter  person name ::");
				pname=sc.next();
				System.out.println("enter  person DOB(dd-MM-yyyy) ::");
				sdob=sc.next();
				System.out.println("enter  person DOJ(MM-dd-yyyy) ::");
				sdoj=sc.next();
				System.out.println("enter  person DOM(yyyy-MM-dd) ::");
				sdom=sc.next();
			}
			//convert String date values to  java.util.Date class obejcts (dob,doj)
			//for DOB
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			  java.util.Date  udob=sdf.parse(sdob);
			  //for DOJ
		  SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
			  java.util.Date  udoj=sdf1.parse(sdoj);
			  //convert  java.util.Date class objects to java.sql.Date class objs
			  java.sql.Date sqdob=new java.sql.Date(udob.getTime());
			  java.sql.Date sqdoj=new java.sql.Date(udoj.getTime());
			  // convert  yyyy-MM-dd pattern DOM directly to java.sql.Date class object
			  java.sql.Date sqdom= java.sql.Date.valueOf(sdom);
			  
				//registr  JDBC driver s/w  (optional)
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//establish the connection
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
				
			   //create PreparedStatement object having pre-compiled SQL Query
			  if(con!=null) 
				  ps=con.prepareStatement(PERSON_INSERT_QUERY);  
			  //set values to  Query params
			  if(ps!=null) {
				  ps.setString(1,pname);
				  ps.setDate(2,sqdob);
				  ps.setDate(3,sqdoj);
				  ps.setDate(4,sqdom);
			  }
			  //execute the SQL query
			  int result=0;
			  if(ps!=null) 
				   result=ps.executeUpdate();
			  //process the results
			  if(result==1)
				  System.out.println("Record inserted");
			  else
				  System.out.println("record  not inserted");
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
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
