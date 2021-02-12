// VoterServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends  HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet.doPost(-,-)");
      //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data (ruquest param values from request object)
		String name=req.getParameter("pname");  //the form comp names acts as request param names
		float age=Float.parseFloat(req.getParameter("page"));
		String addrs=req.getParameter("paddrs");
		
		//write b.logic or request processsng logic
		if(age<18) 
			pw.println("<h1 style='color:red;text-align='center'>Mr/Miss/Mrs."+name+" u r not elgible to vote</h1>" );
			else
				pw.println("<h1 style='color:green;text-align='center'>Mr/Miss/Mrs."+name+" u r  elgible for voting</h1>" );
		
		//add graphical hyperlink
		  pw.println("<a href='form.html'><img src='images/home.jfif'/> </a>");
		
		  //close stream
		  pw.close();
			
		}//doGet(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 System.out.println("VoterServlet.doGet(-,-)");
		//get PrintWriter 
			PrintWriter pw=res.getWriter();
			//set response content type
			res.setContentType("text/html");
			
			//write request processing logic
			   Date d=new Date();
			   pw.println("<h1 style='color:red;text-align:center'>System date and  time ::"+d +"</h1>");
			
				//add graphical hyperlink
				  pw.println("<a href='form.html'><img src='images/home.jfif'/> </a>");
			   //close stream
				  pw.close();

	}

	}//class
