


<%!
    public void jspInit(){
	   //get access to ServletConfig,ServletContext objs 
	   ServletConfig cg=getServletConfig();
	   ServletContext sc=getServletContext();
	   //read  context param values
	   System.out.println("c1 context param value ::"+sc.getInitParameter("c1"));
	 //read  init param values
	   System.out.println("p1 init param value ::"+cg.getInitParameter("p1"));
    }
   %>
   
   <b>c1 context param value ::  <%= application.getInitParameter("c1")%> </b> <br>
   <b>p1 init param value ::  <%= config.getInitParameter("p1")%> </b> <br>
   

 
