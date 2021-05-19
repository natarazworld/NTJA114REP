
<%!  
          public    String generate(String user){
            
  	            int abc=100;

	            //get System  date and  time
	               java.time.LocalDateTime ldt=java.time.LocalDateTime.now();
	            // get current hour of the day
	            int hour=ldt.getHour();
	            //generate message
	             if(hour<12)
	            	  return "Good Morning ::"+user;
	            else if(hour<16)
	            	return "Good AfterNoon ::"+user;
	            else if(hour<20)
	            	return "Good Evening ::"+user;
	            else 
	            	return "Good  Night ::"+user; 
         }
  %>
  
<!--   <h1 style="color:red;text-align:center">   Welcome   To  JSP  -- Eclipse IDE</h1> -->
     
     <%-- <b> Date and  time ::</b>--%>  <!--   <%=new java.util.Date() %> -->   
     <br.
     <%
            String  name=request.getParameter("uname");
     %>
     
     <br>
        <b> Wish  Message is ::           <%=generate(name) %>      </b>
  
  <b>hello </b>  <br>
  
     application object class name =<%=application.getClass() %> <br>
     out object class name =<%=out.getClass() %>
  
  


  
           