//LCTestServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class LCTestServlet  extends HttpServlet
{
	static{
		System.out.println("LCtestServlet:: static block");
     }

	 public LCTestServlet(){
         System.out.println("LCtestServlet::0-param constructor");
		 }

	

	 public void init(ServletConfig cg)throws ServletException{
		// super.init(cg);
		  System.out.println("LCtestServlet:: init(-) method");
		  System.out.println("Logical name of servlet comp::"+cg.getServletName());
	 }
	 
	 public void init()throws ServletException{
		  System.out.println("LCTestServlet.init()");
		 }
		
	 
	 public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  System.out.println("LCtestServlet:: doPost(-,-) method");
	
              //get PrintWriter
			    PrintWriter pw=res.getWriter();
				//set response content type
				res.setContentType("text/html");
				//write messages/output to response object
				pw.println("<h1 style='color:red;text-align:center'> Date and Time :: "+new java.util.Date() +"</h1>");
				//close stream
				pw.close();
	 }//service(-,-)

	 public void destroy(){
           System.out.println("LCtestServlet:: destroy() method");
	 }//destroy()

}//class