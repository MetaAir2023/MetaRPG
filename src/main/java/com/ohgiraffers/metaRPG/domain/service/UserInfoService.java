package com.ohgiraffers.metaRPG.domain.service;

import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserInfoService")
public class UserInfoService {

    private final UserRepository userRepository;

    @Autowired
    public UserInfoService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public UserEntity sequence(int sequence) {

        return userRepository.findUserBySequence(sequence);
    }
}
