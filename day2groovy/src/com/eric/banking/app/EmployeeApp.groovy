package com.eric.banking.app

import com.eric.banking.dao.DBHelper
import com.eric.banking.models.Employee
import com.eric.banking.services.EmployeeService
import groovy.beans.PropertyReader

class EmployeeApp {

	static void main(args) {
		// TODO Auto-generated method stub
		/*
		def conn=new DBHelper().getConnection();
		if(conn!=null)
			println "Connected to Oracle"
		else
			println "Connection Could not be created"
			
	   	*/
	EmployeeService employeeService=new EmployeeService();	
  	//add the employee Data	
		
	employeeService.saveEmployee(new EmployeeApp().assignEmployeeData())
	
	//retrieve employee data
		
	for(Employee employee : employeeService.getAllEmployees()) {
		
		println employee
	  }
	}
	
	
	def Employee assignEmployeeData() {
		Employee employee=new Employee();
		employee.setEmpNo(1+new Random().next(100000))
		employee.setEmpName("Employee"+new Random().next(100000))
		employee.setSalary((8000+new Random().nextInt(100000)/10).toInteger())
		employee.setDeptNo((1+new Random().nextInt(1000)/100).toInteger())
		return employee
	}
}
