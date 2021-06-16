package com.eric.inventory.clients
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*


try {
	def restClient = new RESTClient("https://jsonplaceholder.typicode.com")
	//def response = restClient.get(path: '/users', query: ['id': 1])
	def response = restClient.get(path: '/users')
	println "Status     : ${response.status}"
	response.data.each { t-> println t }
} catch (Exception e) {
	println "Error      : ${e.statusCode}"
	println "Message    : ${e.response.data}"
}