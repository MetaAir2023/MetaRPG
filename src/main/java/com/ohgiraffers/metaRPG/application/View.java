package com.ohgiraffers.metaRPG.application;

import com.ohgiraffers.metaRPG.AttackEffectThread;
import com.ohgiraffers.metaRPG.BGM;
import com.ohgiraffers.metaRPG.StartScreen;
import com.ohgiraffers.metaRPG.application.controller.HuntController;
import com.ohgiraffers.metaRPG.application.controller.UpgradeController;
import com.ohgiraffers.metaRPG.application.controller.UserInfoController;
import com.ohgiraffers.metaRPG.application.dto.HuntDTO;
import com.ohgiraffers.metaRPG.application.dto.MonsterDTO;
import com.ohgiraffers.metaRPG.application.dto.UserDTO;
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
    private final UserInfoController userInfoController;
    private final Scanner sc = new Scanner(System.in);
    private final BGM bgm;
    private final StartScreen startScreen;
    @Autowired
    public View(UpgradeController upgradeController,
                HuntController huntController,
                UserInfoController userInfoController,
                BGM bgm,
                StartScreen startScreen


    ) {
        this.upgradeController = upgradeController;
        this.huntController = huntController;
        this.userInfoController = userInfoController;
        this.bgm = bgm;
        this.startScreen = startScreen;
    }

    public void setGame() throws InterruptedException {

        bgm.setDaemon(true);
        bgm.start();
        startScreen.start();
        System.out.print("사용자의 이름을 입력해주세요 : ");
        String userName = sc.next();
        boolean gameRun = true;
        while(gameRun){
            mainSelect();
            int select = sc.nextInt();
            switch(select){
                case 1:
                    upgradeRun(userName);
                    break;
                case 2:
                    huntRun(userName);
                    break;
                case 3:
                    userInfoRun(userName);
                    break;
                case 4:
                    gameRun = false;
                    break;
            }
        }
    }

    private void huntRun(String name){
        // 자신이 원하는 필드 입력 (난이도별)
        fieldSelect();
        int fieldNum = sc.nextInt();

        try {
            // 입력한 필드에 따라 필드별 몬스터를 설정
            MonsterDTO monster = setMonster(fieldNum);


            // 유저의 sequence를 받아
            UserDTO user = setUser(1);
            // 유저와 몬스터의 체력, 공격력 등 정보를 가져온다.
            HuntDTO huntSetting = setHunt(user, monster);

            // 유저와 몬스터의 능력을 비교하여 유저가 이길 수 없는 상황에서 출력하는 구문
            if(!huntController.checkValidBattle(monster, user)){
                System.out.println("(경고) 현재 능력치로는 전투가 불가능합니다.");
                return;
            }
            // 유저의 Hp를 가져오는 구문
            int userCurHp = huntSetting.getUserHp();
            while(true){
                System.out.println("\n" + monster.getName());
                System.out.println("HP : (" + monster.getHp() + "/" + huntController.getMonsterHP(fieldNum) + ")");
                System.out.println(makeHpBar(huntController.calculateMonsterHP(huntSetting,monster)));
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("유저 이름 : " + name );
                System.out.println("HP : (" + userCurHp + "/" + huntSetting.getUserHp() + ")");
                System.out.println(makeHpBar(huntController.calculateUserHP(userCurHp, huntSetting.getUserHp())));
                System.out.println("1. 공격하기");
                System.out.println("2. 도망가기");
                System.out.print("메뉴 선택 : ");
                int select = sc.nextInt();
                if(select == 1){
                    // 컨드롤러에 attackToMonster 메소드를 호출하여 몬스터의 체력과 유저의 총 공격력을 계산한다.
                    monster = huntController.attackToMonster(monster, huntSetting.getUserTotalStr());
                    huntSetting.setMonsterHp(monster.getHp());
                    // 유저의 스킬을 표현하는 tread를 이용한 이펙트 효과
                    Thread attackEffect = new Thread(new AttackEffectThread("adventurerHyperSkill"));
                    attackEffect.start();
                    try {
                        attackEffect.join();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("");

                    String huntAttck[] = {


                            monster.getName() + " 에게 공격을 날렸습니다.. "


                    };
                    for (int i = 0; i < huntAttck.length; i++) {
                        // 초 간 중지한다
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 메세지를 출력한다
                        System.out.println(huntAttck[i]);
                    }
                    System.out.println(monster.getName() + "에게 " + huntSetting.getUserTotalStr() + "의 피해를 입혔습니다 ! !");
                    // 몬스터에게 피해를 입혔을 때 몬스터가 죽으면 실행되는 구문
                    if(monster.getHp() <= 0){
                        System.out.println(monster.getName() + "가 쓰러졌습니다!");
                        // 몬스터를 처리했을 때 출력되는 구문
                        getReward(monster, user);
                        break;
                    }
                    // controller에서 hitFromMonster를 호출하여 몬스터와 현재 체력을 넘겨 몬스터의 공격을 계산하는 구문
                    userCurHp = huntController.hitFromMonster(monster, userCurHp);
                    // 몬스터가 유저에게 공격하는 효과를 tread를 통한 이펙트 구문
                    Thread attackEffect1 = new Thread(new AttackEffectThread("monsterAttack"));
                    attackEffect1.start();
                    try {
                        attackEffect1.join();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("");

                    String MonsAttck[] = {


                            monster.getName() + " 에게 공격을 받았습니다... "


                    };
                    for (int i = 0; i < MonsAttck.length; i++) {
                        // 초 간 중지한다
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 메세지를 출력한다
                        System.out.println(MonsAttck[i]);
                    }

                    System.out.println(monster.getName() + "로부터 " + monster.getStrikingPower() + "의 피해를 입었습니다 ! !");
                    // 유저가 공격을 받았을 때 죽으면 출력되는 구문
                    if(userCurHp <= 0){
                        System.out.println(name +"가 죽었습니다!");
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

    // 위에서 몬스터를 처리하였을 때 호출되는 구문
    private void getReward(MonsterDTO monster, UserDTO user){
    // 몬스터에 저장되어있는 골드와 경험치를 유저에게 저장하는 방식의 페이지다.

        System.out.println(">> 보상 페이지 <<");
        System.out.println("골드 : " + monster.getMoney());
        // 유저와 몬스터를 getReward 메소드를 통해 계산
        huntController.getReward(user,monster);

    }

    private void userInfoRun(String userName) {
        System.out.println("사용자정보 확인");
        UserDTO userDTO = userInfoController.initUserDTO(userName);
        System.out.println(userDTO);
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

    private MonsterDTO setMonster(int sequence){
        MonsterDTO monsterDTO = huntController.initMonster(sequence);

        return monsterDTO;
    }
    private UserDTO setUser(int sequence){
        UserDTO userDTO = huntController.initUser(sequence);

        return userDTO;
    }
    private HuntDTO setHunt(UserDTO userDTO, MonsterDTO monsterDTO){
        HuntDTO huntDTO = huntController.initHunt(userDTO, monsterDTO);
        return huntDTO;
    }

    private void startUpgrade(UpgradeItemDTO upgradeItemDTO) {
        UpgradeItemDTO result = upgradeItemDTO;
        boolean checkUpgrade = upgradeController.checkUpgrade(upgradeItemDTO);
        if (!checkUpgrade) {

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
    private void mainSelect(){
        System.out.println("1. 강화하기");
        System.out.println("2. 전투하기");
        System.out.println("3. 사용자상태 확인");
        System.out.println("4. 게임종료");
        System.out.print("메뉴를 선택해주세요(숫자로) : ");
    }
    private void fieldSelect(){
        System.out.println(">> 필드를 선택하세요. <<");
        System.out.println("1. 칼날 부리의 둥지");
        System.out.println("2. 어스름 늑대의 소굴");
        System.out.println("3. 돌거북의 잠자리");
        System.out.println("4. 심술 두꺼비의 은밀한 장소");
        System.out.println("5. 바위게의 협곡 모험");
        System.out.print("필드 숫자 입력 : ");
    }





}
