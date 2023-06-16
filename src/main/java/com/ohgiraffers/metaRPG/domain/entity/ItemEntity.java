package com.ohgiraffers.metaRPG.domain.entity;


public class ItemEntity {
    private int sequence;
    private String name;
    private int tier;

    public ItemEntity(int sequence, String name, int tier) {
        this.sequence = sequence;
        this.name = name;
        this.tier = tier;
    }

    public ItemEntity get() {
        return this;
    }

    public Integer getTier() {
        return this.tier;
    }

    public String getName() {
        return this.name;
    }

}
