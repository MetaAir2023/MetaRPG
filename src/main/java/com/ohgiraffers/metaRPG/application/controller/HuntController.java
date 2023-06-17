package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.Service.HuntApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("HuntController")
public class HuntController {

    private HuntApplicationService huntApplicationService;

    @Autowired
    private HuntController(HuntApplicationService huntApplicationService){
        this.huntApplicationService = huntApplicationService;
    }
}
