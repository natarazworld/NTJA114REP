package com.nt.beans;

public class Employee {
	//bean properies
	private int eno;
	private String ename;
	private  String eadd;
	public  float  esalary;
	
	public Employee() {
		System.out.println("Employee:: 0-param constructor");
	}
	
	//getters && setters   (alt+shit+S, r)
	public int getEno() {
		System.out.println("Employee.getEno()");
		return eno;
	}
	public void setEno(int eno) {
		System.out.println("Employee.setEno()");
		this.eno = eno;
	}
	public String getEname() {
		System.out.println("Employee.getEname()");
		return ename;
	}
	public void setEname(String ename) {
		System.out.println("Employee.setEname()");
		this.ename = ename;
	}
	public String getEadd() {
		System.out.println("Employee.getEadd()");
		return eadd;
	}
	public void setEadd(String eadd) {
		System.out.println("Employee.setEadd()");
		this.eadd = eadd;
	}
	public float getEsalary() {
		System.out.println("Employee.getEsalary()");
		return esalary;
	}
	public void setEsalary(float esalary) {
		System.out.println("Employee.setEsalary()");
		this.esalary = esalary;
	}
	@Override   // alt+shift+s, s
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eadd=" + eadd + ", esalary=" + esalary + "]";
	}
	
	

}
