

 <!-- b.jsp  -->
 <!-- Read and display the attribute vlaues -->
 <b> from b.jsp</b>
     attr1 (pageScope])  value :: <%=pageContext.findAttribute("attr1") %>
     attr2 (request)  value :: <%=pageContext.findAttribute("attr2") %>
      attr3 (sessionScope])  value :: <%=pageContext.findAttribute("attr3") %>
     attr3 (application scope)  value :: <%=pageContext.findAttribute("attr4") %>
     

<jsp:forward page="c.jsp" />