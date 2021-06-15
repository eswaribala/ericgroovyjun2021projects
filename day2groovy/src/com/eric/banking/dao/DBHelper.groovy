package com.eric.banking.dao
import groovy.sql.Sql
class DBHelper {

	def Sql getConnection() {
		
		Properties properties=new Properties();
		File propertyFile=new File(getPropertyFileName())
		propertyFile.withInputStream { properties.load(it) }
		
	    println properties.url
		
		def sql = Sql.newInstance(properties.url, properties.userName, properties.password, 
			properties.driverClassName)	
	   return sql
	
	}
	
	def static String getPropertyFileName() {
		return "./src/com/eric/banking/resources/db.properties"
	}
}

