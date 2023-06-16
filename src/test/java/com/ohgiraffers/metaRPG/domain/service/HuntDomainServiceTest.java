package com.ohgiraffers.metaRPG.domain.service;

import com.ohgiraffers.metaRPG.ContextConfiguration;
import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class HuntDomainServiceTest {
    @Autowired
    private HuntDomainService huntDomainService;
    @Test
    public void setCreateHuntDomainService(){
        assertNotNull(huntDomainService);
    }
    @Test
    @DisplayName("유저가 기본 공격으로 몬스터를 공격했을 경우, 몬스터의 나머지 체력 확인")
    public void testAttack(){
        MonsterEntity monster = new MonsterEntity(1, "빨간 달팽이", 20, 5, 5, 15);
        UserEntity user = new UserEntity(1, "유저1", 100, 10, 1, 0, 0, 0);
        boolean flag = true;
        int restMonsterHp = huntDomainService.attack(flag, monster, user);
        assertEquals(10, restMonsterHp);
    }

    @Test
    @DisplayName("몬스터가 유저를 공격할 경우, 유저의 나머지 체력 확인")
    public void testDefence(){
        MonsterEntity monster = new MonsterEntity(1, "빨간 달팽이", 20, 5, 5, 15);
        UserEntity user = new UserEntity(1, "유저1", 100, 10, 1, 0, 0, 0);
        boolean flag = false;
        int restUserHp = huntDomainService.attack(flag, monster, user);
        assertEquals(95, restUserHp);
    }

    @Test
    @DisplayName("2번 피격당한 유저의 현재 HP를 퍼센트로 변환하여 값 Check")
    public void testHpCalc(){
        MonsterEntity monster = new MonsterEntity(1, "빨간 달팽이", 20, 5, 5, 15);
        UserEntity user = new UserEntity(1, "유저1", 100, 10, 1, 0, 0, 0);
        boolean flag = false;
        int userMaxHp = 100;
        int userCurHp = huntDomainService.attack(flag, monster, user);
        user.setHp(userCurHp);
        userCurHp = huntDomainService.attack(flag, monster, user);
        int hpPer = huntDomainService.hpCalc(userCurHp, userMaxHp);
        assertEquals(90, hpPer);
    }

    @Test
    @DisplayName("경험치 받는 메소드 Test")
    public void testGainEXP(){
        MonsterEntity monster = new MonsterEntity(1, "빨간 달팽이", 20, 5, 5, 15);
        boolean flag = true;
        int exp = huntDomainService.gainEXP(flag, monster);
        assertEquals(5, exp);
    }

    @Test
    @DisplayName("사냥 실패시 돈 적립 메소드 Test")
    public void testGainMoney(){
        MonsterEntity monster = new MonsterEntity(1, "빨간 달팽이", 20, 5, 5, 15);
        boolean flag = false;
        int money = huntDomainService.gainEXP(flag, monster);
        assertEquals(0, money);
    }

    @Test
    @DisplayName("체력바")
    public void printHpBar(){
        int hpPer = 22;
        System.out.println(huntDomainService.makeHpBar(hpPer));
    }

}
