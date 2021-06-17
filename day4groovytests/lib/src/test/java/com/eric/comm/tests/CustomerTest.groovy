package com.eric.comm.tests

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName

import com.eric.comm.dao.DBHelper
import com.eric.comm.models.Customer
import org.junit.jupiter.api.Test

import java.time.LocalDate
class CustomerTest {
	
	static final Customer customer = new Customer()
	
	@BeforeAll
	static void getInitialized() {
		
		customer.setCustomerId(9834579)
		customer.setCustomerName("Parameswari")
		customer.setDob(LocalDate.of(1970, 12, 2))
	}

	@Test
	@DisplayName("Customer Instance Test")
	void whenFindCustomer_thenReturnData() {
	
		assertEquals("Parameswari", customer.getCustomerName())
		assertTrue((LocalDate.now()-customer.getDob()>50))
		
	}
	
	//db test
	@Test
	@DisplayName("Oracle Instance Test")
	void WhenOracleDB_thenReturnInstance() {
	  //singleton test	
	  //assertTrue(new DBHelper().getConnection()!=null)
	  
	  assertTrue(DBHelper.instance.getConnection()!=null)
	}
	
	

}
