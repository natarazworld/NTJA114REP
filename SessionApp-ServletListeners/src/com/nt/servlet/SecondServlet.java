package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
       

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
				PrintWriter pw=res.getWriter();
				//set response content type
				res.setContentType("text/html");
				//read form2/req2 data
				String f2val1=req.getParameter("f2t1");
				String f2val2=req.getParameter("f2t2");
				// get acess to existing HttpSession object of the current browser s/w
				HttpSession ses=req.getSession(false);
				//read form1/req1 data from HttpSession obj as session attribute values  (session tracking)
				String name=(String)ses.getAttribute("pname");
				String fname=(String)ses.getAttribute("pfname");
				String addrs=(String)ses.getAttribute("paddrs");
				String  ms=(String)ses.getAttribute("ms");
				
				//generate dynamic web page displaying both form1/req1 and form2/req2 data
				//Display form1/req1 data 
				pw.println("<br><h1 style='color:red;text-align:center'>  Form1 / req1 data  "+name+" ...."+fname+"...."+addrs+"....."+ms+"</h1>");
				pw.println("<br><h1 style='color:red;text-align:center'>  Form2 / req2 data  "+f2val1+" ...."+f2val2+"</h1>");
				
				pw.println("<br> <b>session id ::"+ses.getId()+"</b>");
				
				//invalidate the session
				ses.invalidate();
				
				//add hyperlink
				pw.println("<a href='form.html'>home </a>");
				//close stream
				pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
