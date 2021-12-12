package com.fab365.recruit.test;

public interface MobilePricingPlanService {
	//사용자가 사용한 총 데이터
	public int usageDataInMegabyte(Integer billingFee, String nowPaymentSystem);
	
	//알맞은 요금제 찾기
	public String minimumPricePlan(Integer usageDataInMegabyte);
}
