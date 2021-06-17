package com.eric.inventoryapp.facades
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(InventoryStream.class)
class StreamConfig {
}
