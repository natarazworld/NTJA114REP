//ExcelServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExcelServlet extends   HttpServlet
{
	static {
		System.out.println("ExcelServlet.static block");
	}
	public ExcelServlet() {
		System.out.println("ExcelServlet:: 0-param constructor");
	}
	
	@Override
	public void init() throws ServletException {
	  System.out.println("ExcelServlet.init()");
	}
	
	protected  void  service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		System.out.println("ExcelServlet.service()");
           //get PrintWriter from response obj
		    PrintWriter pw=res.getWriter();
			//set response conten type
			res.setContentType("application/vnd.ms-excel");

			//write content to response object
			pw.println("<table align='center' row='5' cols='2'>");
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
