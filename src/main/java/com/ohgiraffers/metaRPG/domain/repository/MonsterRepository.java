package com.ohgiraffers.metaRPG.domain.repository;


import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import com.ohgiraffers.metaRPG.infra.MonsterDB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MonsterRepository {

    private static final MonsterDB monsterDB = new MonsterDB();



    public List<MonsterEntity> findAllMonsters(){
        return monsterDB.findAllMonster();
    }
    public MonsterEntity searchMonsterBySequence(int sequence){
        return monsterDB.findMonsterBySequence(sequence);
    }


    public String getMonsterName(int sequence){
        return monsterDB.findMonsterBySequence(sequence).getName();
    }

    public int getMonsterMaxHP(int sequence){return monsterDB.findMonsterBySequence(sequence).getHp();}




}
