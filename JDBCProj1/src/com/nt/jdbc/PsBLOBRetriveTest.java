//PsBLOBRetrieve.java
package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class PsBLOBRetriveTest {
     private static final String  GET_ACTOR_DETAILS="SELECT ACTORID,ACTORNAME,TYPE,PHOTO FROM ACTOR_INFO WHERE  ACTORID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		InputStream is=null;
		OutputStream os=null;
		try {
			//read inputs
			sc=new  Scanner(System.in);
			int no=0;
			if(sc!=null) {
				System.out.println("Enter actor Id::");
				no=sc.nextInt();
			}
			
			//establish the connection
			  //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1", "root","root");
			  //create PreparedStatement object having  pre-compiled SQL query
			  if(con!=null)
				  ps=con.prepareStatement(GET_ACTOR_DETAILS);
			  //set values to query params
			  if(ps!=null)
				  ps.setInt(1, no);
			  //execute the SQL query
			   if(ps!=null) 
				    rs=ps.executeQuery();
			   //process the ResultSet obj
			    if(rs!=null) {
			    	if(rs.next()) {
			    		System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
			    		//get InputSteam object pointing BLOB colum  value
			    		is=rs.getBinaryStream(4);
			    		//create OutputStream pointing to the empty destionation file
			    		os=new FileOutputStream("photo.jpg");
			    		// copy  is reffered  BLOB value to  os refered  Destination file
			    		IOUtils.copy(is, os);
			    		System.out.println("Photo is retrieved successfully");
			    	}//if
			    	else 
			    		System.out.println("Actor is not found");
			    }//if
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
			//close stream objs
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
			try {
				if(os!=null)
					os.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}//finally


	}

}
