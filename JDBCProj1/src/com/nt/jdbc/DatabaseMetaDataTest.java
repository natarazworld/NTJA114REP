package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataTest {

	public static void main(String[] args) {
     
		 try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager")) {
			
			 DatabaseMetaData dbmd=null;
			 if(con!=null)
			       dbmd=con.getMetaData();
			 if(dbmd!=null) {
				   System.out.println("db s/w name ::"+dbmd.getDatabaseProductName());
				   System.out.println("db s/w version ::"+dbmd.getDatabaseProductVersion());
				   System.out.println("jdbc driver name ::"+dbmd.getDriverName());
				   System.out.println("jdbc driver version ::"+dbmd.getDriverVersion());
				   System.out.println("jdbc api version ::"+dbmd.getJDBCMajorVersion()+"."+dbmd.getJDBCMinorVersion());
				   System.out.println("Max DB  Connections::"+dbmd.getMaxConnections());
				   System.out.println("Max Row size::"+dbmd.getMaxRowSize());
				 System.out.println("Max Table name length :"+dbmd.getMaxTableNameLength());
				 System.out.println("Max Cols in Db table:"+dbmd.getMaxColumnsInTable());
				 System.out.println("Max Cols in SELECT Query:"+dbmd.getMaxColumnsInSelect());
				 System.out.println("Max Col name Length:"+dbmd.getMaxColumnNameLength());
				 System.out.println("All SQL keywords"+dbmd.getSQLKeywords());
				 System.out.println("All numberic  keywords"+dbmd.getNumericFunctions());
				 System.out.println("All system functions"+dbmd.getSystemFunctions());
				 System.out.println("supports stored procededures??"+dbmd.supportsStoredProcedures());
				 System.out.println("supports batch updation??"+dbmd.supportsBatchUpdates());
			  }//if
			 }//try
		 catch(SQLException se) {
			 se.printStackTrace();
		 }

	}//main
}//class
