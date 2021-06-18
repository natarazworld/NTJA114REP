<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- To create variables having scope -->
  <c:set var="msg"  value="hello"  scope="request"/>
  
  <c:if test="${param.uname ne null }" >
          ${msg}  Mr./Miss./Mrs. ${param.uname}
  </c:if>
  
  
  