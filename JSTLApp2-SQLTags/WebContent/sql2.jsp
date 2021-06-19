<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"  user="system"  password="manager"/>

<!-- execute the no-select Query  -->
<sql:update var="count" dataSource="${ds}"  sql="UPDATE PRODUCT SET PRICE=PRICE+? WHERE PRICE>?" >
    <sql:param>100</sql:param>
    <sql:param>8000</sql:param>
</sql:update>

<b> no.of record that are effeted :: ${count}</b>





  