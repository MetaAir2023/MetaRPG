package com.ohgiraffers.metaRPG.infra;


import com.ohgiraffers.metaRPG.domain.entity.ExperiencePoint;
import com.ohgiraffers.metaRPG.domain.entity.Money;
import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MonsterDB {
    private final Map<Integer, MonsterEntity> monsterList;

    public MonsterDB(){
        this.monsterList = new HashMap<>();
        this.monsterList.put(1, new MonsterEntity(1,"칼날부리", 1, 1, 1, 1));
        this.monsterList.put(2, new MonsterEntity(2,"어스름 늑대", 10, 10, 10, 10));
        this.monsterList.put(3, new MonsterEntity(3,"돌거북", 100, 100, 100, 100));
        this.monsterList.put(4, new MonsterEntity(4,"심술 두꺼비", 1000, 1000, 1000, 1000));
        this.monsterList.put(5, new MonsterEntity(5,"협곡 바위게", 10000, 10000, 10000, 10000));
    }


    public List<MonsterEntity> findAllMonster(){
        return new ArrayList<>(monsterList.values());
    }

    public MonsterEntity findMonsterBySequence(int sequence){
        return monsterList.get(sequence);
    }


}
