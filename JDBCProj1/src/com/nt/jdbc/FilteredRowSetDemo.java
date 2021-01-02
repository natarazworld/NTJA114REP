//FilteredRowSetDemo.java
package com.nt.jdbc;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;
class Filter1 implements Predicate{
	   private String condData;
	public Filter1(String condData) {
		this.condData=condData;
	}

	@Override
	public boolean evaluate(RowSet rs){
		System.out.println("Filter1.evaluate()");
		try {
		String colData=rs.getString("ENAME");  //get ENAMLE col value
		 if(colData.startsWith(condData))
			 return true;
		else 
			 return false;
		}//try
		catch(Exception e) {
		   return false;	
		}
		
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}

public class FilteredRowSetDemo {
	public static void main(String[] args) {
		//Filtered Rowset1
		try (OracleFilteredRowSet	frs=new OracleFilteredRowSet()){
			frs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			frs.setUsername("system");
			frs.setPassword("manager");
			frs.setCommand("SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP");
			frs.setFilter(new Filter1("A"));
			frs.execute();
			//process Rowset
			while(frs.next()) {
				System.out.println(frs.getInt(1)+" "+frs.getString(2)+" "+frs.getString(3)+" "+frs.getInt(4));
			}
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
