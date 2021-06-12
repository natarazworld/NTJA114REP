package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private String ename;
    private String desg;
    private double basicSalary;
    private  double  grossSalary;
    private  double  netSalary;
    
    public EmployeeDTO() {
		System.out.println("EmployeeDTO:: 0-param construtor");
	}
    
    //setters & getters
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
    
}
