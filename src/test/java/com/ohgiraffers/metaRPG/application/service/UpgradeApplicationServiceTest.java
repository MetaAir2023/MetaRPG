package com.ohgiraffers.metaRPG.application.service;


import com.ohgiraffers.metaRPG.ContextConfiguration;
import com.ohgiraffers.metaRPG.application.service.UpgradeApplicationService;

import com.ohgiraffers.metaRPG.application.controller.UpgradeController;
import com.ohgiraffers.metaRPG.domain.repository.ItemRepository;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(classes ={ContextConfiguration.class})
public class UpgradeApplicationServiceTest {


    @Autowired
    private UpgradeApplicationService upgradeApplicationService;
    @Autowired

    @Test
    public void testApplicationService(){
        assertNotNull(upgradeApplicationService);
    }


    @Test
    public void checkUpgradeTest(){
        //given
        String name="소드마스터";
//        int money=userRepository.showMoney(name);
//        int itemSequence=userRepository.showMoney(name);

        //when
        boolean checkUpgrade= upgradeApplicationService.checkUpgrade(name);
        //then
        System.out.println(checkUpgrade);}

    @Test
    public void checkChangeTest(){
        //given
        String name="소드마스터";
//

        //when
        int change= upgradeApplicationService.checkChange(name);
        //then
        System.out.println(change);
    }
}
