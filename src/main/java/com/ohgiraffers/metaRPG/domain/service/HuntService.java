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

    public void hunt(){

    }



    // 유저 선공 몬스터 후공
    // 유저 선공에서 끝날 시 전투 종료
    // 몬스터 후공에서 끝날 시 전투 종료

    // 전투 한번 주고 받기
    public void attack(){
        this.monsterHp = this.monsterHp - this.userSTR;
        monsterHpCalc(this.monsterHp);

        this.userHp = this.userHp - this.monsterSTR;
        userhpcalc(this.userHp);


    }
    // 현재 hp 출력 메소드
    public void userhpcalc(int userHp){

    }
    public void monsterHpCalc(int monsterHp){

    }

    //경험치 받는 메소드
    public void getEXP(){
        this.userEXP += this.monsterEXP;
    }


    // 돈 적립 메소드
    public void getMoney(){
        this.userMoney += this.monsterMoney;
    }



}
