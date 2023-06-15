package com.ohgiraffers.metaRPG.domain.service;

import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class HuntDomainService {








    // 유저 선공 몬스터 후공
    // 유저 선공에서 끝날 시 전투 종료
    // 몬스터 후공에서 끝날 시 전투 종료

    // 전투 한번 주고 받기
    public int attack(boolean flag ,MonsterEntity monster, UserEntity user){
        if (flag){
            return monster.getHp() - user.getStr();
        }
        return user.getHp() - monster.getStrikingPower();


    }

    // 현재 hp 출력 메소드
    public int hpCalc(int hp, int maxhp) {
        int hpPercent = (hp / maxhp) * 100;
        return hpPercent;
    }

    //경험치 받는 메소드
    public int gainEXP(boolean flag, MonsterEntity monster){
        if (flag){
            return monster.getExperiencePoint();
        }
        return 0;
    }


    // 돈 적립 메소드
    public int gainMoney(boolean flag, MonsterEntity monster){
        if (flag){
            return monster.getMoney();
        }
        return 0;

    }



}
