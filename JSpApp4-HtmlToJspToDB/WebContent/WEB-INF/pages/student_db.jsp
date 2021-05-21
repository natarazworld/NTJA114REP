
<%@page  import="java.sql.*,java.util.*"%>  <!-- Page Directive tag to perform java packages import -->

<%!
   Connection con;
   PreparedStatement ps1,ps2;
   public void jspInit(){
	   try{
		   //get access to ServletConfig obj
		   ServletConfig cg=getServletConfig();
		   //read jsp init parameter values
		   String driver=cg.getInitParameter("driverClass");
		   String url=cg.getInitParameter("url");
		   String dbuser=cg.getInitParameter("dbuser");
		   String dbpwd=cg.getInitParameter("dbpwd");
		   //load  JDBC dirver class
		   Class.forName(driver);
		   //esblish the connection
		   Connection con=DriverManager.getConnection(url,dbuser,dbpwd);
          //create PreparedStatement objs  taking SQL queries as the pre-compiled SQL queries
           ps1=con.prepareStatement("SELECT SNO,SNAME,SADD,COURSE FROM JSP_STUDENT");
          ps2=con.prepareStatement("INSERT INTO JSP_STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)");
	   }//try
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
  }//jspInit()
%>

<%
  //read addtional req param value 
  String pval=request.getParameter("s1");
   if(pval.equalsIgnoreCase("register")){    //for submit buton
	    // read form data
	    String name=request.getParameter("stname");
	    String addrs=request.getParameter("staddrs");
	    String course=request.getParameter("stcourse");
	    //set values to pre-compiled SQL query parameters
	    ps2.setString(1,name);
	    ps2.setString(2,addrs);
	    ps2.setString(3,course);
	    //execute Query
	    int count=ps2.executeUpdate();
	   //process results
	    if(count==0){  %>
	    	   <h2 style='color:red;text-align:center'> Student Registration failed</h2>
	    <%	 }
	    else{  %>
	    	<h2 style='color:red;text-align:center'> Student Registration succeded</h2>
	  <%  } 
   }//if
   else{
	   //execute the pre-compiled SQL SELECT query
	   ResultSet rs=ps1.executeQuery();
	   //create ResultSetMetaData object
	   ResultSetMetaData rsmd=rs.getMetaData();
	   //get cols count and col names
	   int colCount=rsmd.getColumnCount();  %>
	    <table align="center" bgcolor="cyan" border="1">
	      <tr>
	        <%
	            for(int i=1;i<=colCount;++i){  %>
	               <td><%=rsmd.getColumnLabel(i) %>  </td>
	           <%  } //for  %>
	      </tr>
	      
	      <%
	           //print col values  by Processing ResultSet
	           while(rs.next()){ %>
	        	   <tr>
	        	      <%  for(int i=1;i<=colCount;++i){  %>
	        	    	     <td> <%=rs.getString(i)%> </td>
	        	    <%  }//for %>
	        	   </tr>
	           <%}//while 
	               rs.close();
	           %>
	    </table>
<%	    
   }//else
%>
  <br>  <a href="student_details.html">home</a>


<%! public void jspDestroy(){
       //close jdbc  objs
         try{
        	 if(ps1!=null)
        		 ps1.close();
         }
       catch(SQLException se){
    	   se.printStackTrace();
       }
         try{
        	 if(ps2!=null)
        		 ps2.close();
         }
       catch(SQLException se){
    	   se.printStackTrace();
       }
         
         try{
        	 if(con!=null)
        		 con.close();
         }
       catch(SQLException se){
    	   se.printStackTrace();
       }
	
  }//jspDestroy()
  %>