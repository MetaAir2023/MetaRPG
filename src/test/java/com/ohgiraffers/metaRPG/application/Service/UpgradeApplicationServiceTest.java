package com.ohgiraffers.metaRPG.application.Service;


import com.ohgiraffers.metaRPG.ContextConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes ={ContextConfiguration.class})
public class UpgradeApplicationServiceTest {

    @Autowired
    private UpgradeApplicationService upgradeApplicationService;
    @Autowired

    @Test
    public void testApplicationService(){
        assertNotNull(upgradeApplicationService);
    }
    
}
