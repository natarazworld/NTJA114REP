package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SelectRSTestWithPropsFile {
  private static  final String GET_STUDENTS="SELECT * FROM STUDENT";
	public static void main(String[] args) {
		  //locate properties file
		String url=null, uname=null, pwd=null;
		try(InputStream is=new FileInputStream("src/com/nt/commons/jdbc.properties")){
			   //Store Properties info to  java.util.Properties collection
			Properties props=new Properties();
			props.load(is);
			url=props.getProperty("jdbc.url");
			uname=props.getProperty("jdbc.username");
			pwd=props.getProperty("jdbc.pwd");
		}
		catch(FileNotFoundException fne) {
			fne.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection(url, uname,pwd)) {
			if(con!=null)
				try(PreparedStatement ps=con.prepareStatement(GET_STUDENTS)){ 
					if(ps!=null)
						try(ResultSet rs=ps.executeQuery(GET_STUDENTS)){
							  if(rs!=null) {
						          System.out.println("Records (top- bottom)");
						          while(rs.next()) {
						        	  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          }//while
							  }
						}//try3
					
				}//try2
			
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//clas
