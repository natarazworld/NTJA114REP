package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

@WebServlet("/jobseekerurl")
public class JobSeekerRegistrationServlet extends HttpServlet {
	private static  final String  INSERT_JOBSEEKER_DETAILS="INSERT INTO JOBSEEKER_DETAILS VALUES(JSID_SEQ.NEXTVAL,?,?,?,?)"; 
	
	@Resource(name="DsJndi")
	private DataSource ds;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrinterWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		try {
		//prepare special request around HttpSErvletRequest obj
		MultipartFormDataRequest nreq=new MultipartFormDataRequest(req);
		//For File Upoading
		UploadBean  upb=new UploadBean();
		upb.setFolderstore("E:/store");
		upb.setMaxfiles(10);
		upb.setFilesizelimit(50*1024*1024);
		upb.setOverwrite(false);
		upb.store(nreq);  //complete the file uploading
		pw.println("<h1 style='color:blue;text-align:center'>The fllowing Files are uploaded succefully </h1>");
        Hashtable<String,UploadFile> ht= nreq.getFiles();
        String resumeFileName=ht.get("jsResume").getFileName();
        String photoFileName=ht.get("jsPhoto").getFileName();
        pw.println("<h1 style='color:red;tex-align:center'>Uploaded files are ::"+resumeFileName+"....  "+photoFileName+"</h1>");
        //read the remaning form comp values
        String jsName=nreq.getParameter("jsName");
        String jsAddrs=nreq.getParameter("jsAddrs");
        //write these details to db table as record
                  //get pooled jdbc con 
           Connection con=ds.getConnection();
               //create PreparedStatement object
           PreparedStatement ps=con.prepareStatement(INSERT_JOBSEEKER_DETAILS);
           //set values to query params
              ps.setString(1,jsName);
              ps.setString(2, jsAddrs);
              ps.setString(4, "E:/store/"+resumeFileName);
              ps.setString(3, "E:/store/"+photoFileName);
              //execute the query
              int count=ps.executeUpdate();
            //process the results
              if(count==0)
            	    pw.println("<h1 style='text-align:center;color:red'> JobSeeker registration failed </h1>");
              else
            	  pw.println("<h1 style='text-align:center;color:red'> JobSeeker registration succeded </h1>");
		}//try
		catch (UploadException e) {
			pw.println("<b> Problem in file uploading either with file size or files count</b>");
			e.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<b> Problem in DB Operations</b>");
		}
		catch(Exception e) {
			pw.println("<b> Unknow Problem </b>");
			e.printStackTrace();
		}
		
		pw.println("<br><br>  <a href='register.html'>home</a>");
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
