package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class PsDateTimeInsertTest {
   private static final String   INSERT_PERSON_INFO="INSERT INTO PERSON_INFO_DATE_TIME VALUES(PID_SEQ1.NEXTVAL,?,?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		PreparedStatement ps=null;
		Connection con=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
		
			String pname=null;
			String sdob=null,stob=null;
			String sdoj=null,stoj=null;
			if(sc!=null) {
				System.out.println(" Person name::");
				pname=sc.next();
				System.out.println("Enter  DOB::(yyyy-MM-dd)");
				sdob=sc.next();
				System.out.println("Enter  TOB::(hh:mm:ss)");
				stob=sc.next();
				System.out.println("Enter DOJ::(yyyy-MM-dd)");
				sdoj=sc.next();
				System.out.println("Enter  TOJ::(hh:mm:ss)");
				stoj=sc.next();
			}//if
			 //convert  date values java.sql.Date class objects and  time values to java.sql.TimeStamp objects
			//for DOB,DOJ
			java.sql.Date sqdob=java.sql.Date.valueOf(sdob);
			java.sql.Date sqdoj=java.sql.Date.valueOf(sdoj);
			//for TOB,TOJ
			java.sql.Time tob=java.sql.Time.valueOf(stob);
			java.sql.Timestamp tstob=new Timestamp(sqdob.getYear(),
					                                                                              sqdob.getMonth(),
					                                                                              sqdob.getDate(),
					                                                                              tob.getHours(),
					                                                                              tob.getMinutes(),
					                                                                              tob.getSeconds(),0);
			
			java.sql.Time toj=java.sql.Time.valueOf(stoj);
			java.sql.Timestamp tstoj=new Timestamp(sqdoj.getYear(),
					                                                                              sqdoj.getMonth(),
					                                                                              sqdoj.getDate(),
					                                                                              toj.getHours(),
					                                                                              toj.getMinutes(),
					                                                                              toj.getSeconds(),0);
			//create jdbc connection obj
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//create PreparedStatement object
			if(con!=null) 
				ps=con.prepareStatement(INSERT_PERSON_INFO);
			//set values to query params
			if(ps!=null) {
				ps.setString(1,pname);
				ps.setDate(2,sqdob);
				ps.setTimestamp(3,tstob);
				ps.setDate(4,sqdoj);
				ps.setTimestamp(5,tstoj);
			}//if
			
			//execute the SQL quert
			int  count=0;
			if(ps!=null)
				count=ps.executeUpdate();
			//process the Results
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted");
			}//try
		catch(SQLException se) {
			se.printStackTrace();
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
				catch(Exception ex) {
					ex.printStackTrace();
			   }
		}//finally
	}//main
}//class
