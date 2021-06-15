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
		
	for(Employee employee :new EmployeeService().getAllEmployees()) {
		
		println employee
	  }
	}
}
