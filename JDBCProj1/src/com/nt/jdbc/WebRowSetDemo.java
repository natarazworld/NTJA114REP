//WebRowSetDemo.java
package com.nt.jdbc;
import java.io.FileWriter;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleWebRowSet;
public class WebRowSetDemo {

	public static void main(String[] args) {
		
		try(OracleWebRowSet wrowset=new OracleWebRowSet()){
			//set inputs
			wrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			wrowset.setUsername("system"); wrowset.setPassword("manager");
			wrowset.setCommand("SELECT  SNO,SNAME,SADD,AVG FROM STUDENT");
			//execute Query
			wrowset.execute();
		   //write  db table records to  xml file   
			 FileWriter writer=new FileWriter("student.xml");
			 wrowset.writeXml(writer);
			 System.out.println("Db table records are written to xml file");
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
