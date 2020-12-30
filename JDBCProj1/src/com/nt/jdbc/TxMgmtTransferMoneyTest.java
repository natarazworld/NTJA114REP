package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTransferMoneyTest {

	public static void main(String[] args) {
		
		int srcAcno=0, destAcno=0;
		float amount=0.0f;
		try(Scanner sc=new Scanner(System.in)) {
		     System.out.println("Enter Source account number::");
		      srcAcno=sc.nextInt();
		      System.out.println("Enter Destination account number::");
		      destAcno=sc.nextInt();
		      System.out.println("Enter Amount to transfer::");
		      amount=sc.nextFloat();
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager")){
			if(con!=null)
				try(Statement st=con.createStatement()){
					//begin Tx
					if(con!=null)
					   con.setAutoCommit(false);
					//add  withdraw,deposite queries to the batch
					if(st!=null) {
					  st.addBatch("UPDATE JDBC_ACCOUNT SET BALANCE=BALANCE-"+amount+" WHERE ACNO="+srcAcno);
					  st.addBatch("UPDATE JDBC_ACCOUNT SET BALANCE=BALANCE+"+amount+" WHERE ACNO="+destAcno);
					//execute the batch  (execution of logics)
					  int result[]=st.executeBatch();
					 //perform Tx Mgmt
					  boolean flag=false;
					  for(int i=0;i<result.length;++i) {
						  if(result[i]==0) {
							  flag=true;
							  break;
						  }//if
					  }//for
					  if(flag==true) {
						  con.rollback();  //rollbacking the Tx
						  System.out.println("Money not transffered:: (Tx rolled back)");
					  }
					  else {
						  con.commit(); //committing the Tx
						  System.out.println("Money  transffered:: (Tx committed)");
					  }//else
					  
					}//if
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
