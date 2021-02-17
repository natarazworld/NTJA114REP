package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCapitalServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read  request param value
		int countryCode=Integer.parseInt(req.getParameter("country"));
		//prepare capitals[]
		String capitals[]=new String[] {"New Delhi","Beiging","washingtonDC","Islamabad"};
		//write result to response obj
		pw.println("<h1 style='color:green;text-align:center'>Capital is ::"+capitals[countryCode-1]  +"</h1>");
		//add home hyperlink
		pw.println("<a href='form.html'> home </a> ");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}//doPost(-,-)

}//class
