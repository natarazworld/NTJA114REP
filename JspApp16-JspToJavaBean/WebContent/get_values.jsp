


<!-- create or Locate Java bean class obj -->
<jsp:useBean id="emp"  class="com.nt.beans.Employee"  scope="session"/>

<!-- Read and display java bean class obj properties data -->
<b>eno :: <jsp:getProperty name="emp" property="eno"/></b> <br>
<b>ename :: <jsp:getProperty name="emp" property="ename"/></b> <br>
<b>eadd :: <jsp:getProperty name="emp" property="eadd"/></b> <br>
<b>esalary :: <jsp:getProperty name="emp" property="esalary"/></b> <br>


<br><br>
<b> Java bean class object data is retrieved and displayed</b>