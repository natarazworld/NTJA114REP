package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //get PrintWriter
		   PrintWriter pw=res.getWriter();
		   //set response content type
		   res.setContentType("text/html");
		   //read addtional req param value
		   String pval=req.getParameter("s1");
		   //get All available Locales of this world
		   Locale locales[]=Locale.getAvailableLocales();
		   //differentiate logics for hyperlinks in servlet comp
		     if(pval.equalsIgnoreCase("link1")) {
		    	 pw.println("<h2 style='color:red;text-align:center'>All Languages are </h2>");
		    	 for(Locale l:locales) {
		    		   pw.println("<b>"+l.getDisplayLanguage()+",</b>");
		    	 }
		     }//if
		     else if(pval.equalsIgnoreCase("link2")) {
		    	 pw.println("<h2 style='color:red;text-align:center'>All Countries are </h2>");
		    	 for(Locale l:locales) {
		    		   pw.println("<b>"+l.getDisplayCountry()+",</b>");
		    	 }
		     }//else
		     else {
		    	 pw.println("<h2 style='color:red;text-align:center'>system properties are </h2>");
		    	 pw.println("<br>"+System.getProperties());
		     }
		     
		     //add hyperlink
		     pw.println("<br><a href='links.html'><img src='images/home.jfif'> </a>");
		     
		     //close PrintWriter
		     pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)

}//class
