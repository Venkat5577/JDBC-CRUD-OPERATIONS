package com.jsp.dao;

import com.jsp.dto.Employee;

public class Jdbc2 {
 public static void main(String[] args) {
	EmployeeDao empd=new EmployeeDao();
//	empd.createTable();
	Employee emp=new Employee();
	emp.setEmail("am@gmail");
	emp.setId(1);
	emp.setName("ramana");
	emp.setPassword("123456");
	emp.setPhoneNo(9381557746l);
	emp.setSal(60000.0);
	int e=empd.updateEmployee(emp);
	if(e!=0) {
		System.out.println("data saved");
	}
	else
		System.out.println("data not saved");
}
}
