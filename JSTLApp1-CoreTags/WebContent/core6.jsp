<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   
   <c:set var="msg"  value="hello, how ar, e u"/>
   
   <b>content after splittings</b>
   <c:forTokens var="token"  items="${msg}"  delims="ab">
        ${token},
      </c:forTokens>
    
    