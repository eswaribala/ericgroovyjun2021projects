package com.eric.comm.models

import groovy.transform.Canonical
import java.time.LocalDate

@Canonical class Customer {
	
	long customerId
	String customerName
	LocalDate dob
}
