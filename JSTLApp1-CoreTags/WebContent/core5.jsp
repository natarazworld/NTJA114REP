<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   <b> all request param names and values </b> <br>
   <c:forEach var="p" items="${paramValues}">
          param name ::  ${p.key} <br>
          param values ::
          <c:forEach  var="pv"  items="${p.value}">
                     ${pv},
          </c:forEach>
   <br>
   </c:forEach>  
   
   <hr>
   
   <b> all request header names and values </b>  <br>
   <c:forEach var="h" items="${headerValues}">
          header name ::  ${h.key} <br>
          header values ::
          <c:forEach  var="hv"  items="${h.value}">
                     ${hv},
          </c:forEach>
   <br>
   </c:forEach>  