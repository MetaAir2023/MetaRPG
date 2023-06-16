package com.ohgiraffers.metaRPG.infra;

import com.ohgiraffers.metaRPG.domain.entity.ItemEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDB {

    private final Map<Integer, ItemEntity> itemList;

    public ItemDB() {
        this.itemList = new HashMap<>();
        this.itemList.put(1, new ItemEntity(1,"무한의 대검", 3));
        this.itemList.put(2, new ItemEntity(2,"BF 대검", 2));
        this.itemList.put(3, new ItemEntity(3,"롱소드", 1));
        this.itemList.put(4, new ItemEntity(4,"도란의 검", 1));
    }

    public List<ItemEntity> findAllItems() {

        return new ArrayList<>(itemList.values());
    }

    public ItemEntity findItemBySequence(int sequence) {

        return itemList.get(sequence);
    }
}
