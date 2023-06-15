package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.Service.UpgradeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("UpgradeController")
public class UpgradeController {
    private UpgradeApplicationService upgradeApplicationService;

    @Autowired
    public  UpgradeController(UpgradeApplicationService upgradeApplicationService){
     this.upgradeApplicationService=upgradeApplicationService;
    }
}
