package com.ohgiraffers.metaRPG.application.Service;


import com.ohgiraffers.metaRPG.ContextConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes ={ContextConfiguration.class})
public class UpgradeApplicationServiceTests {

    @Autowired
    private UpgradeApplicationService upgradeApplicationService;

    @Test
    public void testApplicationService(){
        assertNotNull(upgradeApplicationService);
    }

    @Test
    public void testUserTotalStrikingPower() {
        int userSequence = 1;
        int userTotalStrikingPower = upgradeApplicationService.userTotalStrikingPower(userSequence);

        assertEquals(userTotalStrikingPower,30);
    }
    
}
