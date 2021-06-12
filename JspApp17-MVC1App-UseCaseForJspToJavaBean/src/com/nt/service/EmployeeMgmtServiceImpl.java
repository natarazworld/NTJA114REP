package com.nt.service;

import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl:: 0-param constructor");
	}

	@Override
	public void generatePayslipDetails(EmployeeDTO dto) {
		//calculate gross Salary and netSalary
		double  grossSalary=dto.getBasicSalary()+(dto.getBasicSalary()*0.4);
		double  netSalary=grossSalary- (grossSalary*0.2);
		//set gross and netSalary details to DTO class obj
		dto.setGrossSalary(grossSalary); dto.setNetSalary(netSalary);
	}

}
