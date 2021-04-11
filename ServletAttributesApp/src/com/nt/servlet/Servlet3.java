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
import javax.servlet.http.HttpSession;


@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content 
		res.setContentType("text/html");

		//read and  display reqeust attribute values
		 String attr1value=(String)req.getAttribute("attr1");
		 pw.println("<h1 style='color:red;text-align:center'>Servlet3:: attr1 value(request) ::"+attr1value+"</h1>");
		 
			//read and  display session attribute values
		 HttpSession ses=req.getSession();
		 pw.println("<h1 style='color:red;text-align:center'>Servlet3:: attr2 value(session) ::"+ses.getAttribute("attr2")+"</h1>");
				
		 //read and  display ServletContext attribute values
		 ServletContext sc=getServletContext();
		 pw.println("<h1 style='color:red;text-align:center'>Servlet3:: attr3 value(ServletContext) ::"+sc.getAttribute("attr3")+"</h1>");


	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
