package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateRetrieve {
  private static final String  GET_PERSON_INFO="SELECT PID,PNAME,DOB,DOJ,DOM FROM  PS_PERSON_INFO WHERE PID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	     try {
	    	 //read inputs
	    	 sc=new Scanner(System.in);
	    	 int pid=0;
	    	 if(sc!=null) {
	    		 System.out.println("Enter  person id::");
	    		 pid=sc.nextInt();
	    	 }
	    	 
	    	    Class.forName("oracle.jdbc.driver.OracleDriver");
				//establish the connection
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
				 //create PreparedStaement obj having  SQL query as pre-compiledSQL query
				 if(con!=null)
					 ps=con.prepareStatement(GET_PERSON_INFO);
				 //set value to query param
				 if(ps!=null)
					 ps.setInt(1, pid);
				 //execute  the SQL query
				 if(ps!=null)
					 rs=ps.executeQuery();
				 //gather and process the results
				 if(rs!=null) {
					 if(rs.next()) { 
						  //retreve values from  RS 
						 int no=rs.getInt(1);
						 String name=rs.getString(2);
						 java.sql.Date sqdob=rs.getDate(3);
						 java.sql.Date sqdoj=rs.getDate(4);
						 java.sql.Date sqdom=rs.getDate(5);
						 //covert  java.util.Date class object to  String date values (dd-MM-yyyy)
						 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
						 String sdob=sdf.format(sqdob);
						 String sdoj=sdf.format(sqdoj);
						 String sdom=sdf.format(sqdom);
						 System.out.println(no+"   "+name+"    "+sdob+"   "+sdoj+"    "+sdom);
					 }
					 else 
						 System.out.println("record not found");
				 }//if
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
