//CacheRowSetDemo.java
package com.nt.jdbc;
import java.sql.SQLException;
import oracle.jdbc.rowset.OracleCachedRowSet;
public class CacheRowSetDemo {

	public static void main(String[] args) {
		
		try(OracleCachedRowSet crowset=new OracleCachedRowSet()){
			//set inputs
			crowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crowset.setUsername("system"); crowset.setPassword("manager");
			crowset.setCommand("SELECT  SNO,SNAME,SADD,AVG FROM STUDENT");
			//execute Query
			crowset.execute();
			//process the Resultset 
			while(crowset.next()) {
				System.out.println(crowset.getInt(1)+"  "+crowset.getString(2)+"  "+crowset.getString(3)+"  "+crowset.getFloat(4));
			}//while
			
			System.out.println("Stop DB s/w");
			Thread.sleep(50000); // Stop Db s/w duding this sleep time
			//modify Rowset object data When Db s/w is in  stopped  (offline)
			crowset.absolute(3);  //3rd record
			 crowset.updateFloat(4, 99.99f);  //modifies 4th col values
			 crowset.updateRow(); // asking to reflect in DB table
			
			 System.out.println("Start DB s/w");
			 Thread.sleep(50000); // Start  Db s/w duding this sleep time
			   crowset.acceptChanges();  //To sync RowSet changed to DB table and vice-versa
				while(crowset.next()) {
					System.out.println(crowset.getInt(1)+"  "+crowset.getString(2)+"  "+crowset.getString(3)+"  "+crowset.getFloat(4));
				}//while
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
