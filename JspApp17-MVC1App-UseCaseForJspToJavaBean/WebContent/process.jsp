<%@page import="com.nt.dto.EmployeeDTO"%>
<%@ page isELIgnored="false"  %>

<!-- read form data and store into EmployeeDTO class object   -->
 <jsp:useBean id="empDTO" class="com.nt.dto.EmployeeDTO" scope="request"/>
 <jsp:setProperty name="empDTO"  property="*" />
 
 <!--  create service class object -->
 <jsp:useBean id="empService"  class="com.nt.service.EmployeeMgmtServiceImpl"  type="com.nt.service.IEmployeeMgmtService"  scope="application"/>
 
 <!-- invoke business method -->
  <%
     empService.generatePayslipDetails(empDTO);
  %>
 
 
 <!-- Display results -->
 <h1 style="color:red;text-align:center"> Employee Details  </h1>
 <b> Employee name  ::   <jsp:getProperty property="ename" name="empDTO"/> </b> <br>
 <b> Employee desg  ::   <jsp:getProperty property="desg" name="empDTO"/> </b> <br>
 <b> Employee basicSalary  ::   <jsp:getProperty property="basicSalary" name="empDTO"/> </b> <br>
 <b> Employee grossSalary  ::   <jsp:getProperty property="grossSalary" name="empDTO"/> </b> <br>
 <b> Employee netSalary  ::   <jsp:getProperty property="netSalary" name="empDTO"/> </b> <br>
 
 <!--  home hyperlink -->
 <a href="input.html">home</a>
   
 
 