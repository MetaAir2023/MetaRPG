package com.ohgiraffers.metaRPG.domain.repository;

import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.infra.UserDB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private static final UserDB userDB;

    static {
        userDB = new UserDB();
    }

    public List<UserEntity> findAllUsers() { return userDB.findAllUsers(); }
    public UserEntity findUserBySequence(int sequence) { return userDB.findUserBySequence(sequence); }
    public UserEntity findUserByName(String name) { return userDB.findUserByName(name); }

}
