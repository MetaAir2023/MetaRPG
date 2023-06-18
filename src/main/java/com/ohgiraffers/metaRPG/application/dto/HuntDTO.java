package com.ohgiraffers.metaRPG.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HuntDTO {
    private int userHp;
    private int monsterHp;
    private int userMaxHp;
    private int monsterMaxHp;
    private int userTotalStr;
    private int monsterStr;



}
