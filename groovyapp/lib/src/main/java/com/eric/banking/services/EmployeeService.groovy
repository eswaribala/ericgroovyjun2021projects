package com.eric.banking.services

import com.eric.banking.dao.DBHelper
import com.eric.banking.models.Employee
import groovy.sql.Sql

class EmployeeService {
	Sql conn;	
	File propertyFile
	Properties properties
	Employee employee
	
	EmployeeService()
	{
	  properties=new Properties();
	  propertyFile=new File(DBHelper.getPropertyFileName())
	}
	def boolean saveEmployee(Employee employee) {	
		conn=new DBHelper().getConnection()
		boolean status=false;
		
		propertyFile.withInputStream { properties.load(it) }
		//def params=[employee.getEmpNo(),
			//   employee.getEmpName(),employee.getSalary(),employee.getDeptNo()]
		println employee
		List<Object> params=new ArrayList<Object>();
		params.add(employee.getEmpNo())
		params.add(employee.getEmpName())
		params.add(employee.getSalary())
		params.add(employee.getDeptNo())
		println properties.saveEmployee
		conn.connection.autoCommit=false
		try {
					
	       conn.executeInsert properties.saveEmployee, params
		   status=true
		   conn.commit()
		}
		catch(Exception ex)
		{
			conn.rollback()
			println("Transaction rollback")
		}		
		
		
	  return status	
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
