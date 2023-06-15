package com.ohgiraffers.metaRPG.application.dto;


import lombok.*;


public class MonsterDTO  {
    // 사냥터 입력 값 받아서 hp,공격력,보상 계산
    private String name;
    private int hp;
    private int strikingPower;
    private int experiencePoint;
    private int money;

    public MonsterDTO(String name, int hp, int strikingPower, int experiencePoint, int money) {
        this.name = name;
        this.hp = hp;
        this.strikingPower = strikingPower;
        this.experiencePoint = experiencePoint;
        this.money = money;
    }



}
