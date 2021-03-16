package com.nt.comp;

public class Test {
	private int a,b;
	
	public  Test() {
		System.out.println("Test:: 0-param constructor");
	}
	
	public  Test(int a, int b) {
		this.a=a;
		this.b=b;
		System.out.println("Test:: 2-param constructor");
	}
	
	public String toString() {
		return "a="+a+",b="+b;
	}


}
