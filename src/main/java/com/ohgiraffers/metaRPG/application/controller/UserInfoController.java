package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("UserInfoController")
public class UserInfoController {

    private UserInfoService userInfoService;

    @Autowired
    private UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


}

