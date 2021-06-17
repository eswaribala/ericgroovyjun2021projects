package com.eric.inventoryapp.controllers

import com.eric.inventoryapp.models.Product
import com.eric.inventoryapp.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {
	@Autowired
	ProductService productService

	@PostMapping("/products")
	@ResponseBody Product saveProduct(@RequestBody Product product) {
		
		return productService.addProduct(product)
	}
	
	@GetMapping("/products")
	List<Product> fetchAllProducts(){
		return productService.getAllProducts()
	}
	
	@GetMapping("/products/publish/{productId}")
	String publishAllProducts(@PathVariable("productId") long productId){
		if(productService.publishInventoryData(productId))
			return "Data published"
		else
			return "Error in publishing....."
	}
	
	
}


