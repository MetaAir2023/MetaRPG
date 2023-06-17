package com.ohgiraffers.metaRPG.application.Service;


import com.ohgiraffers.metaRPG.application.dto.MonsterDTO;
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

    @Autowired
    public HuntApplicationService(HuntDomainService huntDomainService,
                                  UserRepository userRepository,
                                  MonsterRepository monsterRepository){
        this.huntDomainService = huntDomainService;
        this.userRepository = userRepository;
        this.monsterRepository = monsterRepository;
    }

    public MonsterDTO initMonsterDTO(int sequence, int field){
        //밸런스 조절은 field값으로..?
        MonsterEntity monster = monsterRepository.searchMonsterBySequence(sequence);
        return new MonsterDTO(sequence, monster.getName(), monster.getHp(), monster.getStrikingPower(), monster.getExp(), monster.getMoney());
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

    public int[] gainReward(MonsterEntity monster){
        int[] reward = new int[2];
        reward[0] = huntDomainService.gainEXP(monster);
        reward[1] = huntDomainService.gainMoney(monster);
        return reward;
    }

    public int findMonsterHpBySequence(int sequence){
        return monsterRepository.getMonsterMaxHP(sequence);
    }






}
