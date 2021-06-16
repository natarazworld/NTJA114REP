<%@ page isELIgnored="false" %>

 uname  req param value :: ${param.uname} <br>
 sadd req pram multipe values :: ${paramValues.sadd[0]},${paramValues.sadd[1] }
 
 <hr>
  user-agent  request header value ::  ${header['user-agent']} <br>
   <br>rquest header values :: ${headerValues} 

   <hr>
     dbuser init param value ::  ${initParam.dbuser} <br>
     dbpwd init param value ::  ${initParam.dbpwd} <br>
     
     <hr>
     cookie name ::  ${cookie.JSESSIONID.name } <br>
     cookie value ::  ${cookie.JSESSIONID.value }