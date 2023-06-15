package com.ohgiraffers.metaRPG.domain.service;

import org.springframework.stereotype.Service;

@Service
public class HuntService {
    int userMaxHp;
    int monsterMaxHp;
    int userHp;
    int monsterHp;
    int userSTR;
    int monsterSTR;
    int userEXP;
    int monsterEXP;
    int userMoney;
    int monsterMoney;


    public void huntSetting(int userHp,int monsterHp, int userSTR, int monsterSTR){
        this.userHp = userHp;
        this.userSTR = userSTR;
        this.monsterHp = monsterHp;
        this.monsterSTR = monsterSTR;
        this.userMaxHp = userHp;
        this.monsterMaxHp = monsterHp;


        //초기 상태
    }

    public void hunt(int num){

    }



    // 유저 선공 몬스터 후공
    // 유저 선공에서 끝날 시 전투 종료
    // 몬스터 후공에서 끝날 시 전투 종료

    // 전투 한번 주고 받기
    public int attack(){
        this.monsterHp  -= this.userSTR;
        return this.monsterHp;
    }
    public int defence(){

        this.userHp -= this.monsterSTR;
        return this.userHp;
    }
    // 현재 hp 출력 메소드
    public int hpCalc(int hp, int maxhp) {
        int hpPercent = (hp / maxhp) * 100;
        return hpPercent;
    }

    //경험치 받는 메소드
    public int getEXP(){
        this.userEXP += this.monsterEXP;
        return this.userEXP;
    }


    // 돈 적립 메소드
    public int getMoney(){
        this.userMoney += this.monsterMoney;
        return userMoney;
    }



}
