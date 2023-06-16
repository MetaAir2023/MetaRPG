package com.ohgiraffers.metaRPG.domain.entity;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ExperiencePoint {

    int value;
    public ExperiencePoint(int value) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }else {
            this.value =value;
        }

    }
}
