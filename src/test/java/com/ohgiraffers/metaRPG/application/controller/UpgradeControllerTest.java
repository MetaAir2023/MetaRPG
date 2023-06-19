package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.ContextConfiguration;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeItemDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeResultDTO;
import com.ohgiraffers.metaRPG.domain.entity.ItemEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.domain.repository.ItemRepository;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes ={ContextConfiguration.class})
public class UpgradeControllerTest {

    @Autowired
    private UpgradeController upgradeController;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Test
    public void checkUpgradeItemTest(){
        //given
        UserEntity user = userRepository.findUserByName("소드마스터");
        ItemEntity item = itemRepository.searchItemBySequence(user.getItemSequence());
        UpgradeItemDTO upgradeItemDTO = new UpgradeItemDTO(
                user.getItemSequence(),
                user.getSequence(),
                user.getItemUpLv(),
                user.getMoney(),
                item.getItemUpdateCost()
        );
        //when
        UpgradeResultDTO upgradeResult = upgradeController.upgradeItem(upgradeItemDTO);
        //then
        assertEquals(user.getItemUpLv()+1, upgradeResult.getResultUpgradeLevel());
    };

    @Test
    public void checkUpdateUserBalanceTest(){
        //given
        UserEntity user = userRepository.findUserByName("소드마스터");
        ItemEntity item = itemRepository.searchItemBySequence(user.getItemSequence());
        UpgradeItemDTO upgradeItemDTO = new UpgradeItemDTO(
                user.getItemSequence(),
                user.getSequence(),
                user.getItemUpLv(),
                user.getMoney(),
                item.getItemUpdateCost()
        );
        //when
        UpgradeItemDTO updateUserBalanceResult = upgradeController.updateUserBalance(upgradeItemDTO);
        System.out.println(updateUserBalanceResult.getUserMoney());
        //then

        assertEquals(97000, updateUserBalanceResult.getUserMoney());
    };

    @Test
    public void checkUpdateUserUpgradeItemLevelTest(){
        //given
        UserEntity user = userRepository.findUserByName("소드마스터");
        ItemEntity item = itemRepository.searchItemBySequence(user.getItemSequence());
        UpgradeItemDTO upgradeItemDTO = new UpgradeItemDTO(
                user.getItemSequence(),
                user.getSequence(),
                user.getItemUpLv(),
                user.getMoney(),
                item.getItemUpdateCost()
        );
        int updateUpgradeLevel = 2;
        //when
        UpgradeItemDTO updateUserUpgradeItemLevel = upgradeController.updateUserUpgradeItemLevel(upgradeItemDTO, updateUpgradeLevel);
        //then

        assertEquals(2, updateUserUpgradeItemLevel.getUserItemUpgradeLevel());
    };
}
