package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//access ServletContext obj
		ServletContext sc=getServletContext();
		pw.println("<br> context path of web application::"+sc.getContextPath());
		pw.println("<br> MIME type of input.html::"+sc.getMimeType("input.html"));
		pw.println("<br> Underlying server info::"+sc.getServerInfo());
		pw.println("<br> Servlet api version supported by server ::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br> Path of input.html:: "+sc.getRealPath("input.html"));
		pw.println("<br> Path of web applicatio  location:: "+sc.getRealPath("/"));

		
		//close stream 
		pw.close();
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}


}
