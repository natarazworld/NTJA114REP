package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
      try {
    	  sc=new Scanner(System.in);
    	  int no=0;
    	  String name=null,addrs=null;
    	  float avg=0.0f;
    	  if(sc!=null) {
    		  System.out.println("enter studnet number::");
    		  no=sc.nextInt(); // gives 101
    		  System.out.println("Enter student name::");
    		   name=sc.next(); //gives raja
    		  System.out.println("Enter student address::");
    		   addrs=sc.next(); //gives hyd
    		  System.out.println("Enter student avg::");
    		   avg=sc.nextFloat(); //gives 90.66
    	  }//if
    	   //convert input values  as required for the SQL query
    	  name="'"+name+"'"; //gives 'raja'
    	  addrs="'"+addrs+"'"; //gives 'hyd'
    	  //Load jdbc driver class (optional)
    	  //Establish the connection
    	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
    	    //CreateStatement object
    	    if(con!=null)
    	    	st=con.createStatement();
    	    //prepare SQL query
    	                 //insert into student values(102,'ramesh','vizag',49.66);
    	       String query="INSERT INTO STUDENT VALUES("+no+","+name+","+addrs+","+avg+")";
    	       System.out.println(query);
    	       
    	       //send and execute SQL query in Db s/w
    	       int count=0;
    	       if(st!=null)
    	    	   count=st.executeUpdate(query);
    	       
    	       //process the results
    	       if(count==0)
    	    	     System.out.println("record not inserted");
    	       else
    	    	   System.out.println("record inserted");
         }//try
         catch(SQLException se) {  //for known exception
        	   se.printStackTrace();
         }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
        finally {
        	//close jdbc objs
        	try {
        	if(st!=null)
        		st.close();
        	}
        	catch(SQLException se) {
        		se.printStackTrace();
        	}
        	
        	try {
            	if(con!=null)
            		con.close();
            	}
            	catch(SQLException se) {
            		se.printStackTrace();
            	}
        	
        	try {
            	if(sc!=null)
            		sc.close();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        	
        }//finally

	}//main
}//class
