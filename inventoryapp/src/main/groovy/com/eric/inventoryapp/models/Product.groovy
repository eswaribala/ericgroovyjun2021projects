package com.eric.inventoryapp.models

import static javax.persistence.GenerationType.SEQUENCE
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

import org.springframework.format.annotation.DateTimeFormat

import groovy.transform.Canonical
import java.time.LocalDate

@Entity
@Table(name="Eric_Product")
@Canonical class Product {
	@Id
	@GeneratedValue(strategy=SEQUENCE,generator="prod_seq")
	@SequenceGenerator(name="prod_seq",sequenceName="eric_product_seq",allocationSize=1)
	@Column(name="Product_Id")
	long productId;
	@Column(name="Product_Name",nullable=false,length=100)
	String productName
	@DateTimeFormat(iso=DATE)
	@Column(name="DOP")
	LocalDate dop
	
	
}
