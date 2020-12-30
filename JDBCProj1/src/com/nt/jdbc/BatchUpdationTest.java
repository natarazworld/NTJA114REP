//BatchUpdationTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdationTest {

	public static void main(String[] args) {
	//establis the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager")){
			 if(con!=null)
			     try(Statement st=con.createStatement()){
				
			   if(st!=null) {
				 //add  queries to the batch
				 st.addBatch("INSERT INTO  STUDENT VALUES(103,'raja','hyd',67.77)");
				 st.addBatch("UPDATE STUDENT SET SADD='newyork1' WHERE  SNO>=1000");
				 st.addBatch("DELETE FROM STUDENT WHERE SNO<=10");
				 //execute the batch
				 int result[]=st.executeBatch();
				 //process the result
				 int sum=0;
				  for(int i=0;i<result.length;++i)
					  sum=sum+result[i];
				  
				  System.out.println(" No.of records that are effected are ::"+sum);
			   }//if
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}

	}

}
