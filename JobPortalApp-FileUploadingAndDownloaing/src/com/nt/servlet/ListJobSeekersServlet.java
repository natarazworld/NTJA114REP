package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/list_jsurl")
public class ListJobSeekersServlet extends HttpServlet {
	private static final String GET_ALL_JOBSEEKER="SELECT JSID,JSNAME,JSADDRS,JSPHOTOPATH,JSRESUMEPATH FROM JOBSEEKER_DETAILS";
	@Resource(name="DsJndi")
	private DataSource ds;

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response cotent type
		res.setContentType("text/html");
		//get Pooled JDBC connection
		try(Connection con=ds.getConnection()){
			     try(PreparedStatement ps=con.prepareStatement(GET_ALL_JOBSEEKER)){
			    	 try(ResultSet rs=ps.executeQuery()){
			    		 pw.println("<table border='1' align='center' bgcolor='cyan'>");
			    		 pw.println("<tr><th>JSID</th><th>JSNAME</th><th>JSADDRS</th><th>PHOTO</th><th>RESUME</th></tr>");
			    		 while(rs.next()) {
			    			 pw.println("<tr>");
			    			   pw.println("<td>"+rs.getInt(1)+"</td>");
			    			   pw.println("<td>"+rs.getString(2)+"</td>");
			    			   pw.println("<td>"+rs.getString(3)+"</td>");
			    			   pw.println("<td><a href='downloadurl?id="+rs.getInt(1)+"&type=photo'>download </a></td>");
			    			   pw.println("<td><a href='downloadurl?id="+rs.getInt(1)+"&type=resume'>download </a></td>");
			    			 pw.println("</tr>");
			    		 }//while
			    		 pw.println("</table>");
			    	 }//try2
			     }//try1
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//closre stream
		pw.close();
		
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

}
