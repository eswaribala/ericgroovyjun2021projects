package com.eric.insurance

import java.time.LocalDate
import com.eric.insurance.models.Payment
import com.eric.insurance.models.Traveller
import com.eric.insurance.models.WalletPayment
import com.eric.insurance.services.TravellerService

class TravellerInfo {

	static void main(args) {
		// TODO Auto-generated method stub
		Traveller traveller =new Traveller("Parameswari","Bala",LocalDate.of(1970, 12, 2),997687553);
		//traveller.setFirstName("Parameswari")
	//	traveller.setLastName("Bala");
		//traveller.setDob(LocalDate.of(1970, 12, 2));
		//traveller.setMobileNo(9976856780)
		println traveller
		
		//invoke payment
		
		Payment payment=new WalletPayment();
		
		payment.makePayment(450000);
		
		//update traveller payment status
				
		traveller=new TravellerService().updateTravellerPaymentStatus(traveller, true)
		
		println traveller
		
		
		
	}
}
