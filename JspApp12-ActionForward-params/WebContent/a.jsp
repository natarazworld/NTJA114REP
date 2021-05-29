

<b> from a.jsp (start)</b> <br>
<%
    float xeroxPrice= 300 * 1.25f;
%>
<jsp:forward page="b.jsp">
   <jsp:param value="raja" name="name"/>
   <jsp:param value="30" name="age"/>
   <jsp:param value="<%=xeroxPrice%>" name="amt"/>
</jsp:forward>
 <br>
 <b> from a.jsp (end)</b>
 