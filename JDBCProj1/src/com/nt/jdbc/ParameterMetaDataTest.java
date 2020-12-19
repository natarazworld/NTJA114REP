package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterMetaDataTest {
    private final  static  String  INSERT_QUERY="INSERT INTO PRODUCT  VALUES(?,?,?,?,?)";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj114db1","root", "root")){
			 if(con!=null)
			    try(PreparedStatement  ps=con.prepareStatement(INSERT_QUERY)){
			    	 ParameterMetaData pmd=null;
				    if(ps!=null)
				    	pmd=ps.getParameterMetaData();
				    if(pmd!=null) {
				    	int paramCount=pmd.getParameterCount();
				    	for(int i=1;i<=paramCount;++i) {
				    		System.out.println("parameter mode::"+pmd.getParameterMode(i));
				    		System.out.println("parameter type::"+pmd.getParameterTypeName(i));
				    		System.out.println(" is Nullable::"+pmd.isNullable(i));
				    		System.out.println(" is Signed::"+pmd.isSigned(i));
				    		System.out.println(" Precision::"+pmd.getPrecision(i));
				    		System.out.println(" Scale::"+pmd.getScale(i));
				    	}//for
				    	
				    }//if
			}//try2
		}//try1
		catch(SQLException se){
			se.printStackTrace();
     	}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}//main

}//class
