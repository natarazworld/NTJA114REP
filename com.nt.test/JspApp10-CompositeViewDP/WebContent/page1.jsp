<%@ page info="jsp page implementing  composite view design pattern" %>

<table width="100%"  height="100%">
  <tr>
    <td colspan="3" width="100%"> <jsp:include page="header.jsp" />  </td>
  </tr>
  <tr>
    <td  width="30%"> <%@include file="menu.html"  %>  </td>
    <td  width="40%"> <jsp:include page="welcome.jsp" />  </td>
    <td  width="30%">
        <table  >
            <tr>
              <td><jsp:include page="weather_report.jsp"></jsp:include> </td>
              <td><jsp:include page="sports.jsp"></jsp:include> </td>         
            </tr>
        </table> 
     </td>
  </tr>
 
  <tr>
    <td colspan="3"> <%@include file="footer.html" %> </td>
 </tr>
  
  

</table>