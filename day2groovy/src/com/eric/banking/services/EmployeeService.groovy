package com.eric.banking.services

import com.eric.banking.dao.DBHelper
import com.eric.banking.models.Employee

class EmployeeService {
	Object conn;	
	File propertyFile
	Properties properties
	Employee employee
	
	EmployeeService()
	{
	  properties=new Properties();
	  propertyFile=new File("./src/com/eric/banking/resources/db.properties")
	}
	def boolean saveEmployee(Employee employee) {		
	  return false	
	}
	
	def List<Employee> getAllEmployees() {
		
		conn=new DBHelper().getConnection()	
		propertyFile.withInputStream { properties.load(it) }
		def employeeList=[]
		conn.query(properties.employeeSelectAll) { resultSet ->
			while (resultSet.next()) {
			  employee=new Employee();
			  employee.setEmpNo(resultSet.getString(1).toString().toInteger())
			  employee.setEmpName(resultSet.getString(2))
			  employee.setSalary(resultSet.getString(3).toString().toInteger())
			  employee.setSalary(resultSet.getString(4).toString().toInteger())
			  employeeList.push(employee);
			 
			}
		  }
		  return employeeList;
	}
	
	
}
