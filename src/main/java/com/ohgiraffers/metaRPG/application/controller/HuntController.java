package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.Service.HuntApplicationService;
import com.ohgiraffers.metaRPG.application.Service.UpgradeApplicationService;
import com.ohgiraffers.metaRPG.application.dto.HuntDTO;
import com.ohgiraffers.metaRPG.application.dto.MonsterDTO;
import com.ohgiraffers.metaRPG.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("HuntController")
public class HuntController {

    private HuntApplicationService huntApplicationService;

    private UpgradeApplicationService upgradeApplicationService;

    @Autowired
    private HuntController(HuntApplicationService huntApplicationService, UpgradeApplicationService upgradeApplicationService){
        this.huntApplicationService = huntApplicationService;
        this.upgradeApplicationService = upgradeApplicationService;
    }

    public MonsterDTO initMonster(int sequence){
        return huntApplicationService.initMonsterDTO(sequence);
    }
    public UserDTO initUser(int sequence){
        return huntApplicationService.initUserDTO(sequence);
    }
    public HuntDTO initHunt(UserDTO userDTO, MonsterDTO monsterDTO){
        return huntApplicationService.inithuntDTO(userDTO, monsterDTO);
    }


    public boolean checkValidBattle(MonsterDTO monsterDTO, UserDTO userDTO){
        int userTotSTR = upgradeApplicationService.userTotalStrikingPower(userDTO.getSequence());

        if( (monsterDTO.getHp() / userTotSTR) >  (userDTO.getHp() / monsterDTO.getStrikingPower())) {
            return false;}

        return true;
    }
    
    public MonsterDTO attackToMonster(MonsterDTO monsterDTO, int userATK){
        int monsterHP = huntApplicationService.hunt(true, monsterDTO.getHp(), monsterDTO.getStrikingPower(), 0, userATK);
        monsterDTO.setHp(monsterHP);
        return monsterDTO;
    }

    public int calculateMonsterHP(HuntDTO huntDTO, MonsterDTO monsterDTO){
        return huntApplicationService.getHpPercent(huntDTO.getMonsterHp(), huntApplicationService.findMonsterHpBySequence(monsterDTO.getSequence()));
    }

    public int getMonsterHP(int sequence){
        return huntApplicationService.getMonsterHp(sequence);
    }


    public int calculateUserHP(int userHp, int userMaxHp){
        return huntApplicationService.getHpPercent(userHp, userMaxHp);
    }


    public int hitFromMonster(MonsterDTO monsterDTO, int userHP){
        int afterUserHP = huntApplicationService.hunt(false, monsterDTO.getHp(), monsterDTO.getStrikingPower(), userHP, 0);
        return afterUserHP;
    }

    public void getReward(UserDTO userDTO, MonsterDTO monsterDTO){
        huntApplicationService.calcRewardAndSave(userDTO.getSequence(),userDTO.getMoney(), monsterDTO.getMoney());
    }







}
