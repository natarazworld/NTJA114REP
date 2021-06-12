


<!-- create or Locate java bean class obj -->
<jsp:useBean id="emp"  class="com.nt.beans.Employee"  scope="session"/>

<!-- set values to bean properties  -->
<%-- <jsp:setProperty name="emp"  property="eno"  value="10001"/>
<jsp:setProperty name="emp"  property="ename"  value="rajesh"/>
<jsp:setProperty name="emp"  property="eadd"  value="hyd"/>
<jsp:setProperty name="emp"  property="esalary"  value="90000"/>
 --%>
 
  <!-- To set request param values as java bean property values we can use "param" attribute in place of "value" -->
 <%--  <jsp:setProperty name="emp"  property="eno"  param="empno"/>
<jsp:setProperty name="emp"  property="ename"  param="empname" />
<jsp:setProperty name="emp"  property="eadd"  param="empadd"/>
<jsp:setProperty name="emp"  property="esalary" param="empsalary"/>
 --%> 
 
 <!-- To set request param values as java bean property values we can use property="*" if the bean property names are matching with req param names-->
 <jsp:setProperty name="emp"  property="*"/>
 
<b>Values are set to bean properties</b>



