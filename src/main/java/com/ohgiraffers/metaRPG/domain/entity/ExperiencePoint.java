package com.ohgiraffers.metaRPG.domain.entity;

public class ExperiencePoint {

    int value;
    public ExperiencePoint(int value) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }

    }
}
