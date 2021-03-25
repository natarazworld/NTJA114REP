package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/poolurl")
public class CoronaPatientRegistrationServlet extends HttpServlet {
   private  static final String  CORONA_PATIENT_INSERT_QUERY="INSERT INTO CORONA_PATIENT VALUES(PATIENT_ID_SEQ.NEXTVAL,?,?,?)";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String  name=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		long mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		//write  JDBC  code for completing registration process
		Connection con=null;
		PreparedStatement ps=null;
		try {
			  //get Pooled jdbc con object
			    con=getPooledJDBCConnection();
			   //create PrepraedStaement object having INSERT SQL query
			    ps=con.prepareStatement(CORONA_PATIENT_INSERT_QUERY);
			   //set values to query params
			   ps.setString(1, name);
			   ps.setString(2,addrs);
			   ps.setLong(3,mobileNo);
			   //execute the query
			   int result=ps.executeUpdate();
			   //prpcess the reuslt
			   if(result==0)
				     pw.println("<h1 style='color:red;text-align:center'>Problem in Patient registration </h1>");
			   else
				   pw.println("<h1 style='color:green;text-align:center'>Patient registration completed successfully </h1>");
		}
		catch(NamingException ne) {
			ne.printStackTrace();
		     pw.println("<h1 style='color:red;text-align:center'>Problem in DataSource obj gathering </h1>");
		}
		catch(SQLException se) {
			se.printStackTrace();
		    pw.println("<h1 style='color:red;text-align:center'>Problem in DB Connectivity </h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
		    pw.println("<h1 style='color:red;text-align:center'>Unknown Problem  </h1>");
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		//add hyperlink
		pw.println("<br><br><h1 style='text-align:center'><a href='input.html'>home</a></h1>");
		
	}//doGet(-,-)
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}
	
	private  Connection  getPooledJDBCConnection() throws Exception{
		 //create InitialContext obj pointing to  Jndi registry 
		InitialContext ic=new InitialContext();
		//get DataSoruce object from Jndi Registry
		DataSource ds=(DataSource)ic.lookup("DsJndi");
		//get Pooled JDBC con object
		Connection con=ds.getConnection();
		return con;
	}

}
