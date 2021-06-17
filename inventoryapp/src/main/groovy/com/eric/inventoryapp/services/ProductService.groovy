package com.eric.inventoryapp.services

import com.eric.inventoryapp.facades.InventoryStream
import com.eric.inventoryapp.models.Product
import com.eric.inventoryapp.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.MessageChannel
import org.springframework.stereotype.Service

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import org.springframework.util.MimeTypeUtils;

@Service
class ProductService {

    @Autowired
	ProductRepository productRepository;
	
	InventoryStream inventoryStream;
	
	ProductService(InventoryStream invStreamObj){
		inventoryStream=invStreamObj;
	}
	
	//add the product to table
	
    Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	//read product from table
	Product getProductById(long productId) {
	   return productRepository.findById(productId).orElse(null)
	}
	
	//read all products from table
	List<Product> getAllProducts() {
		return productRepository.findAll()
	 }
	
	//delete the product
	 boolean deleteProductById(long productId) {
		 boolean status=false;
		  productRepository.delete(productId)
		  if(getProductById(productId)==null)
			  status=true
		  return status
	  }
	 
	  
	  //publish the message
	  boolean publishInventoryData(long productId) {
		  MessageChannel messageChannel = inventoryStream.outboundInventory();
		  return  messageChannel.send(MessageBuilder
				   .withPayload(productRepository.findById(productId).orElse(null) )
				   .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				   .build());

	  }
		
}

