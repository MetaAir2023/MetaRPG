package com.ohgiraffers.metaRPG.application.Service;

import com.ohgiraffers.metaRPG.application.dto.item.UpgradeItemDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeResultDTO;
import com.ohgiraffers.metaRPG.domain.entity.ItemEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.domain.repository.ItemRepository;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import com.ohgiraffers.metaRPG.domain.service.UpgradeDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpgradeApplicationService {

  private final UpgradeDomainService upgradeDomainService;
  private final UserRepository userRepository;
  private final ItemRepository itemRepository;

  @Autowired
  public UpgradeApplicationService(
          UpgradeDomainService upgradeDomainService,
          UserRepository userRepository,
          ItemRepository itemRepository
  ) {
    this.upgradeDomainService = upgradeDomainService;
    this.userRepository = userRepository;
    this.itemRepository = itemRepository;
  }
  public UpgradeItemDTO initUpgradeItemDTO(String userName) {
      UserEntity user = userRepository.findUserByName(userName);
      ItemEntity item = itemRepository.searchItemBySequence(user.getItemSequence());
      return new UpgradeItemDTO(
              item.getSequence(),
              user.getSequence(),
              user.getItemUpLv(),
              user.getMoney(),
              item.getItemUpdateCost()
              );
  };

  public ItemEntity getUserItem(String userName) {
      int userItemSequence = userRepository.showItemSequence(userName);
      return itemRepository.searchItemBySequence(userItemSequence);
  }

  public boolean checkUpgradeMoney(int userMoney, int itemUpgradeCost) {
    return upgradeDomainService.checkUpgradeMoney(userMoney, itemUpgradeCost);
  }


  public int calcBalanceAndSave(int userSequence, int userMoney, int itemUpgradeCost) {
      int balance = upgradeDomainService.calcBalance(userMoney, itemUpgradeCost);
      return userRepository.findUserBySequence(userSequence).setMoney(balance);
  }

//  public int calculateUpgradeItem(String name){
//      int sequence= userRepository.showItemSequence(name);
//      return upgradeDomainService.calculateUpgradeItem(sequence);
//
//  }

  public int updateUserUpgradeItemLevel(int userSequence, int resultUpgradeLevel) {
      return userRepository.findUserBySequence(userSequence).setItemUpLv(resultUpgradeLevel);
  }

  public UpgradeResultDTO calculateUpgradeItem(int upgradeLevel){
      int upgradeResult = upgradeDomainService.calculateUpgradeItem(upgradeLevel);
      int status;
      if(upgradeResult == 0) {
          status = 0; // 강화 실패
      } else if (upgradeResult == upgradeLevel) {
          status = 2; // 강화 max
      } else {
          status = 1; // 강화 성공
      }
      return new UpgradeResultDTO(status, upgradeResult);
  }
}
