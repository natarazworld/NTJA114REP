<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@page contentType="text/html; charset=UTF-8" %>

 <fmt:setLocale value="fr_FR/>
 
 <fmt:formatNumber var="fno"  value="40006656066" type="number" />
 Formatted number :: ${fno}.
 <br> 
 
 <fmt:formatNumber var="fno1"  value="50006656066" type="currency" />
 Formatted currency number :: ${fno1}.

<br>

<jsp:useBean id="dt"  class="java.util.Date"/>
<fmt:formatDate var="fdt"  value="${dt}"  type="both"  timeStyle="full" />
 Formatted date value :: ${fdt}.
<br>

<!-- To farmat vegetable -->
 <fmt:setBundle basename="com/nt/commons/info"/>
 <fmt:message  key="welcome.msg"/> <br>
    
 
 
  