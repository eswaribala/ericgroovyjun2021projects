package com.eric.inventoryapp.facades

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface InventoryStream {
	
	String OUTPUT = "inventory-out";
	
	 @Output(OUTPUT)
	 MessageChannel outboundInventory();
}
