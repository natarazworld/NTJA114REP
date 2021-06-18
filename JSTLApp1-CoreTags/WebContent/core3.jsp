<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
   <c:when test="${param.p >0 }">
       ${param.p } is positive number
   </c:when>
   <c:when test="${param.p <0 }">
       ${param.p } is negetive number
   </c:when>
   <c:otherwise>
         ${param.p } is ZERO
   </c:otherwise>
   
</c:choose>  
  
  