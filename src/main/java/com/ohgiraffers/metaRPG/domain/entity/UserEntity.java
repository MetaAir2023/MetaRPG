package com.ohgiraffers.metaRPG.domain.entity;


public class UserEntity {
    private int sequence;
    private String name;
    private int hp;
    private int str;
    private int money;
    private int itemSequence;
    private int itemUpLv;
    public UserEntity(int sequence, String name,
                      int hp, int str, int money,
                      int itemSequence,
                      int itemUpLv
    ) {
        this.sequence = sequence;
        this.name = name;
        this.hp = hp;
        this.str = str;
        this.money = money;
        this.itemSequence = itemSequence;
        this.itemUpLv = itemUpLv;
    }

    public Integer getSequence() {
        return this.sequence;
    }

    public String getName() {
        return this.name;
    }
    public Integer getHp() {
        return this.hp;
    }
    public Integer getStr() {
        return this.str;
    }
    public Integer getMoney() {
        return this.money;
    }
    public Integer getItemSequence() {
        return this.itemSequence;
    }
    public Integer getItemUpLv() {
        return this.itemUpLv;
    }


    // set 메서드를 Entity 클래스의 메서드로 처리해도 되는지 강사님께 질문
    public Integer setMoney(int money) {
        this.money = money;
        return this.money;
    }

    public Integer setItemUpLv(int upgradeLevel) {
        this.itemUpLv = upgradeLevel;
        return this.itemUpLv;
    }
}
