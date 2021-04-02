package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/downloadurl")
public class FileDownloadServlet extends HttpServlet {
	private static final String  GET_PHOTOPAH_BY_JSID="SELECT JSPHOTOPATH FROM JOBSEEKER_DETAILS WHERE JSID=?";
	private static final String  GET_RESUMEPAH_BY_JSID="SELECT JSRESUMEPATH FROM JOBSEEKER_DETAILS WHERE JSID=?";
	@Resource(name="DsJndi")
	private DataSource ds;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	
	    //read addtional request param values  id , type
		 int id=Integer.parseInt(req.getParameter("id"));
		 String type=req.getParameter("type");
		 String QUERY=null;
		 if(type.equalsIgnoreCase("PHOTO"))
			  QUERY=GET_PHOTOPAH_BY_JSID;
		 else
			 QUERY=GET_RESUMEPAH_BY_JSID;
		 
		 //get the location of file to be download from DB s/w..
		 try(Connection con=ds.getConnection()){
			 try(PreparedStatement ps=con.prepareStatement(QUERY)){
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				String fileLocation=null;
				if(rs.next()) 
					fileLocation=rs.getString(1);
       //Perform File downloading activity
				 //ceate java.io.File class obj holding file name and location
				   File file=new File(fileLocation);
				   //get the length of the make response content length
				   res.setContentLengthLong(file.length());
				   //get MIME type of the file and Make it as response content type
				    ServletContext sc=getServletContext();
				   String mimeType=sc.getMimeType(fileLocation);
				   mimeType=mimeType!=null?mimeType:"application/octet-stream";
				   res.setContentType(mimeType);
				   //create InputStream pointing to the file to be downloaded
				   InputStream is=new FileInputStream(file);
					//get OutputStream pointing response obj
					ServletOutputStream sos=res.getOutputStream();
					//give instruction to browser to  make recived content as the donwloadable file
					res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
					//copy content from file to response obj using stream
					IOUtils.copy(is,sos);
					
					//close streams
					is.close();
					sos.close();
			 }//try2
		 }//try1
		 catch(SQLException se) {
			 se.printStackTrace();
		 }
		 
		
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
