package com.ohgiraffers.metaRPG.application.Service;


import com.ohgiraffers.metaRPG.application.dto.HuntDTO;
import com.ohgiraffers.metaRPG.application.dto.MonsterDTO;
import com.ohgiraffers.metaRPG.application.dto.UserDTO;
import com.ohgiraffers.metaRPG.domain.entity.MonsterEntity;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.domain.repository.ItemRepository;
import com.ohgiraffers.metaRPG.domain.repository.MonsterRepository;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import com.ohgiraffers.metaRPG.domain.service.HuntDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuntApplicationService {

    private final HuntDomainService huntDomainService;

    private final UserRepository userRepository;
    private final MonsterRepository monsterRepository;
    private final UpgradeApplicationService upgradeApplicationService;
    @Autowired
    public HuntApplicationService(HuntDomainService huntDomainService,
                                  UserRepository userRepository,
                                  MonsterRepository monsterRepository,
                                  UpgradeApplicationService upgradeApplicationService){
        this.huntDomainService = huntDomainService;
        this.userRepository = userRepository;
        this.monsterRepository = monsterRepository;
        this.upgradeApplicationService = upgradeApplicationService;
    }

    public MonsterDTO initMonsterDTO(int sequence){
        //밸런스 조절은 field값으로..?
        MonsterEntity monster = monsterRepository.searchMonsterBySequence(sequence);
        return new MonsterDTO(sequence, monster.getName(), monster.getHp(), monster.getStrikingPower(), monster.getExp(), monster.getMoney());
    }
    public UserDTO initUserDTO(int sequence) {
        UserEntity user = userRepository.findUserBySequence(sequence);
        return new UserDTO(sequence, user.getName(), user.getHp(), user.getStr(), user.getMoney(), user.getItemSequence(), user.getItemUpLv());
    }
    public HuntDTO inithuntDTO(UserDTO userDTO, MonsterDTO monsterDTO){
        int userTotSTR = upgradeApplicationService.userTotalStrikingPower(userDTO.getSequence());
        return new HuntDTO(userDTO.getHp(),monsterDTO.getHp(), userDTO.getHp(), monsterDTO.getHp()
        , userTotSTR, monsterDTO.getStrikingPower());
    }
    public int getMonsterHp(int sequence){
        return monsterRepository.getMonsterMaxHP(sequence);
    }

//    public int hunt(boolean flag, MonsterEntity monster, UserEntity user){
    public int hunt(boolean flag, int monsterHp, int monsterATK, int userHP, int userATK){
        if(flag){
           return huntDomainService.attack(monsterHp, userATK);
        }
        else return huntDomainService.attack(userHP, monsterATK);
    }

    public int getHpPercent(int curHP, int maxHP){
        return huntDomainService.hpCalc(curHP, maxHP);
    }

//    public int[] gainReward(MonsterEntity monster){
//        int[] reward = new int[2];
//        reward[0] = huntDomainService.gainEXP(monster);
//        reward[1] = huntDomainService.gainMoney(monster);
//        return reward;
//    }

    public int findMonsterHpBySequence(int sequence){
        return monsterRepository.getMonsterMaxHP(sequence);
    }

    public int calcRewardAndSave(int userSequence, int userMoney, int monsterMoney) {
        int balance = huntDomainService.gainMoney(userMoney, monsterMoney);
        return userRepository.findUserBySequence(userSequence).setMoney(balance);
    }

}

