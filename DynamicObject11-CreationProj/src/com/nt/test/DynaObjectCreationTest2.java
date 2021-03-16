//DynaObjectCreationTest2.java
package com.nt.test;

import java.lang.reflect.Constructor;

public class DynaObjectCreationTest2 {

	public static void main(String[] args) throws Exception{
		//Load the class
		Class c=Class.forName(args[0]);
		//get All the constructors of  loaded java class
		Constructor cons[]=c.getDeclaredConstructors();
		//perform object creation process
		Object obj1=cons[0].newInstance();
		System.out.println("obj1 data::"+obj1);
		System.out.println("................");
		//perform object creation process
		Object obj2=cons[1].newInstance(10,20);
		System.out.println("obj2 data::"+obj2);

		
	}
}
