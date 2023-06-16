package com.ohgiraffers.metaRPG.domain.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserEntity {
    private int sequence;
    private String name;
    private int hp;
    private int str;
    private int level;
    private int money;
    private int itemSequence;
    private int itemUpLv;
}
