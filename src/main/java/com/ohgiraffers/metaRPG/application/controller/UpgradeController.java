package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.service.UpgradeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("UpgradeController")
public class UpgradeController {
    private UpgradeApplicationService upgradeApplicationService;

    @Autowired
    public  UpgradeController(UpgradeApplicationService upgradeApplicationService){
     this.upgradeApplicationService=upgradeApplicationService;
    }
    public void checkChange(String name){
        int result=upgradeApplicationService.checkChange(name);
        System.out.println("남은돈은 : "+result);
    }
    public void checkUpgradeCost(String name){
        int result=upgradeApplicationService.checkItemCost(name);
        System.out.println("강화 비용은 : "+ result);
    }
    public void upgradeItem(String name){
        boolean check=upgradeApplicationService.checkUpgrade(name);
        if(check){
           int result= upgradeApplicationService.calculateUpgradeItem(name);
          if(result==0){
              System.out.println("강화 실패");
          }
        }
    }
}
