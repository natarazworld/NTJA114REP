<%@ page isELIgnored="false"  %>

<%
   //read  additional req param value given by billing.jsp page
   float billAmt=Float.parseFloat(request.getParameter("bAmt"));
// provide discount based on bill amounts
  float discount=0.0f;
    if(billAmt>=100000)
    	discount=billAmt* 0.3f; //30%
   	else if(billAmt>=80000)
   		discount=billAmt* 0.2f; //20%
   	else
		discount=billAmt* 0.1f; //10%
%>

<h1 style="color:blue;text-align:center"> Bill Details are  </h1>
    	 <h2 style="text-align:center">Item name:: <%=request.getParameter("iname")%>   </h2>
    	 <h2 style="text-align:center">Item price:: <%=request.getParameter("iprice")%>   </h2>
    	 <h2 style="text-align:center">Item qty:: <%=request.getParameter("iqty")%>   </h2>
    	  <h2 style="text-align:center">Bill Amount:: <%=billAmt%>  </h2>
    	  <h2 style="text-align:center">Discount Amount:: <%=discount%>  </h2>
    	  <h2 style="text-align:center">Final Bill Amount:: <%=(billAmt-discount)%> </h2>
<br>
  <a href="input.html">home</a>    	  

