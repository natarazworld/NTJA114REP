<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- To create variables having scope -->
  <c:set var="msg"  value="hello"  scope="request"/>
  
  <!-- To display data from scope -->
  value ::  <c:out value="${msg}" />  <br>
value ::  ${requestScope.msg}  <br>
value ::  ${msg}  <br>
<!-- To remove variables  from scopes -->
<c:remove  var="msg"   scope="request"/>

  <!-- To display data from scope -->
  value ::  <c:out value="${msg}" />  <br>
value ::  ${requestScope.msg}  <br>
value ::  ${msg}  <br>


  