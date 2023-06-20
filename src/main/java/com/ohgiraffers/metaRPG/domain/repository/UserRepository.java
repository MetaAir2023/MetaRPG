package com.ohgiraffers.metaRPG.domain.repository;

import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.infra.UserDB;
import org.springframework.stereotype.Repository;


@Repository
public class  UserRepository {

    private static final UserDB userDB;

    static {
        userDB = new UserDB();
    }

    public UserEntity findUserBySequence(int sequence) { return userDB.findUserBySequence(sequence); }
    public UserEntity findUserByName(String name) { return userDB.findUserByName(name); }
    public int showMoney(String name){
        return userDB.findUserByName(name).getMoney();
}
    public int showItemSequence(String name){
        return userDB.findUserByName(name).getItemSequence();
}

}
