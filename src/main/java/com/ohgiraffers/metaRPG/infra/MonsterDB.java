package com.ohgiraffers.metaRPG.infra;


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
        this.monsterList.put(1, new MonsterEntity("칼날부리", 100, 100, 1, 1));
        this.monsterList.put(2, new MonsterEntity("어스름 늑대", 1000, 1000, 10, 10));
        this.monsterList.put(3, new MonsterEntity("돌거북", 10000, 10000, 100, 100));
        this.monsterList.put(4, new MonsterEntity("심술 두꺼비", 100000, 100000, 1000, 1000));
        this.monsterList.put(5, new MonsterEntity("협곡 바위게", 1000000, 1000000, 10000, 10000));
    }


    public List<MonsterEntity> findAllMonster(){
        return new ArrayList<>(monsterList.values());
    }

    public MonsterEntity findMonsterBySequence(int sequence){
        return monsterList.get(sequence);
    }
}
