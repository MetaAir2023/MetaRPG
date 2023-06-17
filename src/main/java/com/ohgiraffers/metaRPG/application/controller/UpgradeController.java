package com.ohgiraffers.metaRPG.application.controller;


import com.ohgiraffers.metaRPG.application.dto.item.ShowUserItemDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeResultDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeItemDTO;
import com.ohgiraffers.metaRPG.application.Service.UpgradeApplicationService;
import com.ohgiraffers.metaRPG.domain.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UpgradeController {
    private final UpgradeApplicationService upgradeApplicationService;

    @Autowired
    public UpgradeController(UpgradeApplicationService upgradeApplicationService){
     this.upgradeApplicationService = upgradeApplicationService;
    }

    public UpgradeItemDTO initUpgrade(String userName) {
        return upgradeApplicationService.initUpgradeItemDTO(userName);
    }

    public ShowUserItemDTO showUserItem(String userName) {
        ItemEntity userItem = upgradeApplicationService.getUserItem(userName);
        return new ShowUserItemDTO(userItem.getSequence(), userItem.getName());
    }

    public boolean checkUpgrade(UpgradeItemDTO upgradeItemDTO) {
        return upgradeApplicationService.checkUpgradeMoney(
                upgradeItemDTO.getUserMoney(),
                upgradeItemDTO.getUpgradeCost()
        );
    }

    // 사용자의 소지금과 강화 비용을 비교 및 차감하는 메소드
    public UpgradeItemDTO updateUserBalance(UpgradeItemDTO upgradeItemDTO) {
        int balance = upgradeApplicationService.calcBalanceAndSave(
                upgradeItemDTO.getUserSequence(),
                upgradeItemDTO.getUserMoney(),
                upgradeItemDTO.getUpgradeCost()
        );
        upgradeItemDTO.setUserMoney(balance);
        return upgradeItemDTO;
    }

    // 사용자의 UpgradeItemLevel 를 수정하는 메소드
    public UpgradeItemDTO updateUserUpgradeItemLevel(UpgradeItemDTO upgradeItemDTO, int updateUpgradeLevel) {
        int updateUpgradeItemLevel = upgradeApplicationService.updateUserUpgradeItemLevel(
                upgradeItemDTO.getUserSequence(),
                updateUpgradeLevel
        );
        upgradeItemDTO.setUserItemUpgradeLevel(updateUpgradeItemLevel);
        return upgradeItemDTO;
    }

    // 실질적인 강화 로직에 따라 강화를 진행하는 메소드
    public UpgradeResultDTO upgradeItem(UpgradeItemDTO upgradeItemDTO) {
        UpgradeResultDTO upgradeResult = upgradeApplicationService.calculateUpgradeItem(
                upgradeItemDTO.getUserItemUpgradeLevel()
        );
        System.out.println("upgradeResult = " + upgradeResult);
        upgradeItemDTO.setUserItemUpgradeLevel(upgradeResult.getResultUpgradeLevel());
        return upgradeResult;
    }
}
