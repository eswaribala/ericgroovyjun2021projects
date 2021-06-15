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
		/*
		propertyFile.withInputStream { properties.load(it) }
		List<Object> params= new ArrayList()
		params.add(employee.empNo)
		params.add(employee.empName)
		params.add(employee.salary)
		params.add(employee.deptNo)
	    conn.executePreparedQuery(properties.saveEmployee, params){
			resultSet->println(resultSet)
		}
		*/
		
		conn.connection.autoCommit=false
		def sqlstr = """INSERT INTO emp(EMPNO,EMPNAME,SALARY,DEPTNO) 
               VALUES (123355,'Param',34659734,34)"""
		try 
		{
			 conn.execute(sqlstr); 
			 conn.commit()
			 status=true
			  println("Successfully committed")
			   } 
		catch(Exception ex) 
		{ 
			conn.rollback() 
			println("Transaction rollback")
			 }
		conn.close()
		
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
