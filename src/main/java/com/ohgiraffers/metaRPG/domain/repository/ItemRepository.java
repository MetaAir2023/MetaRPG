package com.ohgiraffers.metaRPG.domain.repository;

import com.ohgiraffers.metaRPG.domain.entity.ItemEntity;
import com.ohgiraffers.metaRPG.infra.ItemDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    private final ItemDB itemDB;

    @Autowired
    public ItemRepository(ItemDB itemDB) {
        this.itemDB = itemDB;
    }

    public List<ItemEntity> findAllItems() {
        return itemDB.findAllItems();
    }

    public ItemEntity searchItemBySequence(int sequence) {
        return itemDB.findItemBySequence(sequence);
    }
    public Integer getItemTier(int sequence) {
        return itemDB.findItemBySequence(sequence).getTier();
    }

}
