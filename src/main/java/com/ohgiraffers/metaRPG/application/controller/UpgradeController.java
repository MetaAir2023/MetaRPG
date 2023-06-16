package com.ohgiraffers.metaRPG.application.controller;


import com.ohgiraffers.metaRPG.application.service.UpgradeApplicationService;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("UpgradeController")
public class UpgradeController {
    private final UpgradeApplicationService upgradeApplicationService;

    @Autowired
    public UpgradeController(UpgradeApplicationService upgradeApplicationService){
     this.upgradeApplicationService = upgradeApplicationService;
    }

    // 사용자의 소지금과 강화 비용을 비교 및 차감하는 메소드
    public UpgradeItemDTO updateUserBalance(UpgradeItemDTO upgradeItemDTO) {
        boolean checkUpgradeMoney = upgradeApplicationService.checkUpgradeMoney(
                upgradeItemDTO.getUserMoney(),
                upgradeItemDTO.getUpgradeCost()
        );
        if(!checkUpgradeMoney) {
            throw new IllegalArgumentException("강화 비용이 부족합니다!");
        }
        int balance = upgradeApplicationService.calcBalanceAndSave(
                upgradeItemDTO.getUserSequence(),
                upgradeItemDTO.getUserMoney(),
                upgradeItemDTO.getUpgradeCost()
        );
        upgradeItemDTO.setUserMoney(balance);
        return upgradeItemDTO;
    }

    // 사용자의 UpgradeItemLevel 를 수정하는 메소드
    // updateUpgradeLevel 를 UpgradeItemDTO 에서 get 메소드를 안쓰는 이유 : upgradeItem 에서 리턴하는 UpgradeResultDTO 의 값을 넘겨줘야 하기 때문
    public UpgradeItemDTO updateUserUpgradeItemLevel(UpgradeItemDTO upgradeItemDTO, int updateUpgradeLevel) {
        int updateUpgradeItemLevel = upgradeApplicationService.updateUserUpgradeItemLevel(
                upgradeItemDTO.getUserSequence(),
                updateUpgradeLevel
        );
        upgradeItemDTO.setUserItemUpgradeLevel(updateUpgradeItemLevel);
        return upgradeItemDTO;
    }

    // 실질적인 강화 로직에 따라 강화를 진행하는 메소드
    public UpgradeItemDTO upgradeItem(UpgradeItemDTO upgradeItemDTO) {
        int upgradeResult = upgradeApplicationService.calculateUpgradeItem(
                upgradeItemDTO.getUserItemUpgradeLevel()
        );
        System.out.println("upgradeResult = " + upgradeResult);
        upgradeItemDTO.setUserItemUpgradeLevel(upgradeResult);
        /* 아래 로직은 View 클래스에서 처리
        if (upgradeResult.getStatus() == 0){
            System.out.println("강화 실패");
        } else if (upgradeResult.getStatus() == 2) {
            System.out.println("최대 강화 레벨입니다!");
        } else {
            System.out.println("강화 성공! 현재 아이템 강화 레벨 :" + upgradeResult.getResultUpgradeLevel());
        }
         */
        return upgradeItemDTO;
    }
}
