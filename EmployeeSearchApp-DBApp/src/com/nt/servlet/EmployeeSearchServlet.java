package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empurl")
public class EmployeeSearchServlet extends HttpServlet {
        private static final String  GET_EMP_DETAILS_BY_ENO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		 int no=Integer.parseInt(req.getParameter("eno"));
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		 }
		 catch(ClassNotFoundException cnf) {
			 cnf.printStackTrace();
		 }
		 try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager")){
			try(PreparedStatement ps=con.prepareStatement(GET_EMP_DETAILS_BY_ENO)){
				   ps.setInt(1,no);
			  try(ResultSet rs=ps.executeQuery()){
				     //process the ResultSet object
				    if(rs.next()) {
				    	pw.println("<h1 style='color:blue;text-align:center'> "+no+ " Employee Details are </h1>");
				    	 pw.println("<div style='color:cyan;text-align:center'><br> <b> Emp No::"+rs.getInt(1)+"</b><br>");
				    	 pw.println("<br> <b> Emp name::"+rs.getString(2)+"</b><br>");
				    	 pw.println("<br> <b> Emp Desg::"+rs.getString(3)+"</b><br>");
				    	 pw.println("<br> <b> Emp Salary::"+rs.getFloat(4)+"</b><br>");
				    	 pw.println("<br> <b> Emp DeptNo::"+rs.getInt(5)+"</b><br> </div>");
				    }
				    else {
				    	pw.println("<h1 style='color:red;text-align:center'>Record not found </h1>");
				    }
				    
				    pw.println("<br><h3 style='text-align:center'> <a href='input.html'>home </a> </h3>");
			  }//try3
			}//try2
		 }//try1
		 catch(SQLException se) {
			 se.printStackTrace();
		 }
		 
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
