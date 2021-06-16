package com.eric.inventoryapp.services

import com.eric.inventoryapp.models.Product
import com.eric.inventoryapp.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
	ProductRepository productRepository;
	
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
	 
		
}

