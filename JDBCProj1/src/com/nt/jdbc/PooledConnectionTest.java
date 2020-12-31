//PooledConnectionTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class PooledConnectionTest {

	public static void main(String[] args) {
		OracleConnectionPoolDataSource  ds=null;
		try {
			//create DataSource obj
		ds=new OracleConnectionPoolDataSource();
		ds.setDriverType("thin");  //optional
		ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("system"); ds.setPassword("manager");
		ds.setMaxStatements(10);  // by taking all these jdbc properities .. internally jdbc con pool is created
		}//try                                          // and that jdbc con pool is represented  by DataSource object
		catch(Exception e) {
			e.printStackTrace();
		}
		//get Pooled jdbc con object
		try(Connection con=ds.getConnection()){
			try(Statement st=con.createStatement()){
				try(ResultSet rs=st.executeQuery("SELECT * FROM STUDENT")){
					//process the results
					while(rs.next()) {
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
					}//while
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
}//class
