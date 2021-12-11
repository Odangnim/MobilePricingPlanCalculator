package com.fab365.recruit.test;

public class NowTelecomMobilePricingPlan implements MobilePricingPlanService {

	@Override
	public int usageDataInMegabyte(Integer billingFee, Integer providingData) {
		int paymentSystem;
		int usageDataInMegabyte;
		
		if(providingData == 300) {
			paymentSystem = 29900;
			
			usageDataInMegabyte = ((billingFee - paymentSystem) / 20) + providingData;
		}
		else if(providingData == 3000) {
			paymentSystem = 34900;
			
			usageDataInMegabyte = ((billingFee - paymentSystem) / 20) + providingData;
		}
		else {
			paymentSystem = 69900;
			
			usageDataInMegabyte = providingData;
		}
		
		return usageDataInMegabyte;
	}

}
