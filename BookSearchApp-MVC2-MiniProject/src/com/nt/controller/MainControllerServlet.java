package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDetailsDTO;
import com.nt.service.BookStoreMgmtServiceImpl;
import com.nt.service.IBookStoreMgmtService;

/**
 * Servlet implementation class MainControllerServlet
 */
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	
	private IBookStoreMgmtService  service;
	
	@Override
		public void init() throws ServletException {
		   service=new BookStoreMgmtServiceImpl();
		}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read form data
		String  category=req.getParameter("category");
		String  source =req.getParameter("source");
		try {
		//use service
		  List<BookDetailsDTO> listDTO=service.fetchBooksByCategory(category);
		  //keep results in reques scope
		  req.setAttribute("booksInfo", listDTO);
		  //forward result jsp page based button that is used to submit the request
		   String resultPage=null;
		   if(source.equalsIgnoreCase("excel"))
			   resultPage="/excel_screen.jsp";
		   else 
			   resultPage="/html_print.jsp";
		   RequestDispatcher rd=req.getRequestDispatcher(resultPage);
		  rd.forward(req, res);
		}
		catch(Exception e) {
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
