package com.ohgiraffers.metaRPG.infra;

import com.ohgiraffers.metaRPG.domain.entity.ItemEntity;
import org.springframework.stereotype.Component;
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
        this.itemList.put(1, new ItemEntity(1,"무한의 대검", 100, 1));
    }

    public List<ItemEntity> findAllItems() {

        return new ArrayList<>(itemList.values());
    }

    public ItemEntity findItemBySequence(int sequence) {

        return itemList.get(sequence);
    }
}
