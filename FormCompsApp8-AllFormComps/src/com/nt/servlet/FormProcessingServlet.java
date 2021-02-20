package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormProcessingServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWrtier
		PrintWriter pw=res.getWriter();
		//set resposne content type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String addrs=req.getParameter("addrs");
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		String qlfy=req.getParameter("qlfy");
		String favCities[]=req.getParameterValues("cities");
		String hbs[]=req.getParameterValues("hb");
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String color=req.getParameter("favColor");
		String birthWeek=req.getParameter("bWeek");
		String birthMonth=req.getParameter("bMonth");
		long mobileNo=Long.parseLong(req.getParameter("mbNo"));
		int salary=Integer.parseInt(req.getParameter("salary"));
		String fbUrl =req.getParameter("fbUrl");
		String mail=req.getParameter("email");
		
		//handle non-select state of list boxes and check boxes
		if(ms==null)
			  ms="single";
		if(hbs==null)
			  hbs=new String[] {"no hobies are selected"};
		if(favCities==null)
			favCities=new String[] {"no cities are selected"};
		
		//write b.logic or request procesing logic
		if(gender.equalsIgnoreCase("M")) {
			  if(age<5)
				  pw.println("<h1 style='color:green'>Master."+name+"  u  r   baby boy </h1>");
			   else if(age<13)
				  pw.println("<h1 style='color:green'>Master."+name+"  u  r  small boy </h1>");
				  else if(age<20)	  
					  pw.println("<h1 style='color:green'>Master."+name+"  u  r  teenage boy </h1>");
				  else if(age<35)
					  pw.println("<h1 style='color:green'>Mr."+name+"  u  r  young man </h1>");
				  else if(age<50)
					  pw.println("<h1 style='color:green'>Mr."+name+"  u  r  middle-aged man </h1>");
				  else 
					  pw.println("<h1 style='color:green'>Mr."+name+"  u  r  Budda </h1>");
		}
		else {
			if(age<5)
				  pw.println("<h1 style='color:green'>Master."+name+"  u  r   baby girl </h1>");
			   else if(age<13)
				  pw.println("<h1 style='color:green'>Master."+name+"  u  r  small Girl </h1>");
				  else if(age<20)	  {
					  if(ms.equalsIgnoreCase("married"))
					        pw.println("<h1 style='color:green'>Mrs."+name+"  u  r  Married teenage girl </h1>");
					  else
						  pw.println("<h1 style='color:green'>Miss."+name+"  u  r   teenage girl </h1>");
				  }
				  else if(age<35) {
					  if(ms.equalsIgnoreCase("married"))
					      pw.println("<h1 style='color:green'>Mrs."+name+"  u  r  young woman </h1>");
					  else
						  pw.println("<h1 style='color:green'>Miss."+name+"  u  r  young woman </h1>");
				  }
				  else if(age<50) {
					  if(ms.equalsIgnoreCase("married"))
					      pw.println("<h1 style='color:green'>Mrs."+name+"  u  r  middle-aged woman </h1>");
					  else
						  pw.println("<h1 style='color:green'>Miss."+name+"  u  r  middle-aged woman </h1>");
				  }
				  else { 
					  if(ms.equalsIgnoreCase("married"))
					       pw.println("<h1 style='color:green'>Mrs."+name+"  u  r old woman </h1>");
					  else
						  pw.println("<h1 style='color:green'>Miss."+name+"  u  r old woman </h1>");
				  }//else
		}//else
		
		pw.println("<h2 style='color:red;text-align:center'>Form data is  </h2>");
		pw.println("<br><b>name ::"+name+"</b>");
		pw.println("<br><b>age ::"+age+"</b>");
		pw.println("<br><b>addrs ::"+addrs+"</b>");
		pw.println("<br><b>Marital Status ::"+ms+"</b>");
		pw.println("<br><b>Gender ::"+gender+"</b>");
		pw.println("<br><b>Qualification ::"+qlfy+"</b>");
		pw.println("<br><b>Fav Cities ::"+Arrays.toString(favCities)+"</b>");
		pw.println("<br><b>Hobies ::"+Arrays.toString(hbs)+"</b>");
		pw.println("<br><b>DOB ::"+dob+"</b>");
		pw.println("<br><b>TOB ::"+tob+"</b>");
		pw.println("<br><b>BirthWeek ::"+birthWeek+"</b>");
		pw.println("<br><b>BirthMonth ::"+birthMonth+"</b>");
		pw.println("<br><b>Chosen Color ::"+color+"</b>");
		pw.println("<br><b>Email ::"+mail+"</b>");
		pw.println("<br><b>MobleNo ::"+mobileNo+"</b>");
		pw.println("<br><b>Salary ::"+salary+"</b>");
		pw.println("<br><b>FB Url ::"+fbUrl+"</b>");
		
		//add hyperlink
		pw.println("<br> <a href='form.html'>home </a>");
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
	

}//class
