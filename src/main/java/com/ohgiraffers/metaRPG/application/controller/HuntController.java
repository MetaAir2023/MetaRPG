package com.ohgiraffers.metaRPG.application.controller;

import com.ohgiraffers.metaRPG.application.Service.HuntApplicationService;
import com.ohgiraffers.metaRPG.application.dto.MonsterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("HuntController")
public class HuntController {

    private HuntApplicationService huntApplicationService;

    @Autowired
    private HuntController(HuntApplicationService huntApplicationService){
        this.huntApplicationService = huntApplicationService;
    }

    public MonsterDTO initMonster(int sequence, int selectedFieldNumber){
        return huntApplicationService.initMonsterDTO(sequence, selectedFieldNumber);
    }

    //전투 시작 전, 유효한 전투인지 검증하는 메소드 (추후 유저 DTO/컨트롤러 추가되면 로직 수정 고고)
    public boolean checkValidBattle(MonsterDTO monsterDTO, int userHP, int userATK){
        if(monsterDTO.getHp() > userATK * 10)
            return false;
        else if(monsterDTO.getStrikingPower() > userHP * 3)
            return false;
        return true;
    }
    
    public MonsterDTO attackToMonster(MonsterDTO monsterDTO, int userATK){
        int monsterHP = huntApplicationService.hunt(true, monsterDTO.getHp(), monsterDTO.getStrikingPower(), 0, userATK);
        monsterDTO.setHp(monsterHP);
        return monsterDTO;
    }

    public int calculateMonsterHP(MonsterDTO monsterDTO){
        return huntApplicationService.getHpPercent(monsterDTO.getHp(), huntApplicationService.findMonsterHpBySequence(monsterDTO.getSequence()));
    }

    public int getMonsterHP(int sequence){
        return huntApplicationService.getMonsterHp(sequence);
    }

    //이것 역시 user단에서 해야함 (임시)
    public int calculateUserHP(int userHp, int userMaxHp){
        return huntApplicationService.getHpPercent(userHp, userMaxHp);
    }

    //userDTO 생기면 userDTO로 바꿀 필요가 있음.
    public int hitFromMonster(MonsterDTO monsterDTO, int userHP){
        int afterUserHP = huntApplicationService.hunt(false, monsterDTO.getHp(), monsterDTO.getStrikingPower(), userHP, 0);
        return afterUserHP;
    }

    //이 메소드 아래의 두 메소드들은 userDTO가 있다면 ..? 하나로 통합 하기 .. ? ?
//    public UserDTO receiveReward(UserDTO userDTO, MonsterDTO monsterDTO){
//        userDTO.setLevel(userDTO.getLevel() + monsterDTO.getExperiencePoint());
//        userDTO.setMoney(userDTO.getMoney() + monsterDTO.getMoney());
//        return userDTO;
//    }
//    public int expReward(MonsterDTO monsterDTO){
//        return monsterDTO.getExperiencePoint();
//    }
//    public int moneyReward(MonsterDTO monsterDTO){
//        return monsterDTO.getMoney();
//    }




}
