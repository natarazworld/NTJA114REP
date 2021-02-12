package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchSysPropsServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// Get All System properties
		Properties  props=System.getProperties();
		//write output to response obj
		pw.println(props);
		//add home  graphical hyperlink
		pw.println("<br><br><a href='http://localhost:2525/SysProsApp5-HtmlToServlet/page.html'><img src='images/home.jfif'></a>");
		
		// close stream
		pw.close();

	}//service(-,-)

}//class
