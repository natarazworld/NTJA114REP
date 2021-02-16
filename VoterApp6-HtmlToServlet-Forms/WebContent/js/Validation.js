    function validate(frm){
	
	    //empty the existing form validation error messages
          document.getElementById("pnameErr").innerHTML="";
         document.getElementById("pageErr").innerHTML="";
         document.getElementById("paddrsErr").innerHTML="";
	
	
          //read form data
          let  name=frm.pname.value;
          let age=frm.page.value;
          let addrs=frm.paddrs.value;
          let flag=true;
          
          
          //----Client side form validations ---------
          //----  required minlength  on name
          if(name==""){
            flag=false;
            document.getElementById("pnameErr").innerHTML="Person name is required"
            frm.pname.focus();
          }
          else if(name.length<10){
            flag=false;
            document.getElementById("pnameErr").innerHTML="person name must have minimum of 10 chars";
            frm.pname.focus();
          }
          
          // ---  required , range , number rules on age
          if(age==""){
            flag=false;
            document.getElementById("pageErr").innerHTML="person age is required";
            frm.page.focus();
          }
          else if(isNaN(age)){
            flag=false;
            document.getElementById("pageErr").innerHTML="person address must be numeric value";
            frm.page.focus();
          }
          else if(age<0 || age>125){
             flag=false;
             document.getElementById("pageErr").innerHTML="person age  must be there 1 through 125";
             frm.page.focus();
          }
          
          //required rule on addrs
          if(addrs==""){
             flag=false;
             document.getElementById("paddrsErr").innerHTML="person address is required";
             frm.paddrs.focus();  //keeps control in paddrs box
          }
           // change vflag (hidden box) value  to  "yes" indicating that the client side form validations are done
             frm.vflag.value="yes"; 
          
          return flag;
    }
