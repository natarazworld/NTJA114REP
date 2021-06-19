<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"  user="system"  password="manager"/>

<!-- execute the select Query and getResultSet  -->
<sql:query dataSource="${ds}"  sql="SELECT PID,PNAME,PRICE,QTY,STATUS FROM PRODUCT"  var="rs"/>

<!-- Process the ResltSEt -->
<c:forEach  var="row"  items="${rs.rows}">
       ${row.pid } &nbsp;&nbsp; ${row.pname } &nbsp;&nbsp; ${row.price } &nbsp;&nbsp; ${row.qty } &nbsp;&nbsp; ${row.status } <br>
</c:forEach>




  