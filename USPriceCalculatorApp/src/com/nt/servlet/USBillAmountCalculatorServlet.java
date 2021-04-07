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

@WebServlet("/uscalcurl")
public class USBillAmountCalculatorServlet extends HttpServlet {
	
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
		float tax1=billAmt*0.18f;
		float tax2=billAmt*0.1f;
		float finalAmt=billAmt+tax1+tax2;
		//display detaiils
		pw.println("<h1 style='color:blue;text-align:center'>USA  </h1> ");
		pw.println("<p style='text-align:center'>  <b>Bill amount::"+ billAmt+"</b><br>");
		pw.println("<b>Tax1(GST)::"+tax1+"</b><br>");
		pw.println("<b>Tax2(CovidTax)::"+tax2+"</b><br>");
		pw.println("<b>Final amount::"+finalAmt+"</b><br>");
		//do not close stream
		//pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);
	}

}
