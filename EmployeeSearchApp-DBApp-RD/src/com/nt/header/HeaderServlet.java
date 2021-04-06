package com.nt.header;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	         //get Printer writer
		    PrintWriter pw=res.getWriter();
		    //set response content type
		    res.setContentType("text/html");
		    //add header content
		    pw.println("<marquee><img src='images/nit.jpg' width='400' height='200'> </marquee>");
		    //do not close stream
		    //pw.close();
		    
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
