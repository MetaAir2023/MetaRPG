package com.ohgiraffers.metaRPG.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserInfoService")
public class UserInfoService {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public int sequence(int sequence) {

        return userInfoService.sequence(sequence);
    }




}
