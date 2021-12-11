package com.fab365.recruit.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MobilePricingPlanCalculatorTest {
  @Test
  void test() {
    MobilePricingPlanCalculator calculator = new MobilePricingPlanCalculator();
    MobilePricingPlanService service = new NowTelecomMobilePricingPlan();
//	  // 1메가
//	  assertThat(calculator.minimumPricePlan(1)).isEqualTo("?");
//	
//	  // 10기가
//	  assertThat(calculator.minimumPricePlan(10 * 1000)).isEqualTo("?");
  
	  //제공 데이터 300MB
	  assertThat(service.usageDataInMegabyte(200000, 300)).isEqualTo(8805);
	
	  //제공 데이터 3GB
	  assertThat(service.usageDataInMegabyte(200000, 3000)).isEqualTo(11255);
	  
	  //제공 데이터 무제한
	  assertThat(service.usageDataInMegabyte(200000, 1000000)).isEqualTo(1000000);
  }
}
