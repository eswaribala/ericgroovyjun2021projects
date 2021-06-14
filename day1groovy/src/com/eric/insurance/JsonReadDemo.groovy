package com.eric.insurance

//read from command line arguments
import groovy.json.JsonSlurper

import groovy.json.JsonOutput

//command line arguments
if(args.size()<1) {
	println("file missing")
	System.exit(0)
}

fileName=args[0]

//convert json string to object
jsonObject=new JsonSlurper().parseText('{"Name":"RPS","Service":"Training"}')

println "Name=$jsonObject.Name, Service=$jsonObject.Service"


//map to json

travelList=['Name':'Parameswari','Country':'USA','Duration':20]
jsonData=JsonOutput.toJson(travelList)
println "$jsonData"

//to read json from file


users=new JsonSlurper().parse(new File(fileName))

//println "$users"

users.each { t-> 
	entries=t.entrySet()
	entries.forEach{ entry->
	   println entry
	}
}



