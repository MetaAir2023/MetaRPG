package com.ohgiraffers.metaRPG.domain.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemEntity {
    private int sequence;
    private String name;
    private int attackScore;
    private int tier;
}
