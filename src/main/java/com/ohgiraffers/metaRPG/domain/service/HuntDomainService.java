package com.ohgiraffers.metaRPG.domain.service;

import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class HuntDomainService {








    // 유저 선공 몬스터 후공
    // 유저 선공에서 끝날 시 전투 종료
    // 몬스터 후공에서 끝날 시 전투 종료

    // 전투 한번 주고 받기 // flag 로 선후공 판단
    public int attack(boolean flag ,MonsterEntity monster, UserEntity user){
        if (flag){
            return monster.getHp() - user.getStr();
        }
        return user.getHp() - monster.getStrikingPower();


    }

    // 현재 hp 백분율로 환산
    public int hpCalc(int hp, int maxhp) {
        int hpPercent = (int)((hp / (double) maxhp) * 100);
        return hpPercent;
    }

    //경험치 받는 메소드 // flag 사냥 성공 여부
    public int gainEXP(boolean flag, MonsterEntity monster){
        if (flag){
            return monster.getExp();
        }
        return 0;
    }


    // 돈 적립 메소드 // flag 사냥 성공 여부
    public int gainMoney(boolean flag, MonsterEntity monster){
        if (flag){
            return monster.getMoney();
        }
        return 0;

    }



}
