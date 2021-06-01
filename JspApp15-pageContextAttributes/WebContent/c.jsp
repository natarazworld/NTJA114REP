

  <!-- c.jsp  -->
 <!-- Read and display the attribute vlaues -->
  <b> from c.jsp</b>
     attr1 (pageScope])  value :: <%=pageContext.findAttribute("attr1") %> <br>
     attr2 (request)  value :: <%=pageContext.findAttribute("attr2") %> <br>
       attr3 (sessionScope])  value :: <%=pageContext.findAttribute("attr3") %>  <br>
     attr4 (application scope)  value :: <%=pageContext.findAttribute("attr4") %> <br>
     

