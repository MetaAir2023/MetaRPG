package com.ohgiraffers.metaRPG.application;

import com.ohgiraffers.metaRPG.BGM;
import com.ohgiraffers.metaRPG.application.controller.HuntController;
import com.ohgiraffers.metaRPG.application.controller.UpgradeController;
import com.ohgiraffers.metaRPG.application.dto.MonsterDTO;
import com.ohgiraffers.metaRPG.application.dto.item.ShowUserItemDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeItemDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@Component
public class View {

    private final UpgradeController upgradeController;

    private final HuntController huntController;
    private final Scanner sc = new Scanner(System.in);
    @Autowired
    public View(UpgradeController upgradeController, HuntController huntController) {
        this.upgradeController = upgradeController;
        this.huntController = huntController;
    }

    public void setGame() {
        BGM bgm = new BGM();
        bgm.setDaemon(true);
        bgm.start();
        System.out.print("사용자의 이름을 입력해주세요 : ");
        String userName = sc.next();
        boolean gameRun = true;
        while(gameRun){
            System.out.println("1. 게임시작");
            System.out.println("2. 전투하기");
            System.out.println("3. 게임종료");
            System.out.print("메뉴를 선택해주세요(숫자로) : ");
            int select = sc.nextInt();
            switch(select){
                case 1:
                    upgradeRun(userName);
                    break;
                case 2:
                    huntRun();
                    break;
                case 3:
                    gameRun = false;
                    break;
            }
        }
    }

    private void huntRun(){
        System.out.println(">> 필드를 선택하세요. <<");
        System.out.println("1. 칼날 부리의 둥지");
        System.out.println("2. 어스름 늑대의 소굴");
        System.out.println("3. 돌거북의 잠자리");
        System.out.println("4. 심술 두꺼비의 은밀한 장소");
        System.out.println("5. 바위게의 협곡 모험");
        System.out.println("필드 숫자 입력 : ");
        int fieldNum = sc.nextInt();
        //시퀸스, 필드 숫자 입력 받음 (임시)
        try {
            MonsterDTO monster = setMonster(fieldNum, fieldNum);
//            int monsterMaxHP = huntController.getMonsterHP(fieldNum);
            //유저 데이터 (임시) DTO 요구
            int userHp = 100;
            int userMaxHp = 100;
            int userATK = 2; //유저 공격력에 무기 강화 수치 값 추가 해야함
            if(!huntController.checkValidBattle(monster, userHp, userATK)){
                System.out.println("(경고) 현재 능력치로는 전투하기 어려운 몬스터입니다.");
                return;
            }
            while(true){
                System.out.println("\n" + monster.getName());
                System.out.println("HP : (" + monster.getHp() + "/" + huntController.getMonsterHP(fieldNum) + ")");
                System.out.println(makeHpBar(huntController.calculateMonsterHP(monster)));
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("유저 이름 : ㅇㅇ");
                System.out.println("HP : (" + userHp + "/" + userMaxHp + ")");
                System.out.println(makeHpBar(huntController.calculateUserHP(userHp, userMaxHp)));
                System.out.println("1. 공격하기");
                System.out.println("2. 도망가기");
                System.out.println("메뉴 선택 : ");
                int select = sc.nextInt();
                if(select == 1){
                    monster = huntController.attackToMonster(monster, userATK);
                    System.out.println(monster.getName() + "에게 " + userATK + "의 피해를 입혔습니다 ! !");
                    if(monster.getHp() <= 0){
                        System.out.println(monster.getName() + "가 쓰러졌습니다!");
                        getReward(monster);
                        break;
                    }
                    userHp = huntController.hitFromMonster(monster, userHp);
                    System.out.println(monster.getName() + "로부터 " + userATK + "의 피해를 입었습니다 ! !");

                    if(userHp <= 0){
                        System.out.println("(유저)가 죽었습니다!");
                        System.out.println("마을로 돌아갑니다.");
                        return;
                    }
                }else{
                    System.out.println("전투 종료");
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage().toString());
        }
    }

    private void getReward(MonsterDTO monster){
        //유저 DTO를 받아서 저장하는 게 필요 함 ..
        //ex userDTO.setLevel(userDTO.getLevel() + monsterDTO.getExp . . .이런거)
        System.out.println(">> 보상 페이지 <<");
        System.out.println("골드 : " + monster.getMoney());
        System.out.println("경험치 : " + monster.getExperiencePoint());
    }

    private void upgradeRun(String userName) {

        boolean run = true;
        while (run) {
            System.out.println("1. 강화하기");
            System.out.println("2. 취소");
            System.out.print("메뉴 선택(숫자로) : ");
            int select = sc.nextInt();
            if (select == 1) {
                try {
                    UpgradeItemDTO setUpgradeItem = setUpgradeItem(userName);
                    startUpgrade(setUpgradeItem);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage().toString());
                }
            } else {
                run = false;
            }
        }
    }
    private UpgradeItemDTO setUpgradeItem(String userName) {
            ShowUserItemDTO userItem = upgradeController.showUserItem(userName);
            System.out.println("사용자가 보유 중인 아이템은 "
                    +userItem.getItemSequence() + ".  "
                    +userItem.getItemName() + "입니다."
                    + "\n"
            );

            System.out.print("업데이트할 아이템의 번호를 입력하세요 : ");
            int upgradeItemInput = sc.nextInt();

            if (upgradeItemInput != userItem.getItemSequence()) {
                System.out.println("아이디를 잘못 입력하였습니다.");
            }
            UpgradeItemDTO upgradeSet = upgradeController.initUpgrade(userName);

            System.out.println("사용자가 보유 중인 금액 :"
                    + upgradeSet.getUserMoney() + " / "
                    + "강화 비용 :"
                    + upgradeSet.getUpgradeCost()
                    + "\n"
            );
            return upgradeSet;
        }

