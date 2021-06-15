package com.eric.banking.services

import com.eric.banking.dao.DBHelper
import com.eric.banking.models.Employee

class EmployeeService {
	Object conn;	
	
	def boolean saveEmployee(Employee employee) {		
	  return false	
	}
	
	def getAllEmployees() {
		
		conn=new DBHelper().getConnection()
		
		conn.query('SELECT * FROM emp') { resultSet ->
			while (resultSet.next()) {
			  
			  print(resultSet.getString(1)+",")
			  print(resultSet.getString(2)+",")
			  print(resultSet.getString(3)+",")
			  println(resultSet.getString(4))
			}
		  }
	}
	
	
}
