//PsCLOBInsertMySQLTest.java
package com.nt.jdbc;

/*CREATE TABLE `ntaj114db1`.`jobseeker_info` (
		  `JSID` INT NOT NULL AUTO_INCREMENT,
		  `JSNAME` VARCHAR(15) NULL,
		  `QLFY` VARCHAR(15) NULL,
		  `resume` TINYTEXT NULL,
		  PRIMARY KEY (`JSID`),
		  UNIQUE INDEX `JSID_UNIQUE` (`JSID` ASC) VISIBLE);
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsCLOBInsertMySQLTest {
   private static final String  ACTOR_INSERT="INSERT INTO JOBSEEKER_INFO(JSNAME,QLFY,RESUME)  VALUES(?,?,?)";
	
	public static void main(String[] args) {
		Scanner sc=null;
		Connection  con=null;
		PreparedStatement ps=null;
		Reader reader=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String name=null,qlfy=null,resumeLocation=null;
			if(sc!=null) {
				System.out.println("enter job seeker name::");
				name=sc.next();
				System.out.println("enter  job seeker qualification::");
				qlfy=sc.next();
				System.out.println("Enter  Job Seeker resume Location::");
				resumeLocation=sc.next().replace("?","");
			}//if
			//create InputStream pointing  to  BLOB file 
			 reader=new FileReader(resumeLocation);
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1","root","root");
			//create PreparedSTatement object having pre-compiled SQL query
			if(con!=null)
				ps=con.prepareStatement(ACTOR_INSERT);
			
			//set values to query params
			 if(ps!=null) {
				 ps.setString(1,name);
				 ps.setString(2,qlfy);
				 ps.setCharacterStream(3,reader);
			 }//if
			 //execute the qyery
				int count=0;
			 if(ps!=null) 
			     count=ps.executeUpdate();	 
			
			//process the results
			  if(count==0)
				  System.out.println("Record not inserted");
			  else
				  System.out.println("record inserted");
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
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(reader!=null)
					reader.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}//finally

	}//main
}//class
