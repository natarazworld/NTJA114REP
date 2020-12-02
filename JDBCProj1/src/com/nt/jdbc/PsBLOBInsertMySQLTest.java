package com.nt.jdbc;

/*CREATE TABLE `ntaj114db1`.`actor_info` (
		  `actorid` INT NOT NULL AUTO_INCREMENT,
		  `actorname` VARCHAR(25) NULL,
		  `type` VARCHAR(15) NULL,
		  `photo` LONGBLOB NULL,
		  PRIMARY KEY (`actorid`),
		  UNIQUE INDEX `actor_id_UNIQUE` (`actorid` ASC) VISIBLE);
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsBLOBInsertMySQLTest {
   private static final String  ACTOR_INSERT="INSERT INTO ACTOR_INFO(ACTORNAME,TYPE,PHOTO) VALUES(?,?,?)";
	
	public static void main(String[] args) {
		Scanner sc=null;
		Connection  con=null;
		PreparedStatement ps=null;
		InputStream is=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String name=null,type=null,photoLocation=null;
			if(sc!=null) {
				System.out.println("enter  actor name::");
				name=sc.next();
				System.out.println("enter  actor type::");
				type=sc.next();
				System.out.println("Enter  actor Photo Location::");
				photoLocation=sc.next().replace("?","");
			}//if
			//create InputStream pointing  to  BLOB file 
			 is=new FileInputStream(photoLocation);
			
			//register JDBC driver s/w
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1","root","root");
			//create PreparedSTatement object having pre-compiled SQL query
			if(con!=null)
				ps=con.prepareStatement(ACTOR_INSERT);
			//set values to query params
			 if(ps!=null) {
				 ps.setString(1,name);
				 ps.setString(2,type);
				 ps.setBinaryStream(3,is);
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
		catch(ClassNotFoundException cnf) {
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
			try {
				if(is!=null)
					is.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}//finally

	}//main
}//class
