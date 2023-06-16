package com.ohgiraffers.metaRPG.application.service;

import com.ohgiraffers.metaRPG.domain.entity.ItemEntity;
import com.ohgiraffers.metaRPG.domain.repository.ItemRepository;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import com.ohgiraffers.metaRPG.domain.service.UpgradeDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UpgradeApplicationService")
public class UpgradeApplicationService {
  private UpgradeDomainService upgradeDomainService;
  private UserRepository userRepository;
  private ItemRepository itemRepository;
  private ItemEntity itemEntity;
  @Autowired
  public  UpgradeApplicationService(UpgradeDomainService upgradeDomainService,UserRepository userRepository,ItemRepository itemRepository){
    this.upgradeDomainService=upgradeDomainService;
    this.userRepository=userRepository;
    this.itemRepository=itemRepository;

  }


  public boolean checkUpgrade(String name){
   int money=userRepository.showMoney(name);
   int itemTeir= itemRepository.getItemTier(userRepository.showItemSequence(name));
    int itemCost=itemEntity.getItemUpdateCost(itemTeir);
    return upgradeDomainService.checkUpgrade(money,itemCost);

  }
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

}
