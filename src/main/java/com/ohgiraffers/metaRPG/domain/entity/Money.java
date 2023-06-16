package com.ohgiraffers.metaRPG.domain.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Money {

    int value;
    public Money(int value) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }

    }


}
