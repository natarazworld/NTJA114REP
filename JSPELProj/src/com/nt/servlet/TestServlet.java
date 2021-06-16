package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/testurl")
public class TestServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      //create  different scopes of data
		req.setAttribute("attr1", "val1"); //req scope
		
		HttpSession ses=req.getSession();
		ses.setAttribute("attr2", "val2");  //session scope
		 
		ServletContext sc=getServletContext();
		sc.setAttribute("attr3", "val3");
		
		//forward to   el_test1.jsp
		RequestDispatcher rd=req.getRequestDispatcher("/el_test.jsp");
		rd.forward(req, res);
		 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}

}
