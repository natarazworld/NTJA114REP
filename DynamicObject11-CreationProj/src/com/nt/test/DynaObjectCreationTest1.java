package com.nt.test;

public class DynaObjectCreationTest1 {

	public static void main(String[] args) throws Exception{
		//Load the class
		Class c=Class.forName(args[0]);
		//create object using  newInstance() of java.lang.Class
		Object obj=c.newInstance();
		System.out.println(obj.toString());
	}
}
