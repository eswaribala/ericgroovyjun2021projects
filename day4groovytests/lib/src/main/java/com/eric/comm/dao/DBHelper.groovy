package com.eric.comm.dao
import groovy.sql.Sql
@Singleton
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
		return "./src/main/java/com/eric/comm/resources/db.properties"
	}
}

