package com.eric.insurance.services

import com.eric.insurance.models.Traveller

class TravellerService {
	
	
	def updateTravellerPaymentStatus(Traveller traveller, boolean paymentStatus) {
		
		traveller.setPaymentStatus(paymentStatus);
		return traveller;
	}
}
