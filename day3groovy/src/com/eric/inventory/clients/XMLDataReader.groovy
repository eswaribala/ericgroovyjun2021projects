package com.eric.inventory.clients
import groovy.xml.XmlSlurper
products=new XmlSlurper().parse(new File("./src/com/eric/inventory/clients/product.xml"));

for(Object product : products.Product) {
	println "${product.Name},->,${product.Price}"
}