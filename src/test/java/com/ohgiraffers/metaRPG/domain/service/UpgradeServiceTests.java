package com.ohgiraffers.metaRPG.domain.service;

import com.ohgiraffers.metaRPG.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class UpgradeServiceTests {

    @Autowired
    private UpgradeService upgradeService;

    @Test
    public void testCreateUpgradeService() {
        assertNotNull(upgradeService);
    }

    @Test
    public void testCheckUpgrade() {
        int money = 10000;
        int itemSequence = 1;
        boolean checkUpgrade = upgradeService.checkUpgrade(money, itemSequence);
        assertTrue(checkUpgrade);
    }

    @Test
    public void testCalculateRandomValue() {
        int upgradeLevel = 1;
        double afterUpgradeItemLevel = upgradeService.calculateRandomValue(upgradeLevel);
        assertEquals(afterUpgradeItemLevel,0,1);
    }

    @Test
    public void testCalculateUpgradeItem() {
        int upgradeLevel = 1;
        int afterUpgradeItemLevel = upgradeService.calculateUpgradeItem(upgradeLevel);
        assertEquals(upgradeLevel+1, afterUpgradeItemLevel);
    }
}
