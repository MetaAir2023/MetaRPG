package com.ohgiraffers.metaRPG.application.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonsterDTO  {
    // 사냥터 입력 값 받아서 hp,공격력,보상 계산
    private String name;
    private int hp;
    private int strikingPower;
    private int experiencePoint;
    private int money;

}
