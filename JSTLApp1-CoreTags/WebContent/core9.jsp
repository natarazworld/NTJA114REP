<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:catch var="e">
   <jsp:scriptlet>
        int a=Integer.parseInt("1x0");
        out.println("value ::"+a);
   </jsp:scriptlet>
     
</c:catch>
<c:if test="${!empty e }">
   Exception  ${e}    
</c:if>
 
