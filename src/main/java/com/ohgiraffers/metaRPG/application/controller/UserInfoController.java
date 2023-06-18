package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.Service.UserApplicationService;
import com.ohgiraffers.metaRPG.application.dto.UserDTO;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserInfoController {

    private UserApplicationService userApplicationService;

    @Autowired
    private UserInfoController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    public UserDTO initUserDTO(String userName) {
        return userApplicationService.initUserDTO(userName);
    }

    public showUserDTO showUserInfo(String userName) {
        UserEntity userEntity = UserApplicationService.

    }



}

