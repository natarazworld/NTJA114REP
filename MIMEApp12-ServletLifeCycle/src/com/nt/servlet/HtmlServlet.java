//HtmlServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HtmlServlet extends   HttpServlet
{
	static {
		System.out.println("HtmlServlet.static block");
	}
	public HtmlServlet() {
		System.out.println("HtmlServlet:: 0-param constructor");
	}
	
	@Override
	public void init() throws ServletException {
	  System.out.println("HtmlServlet.init()");
	}
	
	@Override
	public  void  service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		System.out.println("HtmlServlet.service(-,-)");
           //get PrintWriter from response obj
		    PrintWriter pw=res.getWriter();
			//set response conten type
			res.setContentType("text/html");

			//res.setHeader("refresh","10");
			res.setIntHeader("refresh",10);  // 10 Secs..

			//write content to response object
			pw.println("<br>  <h1> Date and time ::"+new java.util.Date()+"</h1>");
			pw.println("<table align='center'  bgcolor='cyan' border='1' row='5' cols='2'>");
			pw.println("<tr><th>Politician </th>   <th> Political Party </th> </tr>");
			pw.println("<tr><td> Modi </td>   <td> BJP </td> </tr>");
     		pw.println("<tr><td>  Rahul </td>   <td> INC </td> </tr>");
    		pw.println("<tr><td>  Mamata </td>   <td> TMC </td> </tr>");
     		pw.println("<tr><td>  KCR </td>   <td> TRS </td> </tr>");
			pw.println("</table>");
            //close stream
			 pw.close();
	}//service(-,-)
}//class
