package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatableRSTest {
  private static  final String GET_STUDENTS="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")) {
			if(con!=null)
				//try(Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY)){
				//try(Statement st=con.createStatement(1005,1007)){
				try(PreparedStatement ps=con.prepareStatement(GET_STUDENTS, 
						                                                                                              ResultSet.TYPE_SCROLL_INSENSITIVE,
						                                                                                              ResultSet.CONCUR_READ_ONLY)){ 
					if(ps!=null)
						try(ResultSet rs=ps.executeQuery(GET_STUDENTS)){
							  if(rs!=null) {
						          System.out.println("Records (top- bottom)");
						          while(rs.next()) {
						        	  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
						          }//while
						        // To insert row
						          rs.moveToInsertRow();  //creates empty row
						          rs.updateInt(1, 8001);  //updates the col values
						          rs.updateString(2, "rajesh");
						          rs.updateString(3, "hyd");
						          rs.updateFloat(4, 98.55f);
						          rs.insertRow(); // insert the RS new record to DB table row
						          System.out.println("record inserted"); 
						          
						          //To update row
									   rs.absolute(5);
									  rs.updateFloat(4,90.66f);
									  rs.updateRow(); //record is updated
									  System.out.println("record updated");
						          
						          //To delete row
						          rs.absolute(3);
						          rs.deleteRow();
						          
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
