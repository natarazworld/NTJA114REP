package com.nt.basics;

import java.text.SimpleDateFormat;

public class DateConvertiionsTest {

	public static void main(String[] args) throws Exception{
	
		 //converting String date value to java.util.Date class object
		 String d1="55-30-1927"; //dd-MM-yyyy
		 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		 java.util.Date ud1=sdf.parse(d1);
		 System.out.println("util date "+ud1);
		 
		 //converting  java.util.Date class object to  java.sql.Date class object
		 long ms=ud1.getTime();   //Gives the no.of milli seconds that are elapsed from  1970 jan 1st mid night 00:00 hrs(epoch) to  the data time stored java.util.Date class obj(ud1)
		 System.out.println(ms);
		 java.sql.Date sd1=new java.sql.Date(ms);
		 System.out.println("sql date::"+sd1);
		 
		 //if given String date value is in yyyy-MM-dd pattern  then it can be directly converted in to java.sql.Date class object  with out converting 
		  //into java.util.Date class obj . use  valueOf(-) method in java.sql.Date class..
		  String d2="1956-10-15"; //yyyy-MM-dd
		  java.sql.Date sd2=java.sql.Date.valueOf(d2);
		  System.out.println(sd2);
		 
		 
		 

	}

}
