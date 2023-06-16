package com.ohgiraffers.metaRPG.application.service;


import com.ohgiraffers.metaRPG.ContextConfiguration;
import com.ohgiraffers.metaRPG.application.service.UpgradeApplicationService;

import com.ohgiraffers.metaRPG.application.controller.UpgradeController;
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
    private UpgradeController upgradeController;
    @Test
    public void testApplicationService(){
        assertNotNull(upgradeApplicationService);
    }


    @Test
    public void checkUpgradeTest(){
        //given
        int money=10000;
        int itemSequence=1;
        //when
        boolean checkUpgrade= upgradeApplicationService.checkUpgrade(money,itemSequence);
        //then
        assertTrue(checkUpgrade);
    };
    @Test
    public void upgradecontrollerTest(){}
}
