package com.eric.inventory.clients

import groovy.json.JsonSlurper

//GET method1
def userResponse=new URL( "https://jsonplaceholder.typicode.com/users").text
//user name
users=new JsonSlurper().parseText(userResponse)

// println "$users.username"

users.each { t->
	entries=t.entrySet()
	entries.forEach{ entry->
     if(entry.key.equals("username")) 		
	   println entry.value
	}
}
/*
//GET method2
def connection = new URL( "https://jsonplaceholder.typicode.com/photos")
	.openConnection() as HttpURLConnection

// set some headers
connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
connection.setRequestProperty( 'Accept', 'application/json' )

// get the response code - automatically sends the request
println connection.responseCode + ": " + connection.inputStream.text
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

//POST method

def post = new URL("https://jsonplaceholder.typicode.com/photos").openConnection();
def message = JsonOutput.toJson(title: 'Groovy Training', body: 'Rest Client', userId: 10000)
post.setRequestMethod("POST")
post.setDoOutput(true)
post.setRequestProperty("Content-Type", "application/json")
post.getOutputStream().write(message.getBytes("UTF-8"));
def postRC = post.getResponseCode();
println(postRC);
/**
 * 100 request under processing
 * 200 successful response
 * 300 redirection
 * 400+ authentication or page not found, incorrect json data
 * 500 internal server error logical error 
 */
/*
if ((postRC>200) && (postRC<299)) {
	println(post.getInputStream().getText())
}
*/