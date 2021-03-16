package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	 private ServletConfig  cg;
	 
	 public TestServlet() {
		 System.out.println("TestServlet:: 0-param cosntructor");
		  System.out.println("Driver init param value ::"+cg.getInitParameter("driver"));
	      System.out.println("dbuser init param value ::"+cg.getInitParameter("dbuser"));
	}
	 
	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("TestServlet.init()");
	      System.out.println("Driver init param value ::"+cg.getInitParameter("driver"));
	      System.out.println("dbuser init param value ::"+cg.getInitParameter("dbuser"));
	      this.cg=cg;
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get PrintWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		pw.println("<b>Driver init param value ::"+cg.getInitParameter("driver")+"</b>");
	      pw.println("<br><b>dbuser init param value ::"+cg.getInitParameter("dbuser")+"</b>");
	      //close stream
	      pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      doGet(req,res);
	}
	

}
