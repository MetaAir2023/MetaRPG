package com.ohgiraffers.metaRPG.application.dto;

import lombok.*;

public class UserDTO {

    private String name;
    private int hp;
    private int str;
    private int level;
    private int money;
    private int itemSequence;
    private int itemUpLv;

    public UserDTO(String name, int hp, int str, int level, int money, int itemSequence, int itemUpLv) {
        this.name = name;
        this.hp = hp;
        this.str = str;
        this.level = level;
        this.money = money;
        this.itemSequence = itemSequence;
        this.itemUpLv = itemUpLv;

    }




}
