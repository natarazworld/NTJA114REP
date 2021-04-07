package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/indiacalcurl")
public class IndiaBillAmountCalculatorServlet extends HttpServlet {
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// read form data
		String name=req.getParameter("iname");
		float price=Float.parseFloat(req.getParameter("iprice"));
		float qty=Float.parseFloat(req.getParameter("iqty"));
		//calculate bill Amount 
		float billAmt=price*qty;
		float tax=billAmt*0.12f;
		float finalAmt=billAmt+tax;
		//display detaiils
		pw.println("<h1 style='color:blue;text-align:center'>India  </h1> ");
		pw.println("<p style='text-align:center'>  <b>Bill amount::"+ billAmt+"</b><br>");
		pw.println("<b>Tax(GST)::"+tax+"</b><br>");
		pw.println("<b>Final amount::"+finalAmt+"</b><br>");
		try {
		//include the response of UsBillAmountCalculatorServlet comp of  USPriceCalculatorApp
		
		  //getServletContext obj of current web application
		  ServletContext sc=getServletContext();
		  //get ForeignContext of Destination web application(USPriceCalculatorApp)
		  ServletContext fc=sc.getContext("/USPriceCalculatorApp");
		  //create RequestDispatcher obj pointing to DestinationSErvlet comp (USBillAmountCalculatorServlet)
		  RequestDispatcher rd=fc.getRequestDispatcher("/uscalcurl");
		  //include the response
		  rd.include(req, res);
		  
		  //add home hyperlink
			pw.println("<br> <a href='input.html'>home </a>");
		  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);
	}

}
