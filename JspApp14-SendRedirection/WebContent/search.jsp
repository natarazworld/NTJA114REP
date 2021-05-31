




<%
  //read form data
  String ss=request.getParameter("ss");
//perform sendRedirction with Google
System.out.println("before");
response.sendRedirect("https://www.google.com/search?q="+ss);
//response.sendRedirect("abc.jsp");
System.out.println("after");
%>
 <jsp:include page="abc.jsp"/>