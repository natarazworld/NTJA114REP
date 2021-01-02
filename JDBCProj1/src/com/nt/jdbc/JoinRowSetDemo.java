//JoinRowSetDemo.java
package com.nt.jdbc;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class JoinRowSetDemo {
	public static void main(String[] args) {
		
		//Cached Rowset1
		try(OracleCachedRowSet crs1=new OracleCachedRowSet()){
		     crs1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		     crs1.setUsername("system");
		      crs1.setPassword("manager");
		      crs1.setCommand("SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP");
		      crs1.setMatchColumn(4);
		       crs1.execute();
		   	//Cached Rowset2
		    try(OracleCachedRowSet	crs2=new OracleCachedRowSet()){
		           crs2.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		           crs2.setUsername("system");
		           crs2.setPassword("manager");
		            crs2.setCommand("SELECT DEPTNO,DNAME,LOC FROM DEPT");
             		crs2.setMatchColumn(1);
		            crs2.execute();
		//  create JoinRowSet having other cached rowsets
		        try(OracleJoinRowSet jrs=new OracleJoinRowSet()){
		              jrs.addRowSet(crs2);
		             jrs.addRowSet(crs1);
     		//process Rowset
	      	while(jrs.next()) {
			    System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getString(4)+"  "+jrs.getString(5)+"  "+jrs.getString(6));
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
}//class
