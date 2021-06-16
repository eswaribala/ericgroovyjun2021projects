package com.eric.inventory.clients

@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7')
@Grab('oauth.signpost:signpost-core:1.2.1.2')
//@Grab('oauth.signpost:signpost-commonshttp4:1.2.1.2')

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
@Grab('io.github.http-builder-ng:http-builder-ng-okhttp:0.14.2')
import static groovy.json.JsonOutput.toJson
import static groovyx.net.http.HttpBuilder.configure

def posts = configure {
	request.uri = 'https://jsonplaceholder.typicode.com'
	request.uri.path = '/posts'
	request.contentType = 'application/json'
	request.body = toJson(title: 'food', body: 'Dosa', userId: 1)
}.post()

println posts.title
