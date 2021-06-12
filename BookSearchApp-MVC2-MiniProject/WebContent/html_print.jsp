<%@ page  isELIgnored="false"  import="java.util.*, com.nt.dto.BookDetailsDTO" %>

<%
     //read  request scope data
     List<BookDetailsDTO> listDTO=(List<BookDetailsDTO>) request.getAttribute("booksInfo");
    //read form data (hidden box value)
    String category=request.getParameter("category"); 
%>

 <h1 style="color:red;text-align:center">Books Belonging to  ::<%=category%></h1>
 
  <%
      if(listDTO!=null && listDTO.size()!=0){ %>
    	   <table border="1" bgcolor="cyan" align="center">
    	   <tr> <th>BookId </th> <th>BookName </th> <th>Category </th> <th>Author </th><th> price <th>Status</th> </th> 
    	 <% for(BookDetailsDTO dto:listDTO){  %>
    	        <tr>
    	            <td><%= dto.getSerialNo()%>  </td>
    	            <td><%= dto.getBookId()%>  </td>
    	            <td><%= dto.getBookName()%>  </td>
    	            <td><%= dto.getCategory()%>  </td>
    	        <td><%= dto.getAuthor()%>  </td>
    	        <td><%= dto.getPrice()%>  </td>
    	        <td><%= dto.getStatus()%>  </td>
    	        </tr>
    	<%  }//for   %>
    	   </table>
 <%    }//if
      else {   %>
    	       <h1 style="color:red;text-align:center">Books  not found </h1>
     <% }
  %>
  
  <br><br>
     <a href="JavaScript:showPrint()">print</a>
     
     <script language="JavaScript">
        function showPrint(){
        	frames.focus();
        	frames.print();
        }
     </script>
  