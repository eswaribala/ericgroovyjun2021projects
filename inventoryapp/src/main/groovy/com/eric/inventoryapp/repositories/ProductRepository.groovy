package com.eric.inventoryapp.repositories

import com.eric.inventoryapp.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository extends JpaRepository<Product,Long>{
}
