package com.ohgiraffers.metaRPG.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@PropertySource("metaRPG/domain/service/upgrade.properties")
public class UpgradeDomainService {

    @Value("${rate:1}")
    private double sensitivityRate;

    @Value("${MaxUpgradeLevel:10}")
    private int MaxUpgradeLevel;

    public boolean checkUpgradeMoney(int money, int itemUpgradeCost){
        return money > itemUpgradeCost;
    }

    public int calcBalance(int money, int itemUpgradeCost){
        return money - itemUpgradeCost;
    }
  
    /*
    아이템의 기본 공격력  = itemTier * 10;
    총 공격력 : 아이템의 기본 공격력 * upgradeLevel 의 제곱
     */
    public int calcItemStrikingPower(int itemTier, int upgradeLevel) {
        int basicItemStrikingPower = itemTier * 10;
        return basicItemStrikingPower * (int) Math.pow(upgradeLevel,2);
    }

    /*
         ## 강화 로직
         random.nextGaussian() : 평균 0.0 표준편차 1.0의 Gauss(가우스) 분포의 double 형 난수 생성
         nextGaussian() 에 수를 곱할 경우 표준편차가 바뀌고 수를 더할 경우 평균이 바뀜.
         참고자료 : https://www.geogebra.org/m/Mmf3AX7y
         평균 0.0 표준편차 1.0일 경우, P(-1 <= X <= 1) = 0.6827 (-3.9 <= X <= 4.7 근사치)
         updateStochasticSeed 는 upgradeLevel(1,2,3,4 ...)과 임의의 민감도를 곱하여 계산
         updateStochasticSeed 와 가우시안분포 값을 곱할 경우 (표준편차를 높임)
         upgradeLevel 가 높아질수록 정규 분포 상에서 확률 밀도 함수 값이 작아져
         updateStochastic 의 값이 -1~1 사이일 확률이 점점 낮아짐.
         updateStochasticSeed에서 upgradeLevel에 큰 숫자를 곱할 경우 민감도가 커짐 위 밀도 함수의 값 증가폭이 더 가속됨.
       */
    public double calculateRandomValue(int upgradeLevel) {
        Random random = new Random();
        System.out.println("sensitivityRate = " + sensitivityRate);
        double updateStochasticSeed = upgradeLevel * sensitivityRate;
        double gaussianRandomNumber = random.nextGaussian();
        return gaussianRandomNumber * updateStochasticSeed;
    }

    private boolean checkMaxUpgradeLevel(int upgradeLevel) {
        return upgradeLevel <= MaxUpgradeLevel;
    }

    private boolean checkRandomValue(int upgradeLevel) {
        double updateStochastic = calculateRandomValue(upgradeLevel);
        System.out.println("updateStochastic = " + updateStochastic);
        return updateStochastic <= 1 && updateStochastic >= -1;
    }

    public int calculateUpgradeItem(int upgradeLevel) {
        boolean checkMaxUpgradeLevel = checkMaxUpgradeLevel(upgradeLevel);
        if (!checkMaxUpgradeLevel) {
            return upgradeLevel;
        }
        boolean successUpgrade = this.checkRandomValue(upgradeLevel);
        return successUpgrade ? upgradeLevel + 1 : 0;
    }
}
