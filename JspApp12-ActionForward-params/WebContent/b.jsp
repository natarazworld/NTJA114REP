

<b>from b.jsp</b> <br>
<%=new java.util.Date() %> <br>
<b> additonal req param values</b>
    name  req param value ::  <%=request.getParameter("name") %> <br>
    age  req param value ::  <%=Integer.parseInt(request.getParameter("age"))  %> <br>
    amount for xerox ::  <%=Float.parseFloat(request.getParameter("amt")) %> <br>
    

