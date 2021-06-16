package com.eric.inventory.clients
//GET method1
println new URL( "http://localhost:7070/products").text
//GET method2
def connection = new URL( "http://localhost:7070/products")
	.openConnection() as HttpURLConnection

// set some headers
connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
connection.setRequestProperty( 'Accept', 'application/json' )

// get the response code - automatically sends the request
println connection.responseCode + ": " + connection.inputStream.text

//POST method

def post = new URL("http://localhost:7070/products").openConnection();
def message = '{"productName":"test","dop":"2021-09-08"}'
post.setRequestMethod("POST")
post.setDoOutput(true)
post.setRequestProperty("Content-Type", "application/json")
post.getOutputStream().write(message.getBytes("UTF-8"));
def postRC = post.getResponseCode();
println(postRC);
if (postRC.equals(200)) {
	println(post.getInputStream().getText())
}