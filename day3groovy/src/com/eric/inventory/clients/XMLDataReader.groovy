package com.eric.inventory.clients
import groovy.xml.XmlSlurper
products=new XmlSlurper().parse(new File("./src/com/eric/inventory/clients/product.xml"));

println "All the Products"
for(Object product : products.Product) {
	println "${product.Name},->,${product.Price}"
}

println "Enter Product Id to search"
productId=System.in.newReader().readLine()

for(Object product : products.Product) {
	//println "${product.Product_ID},${productId}"
	if(product.Product_ID==productId)
	  println "${product.Name},->,${product.Price}"
}