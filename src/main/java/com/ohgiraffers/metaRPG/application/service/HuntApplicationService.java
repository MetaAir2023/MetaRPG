package com.ohgiraffers.metaRPG.application.service;


import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.domain.service.HuntDomainService;
import org.springframework.stereotype.Service;

@Service
public class HuntApplicationService {

    private HuntDomainService huntDomainService;


    public int hunt(boolean flag, MonsterEntity monster, UserEntity user){
        if(flag){
           return huntDomainService.attack(flag,monster,user);
        }
        else return huntDomainService.attack(flag,monster,user);

    }

    public int[] gainReward(boolean flag, MonsterEntity monster){
        int[] reward = new int[2];
        reward[0] = huntDomainService.gainEXP(flag, monster);
        reward[1] = huntDomainService.gainMoney(flag, monster);
        return reward;
    }






}