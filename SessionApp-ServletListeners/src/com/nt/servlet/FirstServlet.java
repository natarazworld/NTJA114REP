package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
       

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1  data
		String pname=req.getParameter("pname");
		String pfname=req.getParameter("pfname");
		String paddrs=req.getParameter("paddrs");
		String ms=req.getParameter("ms");
		if(ms==null)
			ms="single";
		  //create/Locate HttpSession object
		   HttpSession ses=req.getSession(true);
		   //keep form1/req1 data in HttpSession obj as session attributes
		   ses.setAttribute("pname",pname);
		   ses.setAttribute("pfname",pfname);
		   ses.setAttribute("paddrs",paddrs);
		   ses.setAttribute("ms",ms);
		   
		//  ses.setMaxInactiveInterval(60);
		
		
		//Generate form2 dynamically based on the marital status
		if(ms.equalsIgnoreCase("married")) {
		      pw.println("<h1 style='color:red;text-align:center'>Submit Married life Details</h1>");
		      pw.println("<form action='"+res.encodeURL("secondurl")+"' method='Post'>");
		       pw.println("<table  bgcolor='pink' align='center'> ");
		       pw.println("<tr><td> spouse name::</td><td> <input type='text' name='f2t1'>  </td> </tr>");
		       pw.println("<tr><td>No.of kids:: </td><td> <input type='text' name='f2t2'>  </td> </tr>");
		       pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
		       pw.println("</table>");
		      pw.println("</from>");
		}
		else {
			  pw.println("<h1 style='color:red;text-align:center'>submit  Bachelor life Details</h1>");
		      pw.println("<form action='secondurl' method='Post'>");
		       pw.println("<table  bgcolor='grey' align='center'> ");
		       pw.println("<tr><td> When do want to marry?::</td><td> <input type='text' name='f2t1'>  </td> </tr>");
		       pw.println("<tr><td>Why do want to marry? </td><td> <input type='text' name='f2t2'>  </td> </tr>");
		       pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
		       pw.println("</table>");
		      pw.println("</from>");
		}
		pw.println("<br> <b>session id ::"+ses.getId()+"</b>");
		//close stream
		pw.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
