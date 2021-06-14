package com.eric.insurance
import groovy.json.JsonOutput

cities=[['CityName':'New York','CountryName':'USA'],
	
	['CityName':'New Delhi','CountryName':'India']
	
	]
	
	cityJson=JsonOutput.toJson(cities)
	prettyData=JsonOutput.prettyPrint(cityJson)
    File file=new File('d:/backup/cities.txt')
	file.write(prettyData)
	
	println "Data Written..."