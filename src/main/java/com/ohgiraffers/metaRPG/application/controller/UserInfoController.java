package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.Service.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserInfoController {

    private final UserApplicationService userApplicationService;

    @Autowired
    private UserInfoController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }
}

