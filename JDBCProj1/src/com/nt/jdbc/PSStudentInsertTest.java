package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSStudentInsertTest {
  private static final String  STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		  try {
			//read inputs
            sc=new Scanner(System.in);
            
            int count=0;
            if(sc!=null) {
            	System.out.println("Enter students  count ::");
            	count=sc.nextInt();
            }
            //register  JDBC driver s/w  (optional)
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //establish the connection
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
            //create PreparedStaement object by making the SQL query as pre-compiled SQL query
            if(con!=null)
            	ps=con.prepareStatement(STUDENT_INSERT_QUERY);
            //read multiple students details and set them as pre-compiled query param values
            if(ps!=null && sc!=null) {
            	for(int i=1;i<=count;++i) {
            		//gather each student details
            		System.out.println("Enter  "+i+" student details::");
            		System.out.println("Enter student number::");
            		int no=sc.nextInt();
            		System.out.println("Enter student name::");
            		String name=sc.next();
            		System.out.println("Enter student addrs::");
            		String addrs=sc.next();
            		System.out.println("Enter student avg::");
            		float avg=sc.nextFloat();
            		//set each student details  to query param values
            		ps.setInt(1,no);
            		ps.setString(2,name);
            		ps.setString(3, addrs);
            		ps.setFloat(4, avg);
            		//execute the Query
            		int result=ps.executeUpdate();
            		//process the result
            		if(result==1)
            			System.out.println(i+"student details are inserted");
            		else
            			System.out.println(i+"student details are not inserted");
            	}//for
            	
            }//if
			  
			  
		  }//try
		  catch(SQLException se) {
			  se.printStackTrace();
		  }
		  catch(ClassNotFoundException  cnf) {
			  cnf.printStackTrace();
		  }
		  catch(Exception e) {
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
