package com.eric.insurance.models

import java.time.LocalDate
import groovy.transform.Canonical

@Canonical class Traveller {
	
	String firstName;
	String lastName;
	LocalDate dob;
	long mobileNo;
	boolean paymentStatus
	
}
