package com.eric.banking.models

import groovy.transform.Canonical

@Canonical class Employee {
	long empNo;
	String empName;
	int salary;
	int deptNo;
}
