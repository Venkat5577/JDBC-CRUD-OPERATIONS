package com.jsp.controllers;

import java.util.List;

import com.jsp.dao.EmployeeDao;
import com.jsp.dto.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		Employee employee =new Employee();
		EmployeeDao employeedao=new EmployeeDao();
		
		// 1.table creation
		
//		employeedao.createTable();
		
		employee.setEmail("ram13@gmail.com");
		employee.setId(4);
		employee.setName("asfg");
		employee.setPassword("AVR");
		employee.setPhoneNo(9381557746l);
		employee.setSal(60000.0);
		
		//2.saving employee details
		
//		Employee res=employeedao.saveEmployee(employee);
//		if(res!=null) {
//			System.out.println("data is saved");
//		}else {
//			System.out.println("data is not saved");
//		}
		
		//3. updating data
		
		
//		int res=employeedao.updateEmployee(employee);
//		
//		if(res>0) {
//			System.out.println("updated done");
//		}else {
//			System.out.println("data is not update");
//		}
		
		//4. deleting data
		
//		int res=employeedao.deleteEmployee(3);
//		if(res>0) {
//			System.out.println("data is delete");
//		}else {
//			System.out.println("data is not delete");
//		}
		
		//5. getting all employee details
		
//		List<Employee> list =employeedao.getAllEmployee();
//		
//		for(Employee employee:list) {
//			System.out.println("Employee id "+employee.getId());
//			System.out.println("Employee name "+employee.getName());
//			System.out.println("Employee phoneno "+employee.getPhoneNo());
//			System.out.println("Employee sal "+employee.getSal());
//			System.out.println("Employee Email "+employee.getEmail());
//			System.out.println("Employee password "+employee.getPassword());
//			System.out.println("**************************");
//		}
		
//		6.getting  employee details by id
		
		
//		Employee employee=employeedao.getEmployeeById(4);
//		if(employee!=null) {
//			System.out.println("Employee id: "+employee.getId());
//			System.out.println("Employee name: "+employee.getName());
//			System.out.println("Employee phoneno: "+employee.getPhoneNo());
//			System.out.println("Employee sal: "+employee.getSal());
//			System.out.println("Employee Email: "+employee.getEmail());
//			System.out.println("Employee password :"+employee.getPassword());
//		}
//		7.employee login
		Employee e=employeedao.login("ram@gmail.com", "AVR");
		if(e!=null) {
			System.out.println(" login successfully \n the employee details are: ");
			System.out.println("Employee id: "+e.getId());
			System.out.println("Employee name: "+e.getName());
			System.out.println("Employee phoneno: "+e.getPhoneNo());
			System.out.println("Employee sal: "+e.getSal());
			System.out.println("Employee username: "+e.getEmail());
			}
		else {
			System.out.println("enter the correct user name or password");
		}
		
	}
		
	}

