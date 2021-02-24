package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read sepcial req param(s1) value
		String s1Val=req.getParameter("s1");
		//read form data only when submit buttons are clicked
		float val1=0.0f;
		float val2=0.0f;
		if(!s1Val.equalsIgnoreCase("link1") && !s1Val.equalsIgnoreCase("link2")) {
			 val1=Float.parseFloat(req.getParameter("t1"));
			 val2=Float.parseFloat(req.getParameter("t2"));
		}
		if(s1Val.equalsIgnoreCase("add")) {
			float result=val1+val2;
			pw.println("<h1 style='color:red;text-align:center'> Addition ::"+result+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("sub")) {
			float result=val1-val2;
			pw.println("<h1 style='color:red;text-align:center'> subtraction ::"+result+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("mul")) {
			float result=val1*val2;
			pw.println("<h1 style='color:red;text-align:center'> subtraction ::"+result+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("div")) {
			float result=val1/val2;
			pw.println("<h1 style='color:red;text-align:center'> subtraction ::"+result+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:red;text-align:center'> System date and time"+new Date() +"</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'> System Properties"+System.getProperties() +"</h1>");
		}
		//add hyperlink
		pw.println("<br><br> <a href='form.html'>home </a>");
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        doGet(req,res);
	}//doPost(-,-)

}//class
