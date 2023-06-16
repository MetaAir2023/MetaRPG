package com.ohgiraffers.metaRPG.application.service;

import com.ohgiraffers.metaRPG.domain.service.UpgradeDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UpgradeApplicationService")
public class UpgradeApplicationService {
  private UpgradeDomainService upgradeDomainService;
  @Autowired
  public  UpgradeApplicationService(UpgradeDomainService upgradeDomainService){
    this.upgradeDomainService=upgradeDomainService;
  }
  public boolean checkUpgrade(int money,int itmeSequence){
    return upgradeDomainService.checkUpgrade(money,itmeSequence);

  }
  public int calculateUpgradeItem(int upgradeLevel){
    return upgradeDomainService.calculateUpgradeItem(upgradeLevel);
  }

}
