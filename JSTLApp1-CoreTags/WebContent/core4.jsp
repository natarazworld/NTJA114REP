<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- traditional for loop -->
<b> tradtional for loop</b>  <br>
<table border="1"  align="left">
  <c:forEach  var="i"  begin="1"  end="10"  step="1"  >
    <tr>
         <td>2  *  ${i }  = </td> <td>  ${2*i } </td>
    </tr>
    </c:forEach>
</table>  
<hr>
<br>
<b> enhanced for loop1</b>  <br>
 <jsp:scriptlet>
       String nickNames[]=new String[]{"kanna","munna","chinna","pappu"};
       request.setAttribute("nNames", nickNames);
 </jsp:scriptlet>
 
   <c:forEach var="nick"  items="${nNames}">
       ${nick} <br>
   </c:forEach>
  