package com.ohgiraffers.metaRPG.domain.entity;


import lombok.*;

public class MonsterEntity {
    private int sequence;
    private String name;
    private int hp;
    private int strikingPower;
    private ExperiencePoint exp;
    private Money money;

//    validateNegativeExp(experiencePoint);

    public MonsterEntity(int sequence ,String name, int hp, int strikingPower, int exp, int money) {
        this.sequence = sequence;
        this.name = name;
        this.hp = hp;
        this.strikingPower = strikingPower;
        this.exp = new ExperiencePoint(exp);
        this.money = new Money(money);
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStrikingPower() {
        return strikingPower;
    }

    public int getMoney() {
        return this.money.value;
    }

    public int getExp() {
        return this.exp.value;
    }
}
