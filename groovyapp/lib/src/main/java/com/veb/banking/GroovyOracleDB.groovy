package com.veb.banking
import groovy.sql.Sql
class GroovyOracleDB {

	static main(def args)
	{
		def url = 'jdbc:oracle:thin:@localhost:1521:xe'
		def user = 'System'
		def password = 'vignesh'
		def driver = 'oracle.jdbc.driver.OracleDriver'
		def sql = Sql.newInstance(url, user, password,driver)
		
		// use 'sql' instance ...
		sql.query('SELECT * FROM emp') { resultSet ->
			while (resultSet.next()) {			  
			  
			  print(resultSet.getString(1))
			  println(resultSet.getString(2))
			}
		  }
		  /*
	    sql.connection.autoCommit=false
		def sqlstr = """INSERT INTO Project(project_id, project_name) VALUES (1280,'GeoSpace')""" 
		try 
		{
			 sql.execute(sqlstr); 
			 sql.commit()
			  println("Successfully committed")
			   } 
		catch(Exception ex) 
		{ 
			sql.rollback() 
			println("Transaction rollback")
			 }
		sql.close()
		*/
	}
}