    private MonsterDTO setMonster(int sequence, int fieldNum){
        MonsterDTO monsterDTO = huntController.initMonster(sequence, fieldNum);

        return monsterDTO;
    }

    private void startUpgrade(UpgradeItemDTO upgradeItemDTO) {
        UpgradeItemDTO result = upgradeItemDTO;
        boolean checkUpgrade = upgradeController.checkUpgrade(upgradeItemDTO);
        if (!checkUpgrade) {
            //System.out.println("강화 비용이 부족합니다!");
            throw new IllegalArgumentException("강화 비용이 부족합니다!");
        }
        UpgradeResultDTO updateUpgradeItem = upgradeController.upgradeItem(upgradeItemDTO);
        if(updateUpgradeItem.getStatus() > 1) {
            System.out.println("최대 강화 레벨입니다!");
        } else {
            if (updateUpgradeItem.getStatus() == 0) {
                System.out.println("강화 실패");
            } else {
                System.out.println("강화 성공! 현재 아이템 강화 레벨 :" + updateUpgradeItem.getResultUpgradeLevel());
            }
            UpgradeItemDTO updateUserBalance = upgradeController.updateUserBalance(upgradeItemDTO);
            result = upgradeController.updateUserUpgradeItemLevel(updateUserBalance,
                    updateUpgradeItem.getResultUpgradeLevel());
        }
        System.out.println("강화 후\n"
                +"==================================================\n"
                +"사용자가 보유 중인 금액 :"
                + result.getUserMoney() + " / "
                + "강화 비용 :"
                + result.getUpgradeCost()
                + "\n"
        );
    }


    private String makeHpBar(int hpPer){
        char[] arr = new char[100];
        Arrays.fill(arr,'▁');
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < hpPer; i++)
            arr[i] = '█';
        for(char c : arr)
            sb.append(c);
        sb.append(" ").append(hpPer).append("%");
        return String.valueOf(sb);
    }
}
