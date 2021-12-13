package com.fab365.recruit.test;


/**
 * A는 카드 청구서를 살펴보다가 휴대폰 요금이 wonPerMB만원이나 나와 깜짝 놀랐습니다.
 * 내역을 살펴보니, 데이터를 너무 많이 쓴게 화근이었습니다.
 * 아래 통신사 요금표를 참고하여 데이터 사용량을 줄이지 않고 요금을 줄여주세요.
 *
 * 요금제, 데이터 제공량
 * 29900,	300MB
 * 34900,	3G
 * 69900,	무제한
 *
 * 조건) 기본 제공 데이터를 초과하여 사용한 데이터는 wonPerMB원/1MB 의 과금이 적용 됩니다.
 * 조건) 69900원 이상 요금제는 데이터 초과금이 발생하지 않습니다.
 * 조건) 1000MB = 1GB 로 계산됩니다.
 */
public final class MobilePricingPlanCalculator implements MobilePricingPlanService {

  /**
   * 어떤 요금제를 선택해야 가장 적은 요금을 납부하는지 알려주는 함수
   * 데이터 사용량을 입력받아서 요금을 가장 적게 납부하는 요금제를 출력한다.
   *
   * @param usageDataInMegabyte 모바일 데이터 사용량. 단위는 Megabyte 임.
   *                            e.g. 100 = 100mb
   * @return 최저 요금의 요금제 이름
   */

	private int payment;
	private int usageDataInMegabyte;
	private String paymentSystem;
	private int aPrice;
	private int bPrice;
	private int cPrice;
	private int aData;
	private int bData;
	private int cData;
	private int wonPerMB;
	private int usageAddData;
	private int limitPrice;
	
	public MobilePricingPlanCalculator() {
		this.aPrice = 29900;
		this.bPrice = 34900;
		this.cPrice = 69900;
		this.aData = 300;
		this.bData = 3 * 1000;
		this.cData = 1000 * 1000;
		this.wonPerMB = 20;
	}
	
	
	@Override
	public int usageDataInMegabyte(Integer billingFee, String nowPaymentSystem) {
		
		if(nowPaymentSystem.equals("29900")) {
			payment = aPrice;
			
			this.usageDataInMegabyte = ((billingFee - payment) / wonPerMB) + aData;
		}
		else if(nowPaymentSystem.equals("34900")) {
			payment = bPrice;
			
			this.usageDataInMegabyte = ((billingFee - payment) / wonPerMB) + bData;
		}
		else {
			payment = cPrice;
			
			this.usageDataInMegabyte = cData;
		}
		
		return this.usageDataInMegabyte;
	}
	
	@Override
	public String minimumPricePlan(Integer usageDataInMegabyte) {
		
		if(usageDataInMegabyte <= ((bPrice - aPrice) / wonPerMB) + aData) {
			paymentSystem = "29900";
		}
		else if(usageDataInMegabyte <= ((cPrice - bPrice) / wonPerMB) + bData) {
			paymentSystem = "34900";
		}
		else {
			paymentSystem = "69900";
		}
		
	    return paymentSystem;
	}

	@Override
	public int usageAddData(Integer usageDataInMegabyte, String nowPaymentSystem) {
		
		if(nowPaymentSystem.equals("29900")) {
			this.usageAddData = usageDataInMegabyte - 300;
		}
		else if(nowPaymentSystem.equals("34900")) {
			this.usageAddData = usageDataInMegabyte - 3000;
		}
		else {
			this.usageAddData = 0;
		}
		
		return this.usageAddData;
	}

	@Override
	public int limitDataPrice(Integer usageAddData) {
		
		if(usageAddData <= 5000) {
			this.limitPrice = usageAddData * 20;
			
			if(this.limitPrice > 25000) {
				this.limitPrice = 25000;
			}
		}
		else {
			this.limitPrice = usageAddData * 20;
			
			if(this.limitPrice > 180000) {
				this.limitPrice = 180000;
			}
		}
		
		return this.limitPrice;
	}



}
