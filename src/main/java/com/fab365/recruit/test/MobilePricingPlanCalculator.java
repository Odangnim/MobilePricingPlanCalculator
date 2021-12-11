package com.fab365.recruit.test;

/**
 * A는 카드 청구서를 살펴보다가 휴대폰 요금이 20만원이나 나와 깜짝 놀랐습니다.
 * 내역을 살펴보니, 데이터를 너무 많이 쓴게 화근이었습니다.
 * 아래 통신사 요금표를 참고하여 데이터 사용량을 줄이지 않고 요금을 줄여주세요.
 *
 * 요금제, 데이터 제공량
 * 29900,	300MB
 * 34900,	3G
 * 69900,	무제한
 *
 * 조건) 기본 제공 데이터를 초과하여 사용한 데이터는 20원/1MB 의 과금이 적용 됩니다.
 * 조건) 69900원 이상 요금제는 데이터 초과금이 발생하지 않습니다.
 * 조건) 1000MB = 1GB 로 계산됩니다.
 */
public final class MobilePricingPlanCalculator {

  /**
   * 어떤 요금제를 선택해야 가장 적은 요금을 납부하는지 알려주는 함수
   * 데이터 사용량을 입력받아서 요금을 가장 적게 납부하는 요금제를 출력한다.
   *
   * @param usageDataInMegabyte 모바일 데이터 사용량. 단위는 Megabyte 임.
   *                            e.g. 100 = 100mb
   * @return 최저 요금의 요금제 이름
   */
  public String minimumPricePlan(Integer usageDataInMegabyte) {
    return "29900";
  }
}
