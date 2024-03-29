package com.ohgiraffers.metaRPG.domain.service;

import com.ohgiraffers.metaRPG.ContextConfiguration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class UpgradeServiceTests {

    @Autowired
    private UpgradeDomainService upgradeDomainService;


    @Test
    public void testCreateUpgradeService() {
        assertNotNull(upgradeDomainService);
    }



    @Test
    public void testCheckUpgrade() {
        int money = 10000;
        int itemUpgradeCost = 2000;
        boolean checkUpgrade = upgradeDomainService.checkUpgradeMoney(money, itemUpgradeCost);
        assertTrue(checkUpgrade);
    }

    @Test
    public void testCalcItemStrikingPower() {
        int itemTier = 3;
        int upgradeLevel = 1;
        int checkItemStrikingPower = upgradeDomainService.calcItemStrikingPower(itemTier, upgradeLevel);
        assertEquals(checkItemStrikingPower,30);
    }

    @Test
    public void testCalculateRandomValue() {
        int upgradeLevel = 1;
        double afterUpgradeItemLevel = upgradeDomainService.calculateRandomValue(upgradeLevel);
        assertEquals(afterUpgradeItemLevel,0,1);
    }

    @Test
    public void testCalculateUpgradeItem() {
        int upgradeLevel = 1;
        int afterUpgradeItemLevel = upgradeDomainService.calculateUpgradeItem(upgradeLevel);
        assertEquals(upgradeLevel+1, afterUpgradeItemLevel);
    }




}
