package com.ohgiraffers.metaRPG.application.service;

import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import com.ohgiraffers.metaRPG.domain.service.UpgradeDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UpgradeApplicationService")
public class UpgradeApplicationService {

  private final UpgradeDomainService upgradeDomainService;
  private final UserRepository userRepository;

  @Autowired
  public UpgradeApplicationService(
          UpgradeDomainService upgradeDomainService,
          UserRepository userRepository
  ) {
    this.upgradeDomainService = upgradeDomainService;
    this.userRepository = userRepository;
  }

  public boolean checkUpgradeMoney(int userMoney, int itemUpgradeCost) {
    return upgradeDomainService.checkUpgradeMoney(userMoney, itemUpgradeCost);
  }


  public int calcBalanceAndSave(int userSequence, int userMoney, int itemUpgradeCost) {
    int balance = upgradeDomainService.calcBalance(userMoney, itemUpgradeCost);
    return userRepository.findUserBySequence(userSequence).setMoney(balance);

  public int checkChange(String name){
      int money=userRepository.showMoney(name);
      int itemTeir= itemRepository.getItemTier(userRepository.showItemSequence(name));
      int itemCost=itemEntity.getItemUpdateCost(itemTeir);
      return upgradeDomainService.checkChange(money,itemCost);
  }
  public int checkItemCost(String name){
      int itemTeir= itemRepository.getItemTier(userRepository.showItemSequence(name));
      int itemCost=itemEntity.getItemUpdateCost(itemTeir);
      return itemCost;
  }

  public int calculateUpgradeItem(String name){
      int sequence= userRepository.showItemSequence(name);
      return upgradeDomainService.calculateUpgradeItem(sequence);

  }

  public int updateUserUpgradeItemLevel(int userSequence, int resultUpgradeLevel) {
      return userRepository.findUserBySequence(userSequence).setItemUpLv(resultUpgradeLevel);
  }

  public int calculateUpgradeItem(int upgradeLevel){
//     int status;
//     if(upgradeResult == 0) {
//       status = 0; // 강화 실패
//     } else if (upgradeResult == upgradeLevel) {
//       status = 2; // 강화 max
//     } else {
//       status = 1; // 강화 성공
//     }
     return upgradeDomainService.calculateUpgradeItem(upgradeLevel);
  }
}
