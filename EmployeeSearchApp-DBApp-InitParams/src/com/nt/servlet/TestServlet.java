package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
		//access Servletconfig object
		ServletConfig cg=getServletConfig();
		pw.println("db user init parameter value ::"+cg.getInitParameter("dbuser"));
		pw.println("<br>p1 init parameter value ::"+cg.getInitParameter("p1"));
		pw.println("<br> Logical name of servlet comp::"+cg.getServletName());
		pw.println("<br> ServletConfig obj class name::"+cg.getClass());
		
		//close stream 
		pw.close();
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}


}
