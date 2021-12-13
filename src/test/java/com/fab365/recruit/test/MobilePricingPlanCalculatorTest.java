package com.fab365.recruit.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MobilePricingPlanCalculatorTest {
  @Test
  void test() {
    MobilePricingPlanService nowService = new MobilePricingPlanCalculator();
	  // 1메가
	  assertThat(nowService.minimumPricePlan(1)).isEqualTo("29900");
	  
	  // 551메가
	  assertThat(nowService.minimumPricePlan(551)).isEqualTo("34900");

	  // 4751메가
	  assertThat(nowService.minimumPricePlan(4751)).isEqualTo("69900");
	
	  // 10기가
	  assertThat(nowService.minimumPricePlan(10 * 1000)).isEqualTo("69900");
  
	  // A가 '29900'요금제 사용했을때 사용한 데이터 사용량
	  assertThat(nowService.usageDataInMegabyte(200000, "29900")).isEqualTo(8805);
	
	  // A가 '34900'요금제 사용했을때 사용한 데이터 사용량
	  assertThat(nowService.usageDataInMegabyte(200000, "34900")).isEqualTo(11255);
	  
	  // A가 '29900'요금제 사용하고 있을 시 가장 효율적인 요금제
	  assertThat(nowService.minimumPricePlan(nowService.usageDataInMegabyte(200000, "29900"))).isEqualTo("69900");

	  // A가 '34900'요금제 사용하고 있을 시 가장 효율적인 요금제
	  assertThat(nowService.minimumPricePlan(nowService.usageDataInMegabyte(200000, "34900"))).isEqualTo("69900");
	  
	  //'29900'요금제 사용시 추가 사용 데이터
	  assertThat(nowService.usageAddData(nowService.usageDataInMegabyte(200000, "29900"), "29900")).isEqualTo(8505);

	  //'34900'요금제 사용시 추가 사용 데이터
	  assertThat(nowService.usageAddData(nowService.usageDataInMegabyte(200000, "34900"), "34900")).isEqualTo(8255);
	  
	  //데이터 요금 상한제
	  assertThat(nowService.limitDataPrice(5001)).isEqualTo(100020);
	  assertThat(nowService.limitDataPrice(5000)).isEqualTo(25000);
	  assertThat(nowService.limitDataPrice(50000)).isEqualTo(180000);
  }
}
