package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWrtier 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// create InMemory Cookie
		Cookie ck1=new Cookie("TS","hyd");
		res.addCookie(ck1);
		// create Persistence Cookie
		Cookie ck2=new Cookie("TN","chennai");
		ck2.setMaxAge(120);
		res.addCookie(ck2);
		
		pw.println("<h1> Cookies are created and added to repsonse obbj successfully </h1>");
		//close stream
		pw.close();

	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
