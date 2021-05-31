<%@ page isELIgnored="false"  %>

<%
    //read form data
    String name=request.getParameter("iname");
   float qty=Float.parseFloat(request.getParameter("iqty"));
   float price=Float.parseFloat(request.getParameter("iprice"));
   //calculate bill Amount
   float billAmt=qty * price;
      
    if(billAmt>=50000){
%>
     <jsp:forward page="discount.jsp">
          <jsp:param value="<%=billAmt%>" name="bAmt"/>
     </jsp:forward>
    <%} //if
    else{  %>
    	<h1 style="color:blue;text-align:center"> Bill Details are  </h1>
    	 <h2 style="text-align:center">Item name:: <%=name%>   </h2>
    	 <h2 style="text-align:center">Item price:: <%=price%>   </h2>
    	 <h2 style="text-align:center">Item qty:: <%=qty%>   </h2>
    	  <h2 style="text-align:center">Bill Amount:: <%=billAmt%>   </h2>   
    <%}//else
    	 %>
    	 
    	 <br><br>
    	  <a href="input.html">home</a>
    	
    
    