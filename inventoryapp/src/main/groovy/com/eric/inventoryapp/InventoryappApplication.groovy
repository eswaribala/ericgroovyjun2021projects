package com.eric.inventoryapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class InventoryappApplication {

	static void main(String[] args) {
		SpringApplication.run(InventoryappApplication, args)
	}

}
