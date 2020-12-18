package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataTest1 {
   private static final String  SELECT_STUDENT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")){
			if(con!=null)
				try(PreparedStatement ps=con.prepareStatement(SELECT_STUDENT_QUERY)){
				   if(ps!=null)
    					try(ResultSet rs=ps.executeQuery(SELECT_STUDENT_QUERY)){
    						
    						ResultSetMetaData rsmd=null;
					            if(rs!=null) {
					                rsmd=rs.getMetaData();	
					              if(rsmd!=null) {
					            	  //get column count
					            	  int colCount=rsmd.getColumnCount();
					            	  //display col names
					            	  for(int i=1;i<=colCount;++i) {
					            		  System.out.print(rsmd.getColumnLabel(i)+"      ");
					            	  }
					            	  System.out.println();
					            	  //display col  data types
					            	  for(int i=1;i<=colCount;++i) {
					            		  System.out.print(rsmd.getColumnTypeName(i)+"      ");
					            	  }
					            	  System.out.println();

					            	  //dispay col values
					            	  while(rs.next()) {
					            		 for(int i=1;i<=colCount;++i) {
					            			 System.out.print(rs.getString(i)+"         ");
					            		 }//for
					            		 System.out.println();
					            	  }//while
					            	  
					              }//if
					            }//if
    					}//try3
				}//try2
			
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
