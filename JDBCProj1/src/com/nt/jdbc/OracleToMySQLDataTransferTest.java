package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleToMySQLDataTransferTest {
        private static final String   ORACLE_GET_STUDENTS="SELECT * FROM STUDENT ";
        private static final String  MYSQL_INSERT_STUDENT="INSERT INTO STUDENT VALUES(?,?,?,?)";
        
	public static void main(String[] args) {
		Connection oraCon=null,mysqlCon=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
		//register   oracle ,mysql jdbc driver s/ws with DriverManager Service (optional)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connections
		oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
		mysqlCon=DriverManager.getConnection("jdbc:mysql:///ntaj114db","root","root");
		//create Simple Statement ,PrepareStatement objects
		if(oraCon!=null)
			st=oraCon.createStatement();
		
		if(mysqlCon!=null)
			ps=mysqlCon.prepareStatement(MYSQL_INSERT_STUDENT);
		
		//get records  from Student DB table of oracle DB s/w  in ResultSet object
		if(st!=null)
			rs=st.executeQuery(ORACLE_GET_STUDENTS);
		
		if(rs!=null && ps!=null) {
			int count=0;
			while(rs.next()) {
				//get Each record from RS object (oracle Student db table)
				int sno=rs.getInt(1);
				String name=rs.getString(2);
				String addrs=rs.getString(3);
				float   avg =rs.getFloat(4);
				//set each record values to  PS Pre-compiled INSERT query parameter (mysql Student db table)
				ps.setInt(1, sno);
				ps.setString(2, name);
				ps.setString(3, addrs);
				ps.setFloat(4,avg);
				//execute  pre-compiled INSERT SQL query
				ps.executeUpdate();
				count++;
			}
			System.out.println(count+" no.of records are transffered to mysql Db s/w from oracle DB s/w");
		}//if
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
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(oraCon!=null)
					oraCon.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(mysqlCon!=null)
					mysqlCon.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		
	}//main
}//class
