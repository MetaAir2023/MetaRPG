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

    public Integer getSequence() {
        return this.sequence;
    }

    public Integer getTier() {
        return this.tier;
    }

    public String getName() {
        return this.name;
    }

    public int getItemUpdateCost(int tier) {
        int itemUpgradeCost = 0;
        switch (tier) {
            case 1 : itemUpgradeCost = 1000; break;
            case 2 : itemUpgradeCost = 2000; break;
            case 3 : itemUpgradeCost = 3000; break;
        }
        return itemUpgradeCost;
    }
}
