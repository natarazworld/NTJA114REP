package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
       

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1  data from hidden boxes(Session tracking)
		String pname=req.getParameter("hname");
		String pfname=req.getParameter("hfname");
		String paddrs=req.getParameter("haddrs");
		String ms=req.getParameter("hms");
		//read form2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		//generate dynamic web page displaying both form1/req1 and form2/req2 data
		//Display form1/req1 data 
		pw.println("<br><h1 style='color:red;text-align:center'>  Form1 / req1 data  "+pname+" ...."+pfname+"...."+paddrs+"....."+ms+"</h1>");
		pw.println("<br><h1 style='color:red;text-align:center'>  Form2 / req2 data  "+f2val1+" ...."+f2val2+"</h1>");
		
		//add hyperlink
		pw.println("<a href='form.html'>home </a>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
