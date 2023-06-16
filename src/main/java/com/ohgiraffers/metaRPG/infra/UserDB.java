package com.ohgiraffers.metaRPG.infra;

import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDB {

    private final Map<String, UserEntity> userList;

    public UserDB() {
        this.userList = new HashMap<>();
        this.userList.put("소드마스터", new UserEntity(1, "소드마스터", 1000, 1,1, 5000, 1, 1));
    }

    public List<UserEntity> findAllUsers() {

        return new ArrayList<>(userList.values());
    }

    public UserEntity findUserBySequence(int sequence) {

        return userList.get(sequence);
    }

    public UserEntity findUserByName(String name) {

        return userList.get(name);
    }
}
