package com.ohgiraffers.metaRPG.domain.entity;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonsterEntity {
    private int sequence;
    private String name;
    private int hp;
    private int strikingPower;
    private int experiencePoint;
    private int money;
}
