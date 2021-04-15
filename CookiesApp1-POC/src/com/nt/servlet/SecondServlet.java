package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWrtier 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read Cookies
		Cookie cookies[]=req.getCookies();
		if(cookies!=null) {
			  for(Cookie ck:cookies) {
				  pw.println("<h1>"+ck.getName()+"..... "+ck.getValue()+" </h1>");
			  }//for
		}//if
		pw.println("<h1> Cookies are read and displayed on the browser s/w </h1>");
		//close stream
		pw.close();

	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
