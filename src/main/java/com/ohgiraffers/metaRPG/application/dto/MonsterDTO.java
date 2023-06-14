package com.ohgiraffers.metaRPG.application.dto;

import com.ohgiraffers.metaRPG.application.DTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonsterDTO implements DTO {

    private String name;
    private int hp;
    private int strikingPower;
    private int experiencePoint;
    private int money;


//    private MonsterDTO(String monsterName, int monsterHP, int monsterStrikingPower, int experiencePoint, int money){
//
//        this.monsterName = monsterName;
//        this.monsterHP = monsterHP;
//        this.monsterStrikingPower = monsterStrikingPower;
//        this.experiencePoint = experiencePoint;
//        this.money = money;
//    }


}
