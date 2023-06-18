package com.ohgiraffers.metaRPG.domain.service;

import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HuntDomainService {













    public int attack(int HP, int power){
        return HP - power;
    }

    // 현재 hp 백분율로 환산
    public int hpCalc(int hp, int maxhp) {
        int hpPercent = (int)((hp / (double) maxhp) * 100);
        return hpPercent;
    }



    // 돈 적립 메소드 // flag 사냥 성공 여부
    public int gainMoney(int uMoney, int mMoney){
        return uMoney + mMoney;
    }





}
