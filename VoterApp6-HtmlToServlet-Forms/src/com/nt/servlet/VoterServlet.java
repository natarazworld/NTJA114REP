// VoterServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		String name=req.getParameter("pname").trim();  //the form comp names acts as request param names
		String tage=req.getParameter("page").trim();
		String addrs=req.getParameter("paddrs").trim();
		String vstauts=req.getParameter("vflag").trim();  //gives  yes / no
		
		
		//enable form validation logic (server side) only vstatus is "no"  (only wheh client side form validations are not done)
		int age=0;
 if(vstauts.equalsIgnoreCase("no")) {
		System.out.println("form validation logic (server side)");
		List<String> errorsList=new ArrayList();
		 //-------  on person name ----------------
		if(name==null || name.length()==0 || name.equals(""))  //required rule
			errorsList.add("Person name is required");
		else if(name.length()<10)
			errorsList.add("Person name must have minimum of 10 chars");  //min lenght rule
		//-------  on person age ----------------
	
		  try {
			  age=Integer.parseInt(tage);
			   if(age<1 || age>125)
				   errorsList.add("Person age must there 1 through 125");  //range rule
		  }
		  catch(NumberFormatException nfe) {
			  errorsList.add("Person age must be numeric value");  // numeric value rule
		  }
		//----------------- on person addrs -------
		  if(addrs==null || addrs.equals("") || addrs.length()==0)
			    errorsList.add("Person address is required");
		
		//Display form validation errors
		  if(errorsList.size()!=0) {
			  pw.println("<ul style='color:red'>");
			    for(String errMsg:errorsList)
			    	pw.println("<li>"+errMsg+"</li>");
			    pw.println("</ul>");
			    
			    return;  //returns the controller to caller .. so that b.logic will not executed..
		  }
	}//if
 else{
	 age=Integer.parseInt(tage);
 }
		
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

	}//doGet(-,-)

	}//class
