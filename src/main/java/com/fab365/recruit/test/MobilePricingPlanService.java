package com.fab365.recruit.test;


public interface MobilePricingPlanService {
	//사용자가 사용한 총 데이터
	public int usageDataInMegabyte(Integer billingFee, String nowPaymentSystem);
	
	//알맞은 요금제 찾기
	public String minimumPricePlan(Integer usageDataInMegabyte);
	
	//사용자가 추가로 사용한 데이터
	public int usageAddData(Integer usageDataInMegabyte, String nowPaymentSystem);

	//데이터 요금 상한제
	public int limitDataPrice(Integer usageAddData);
}
