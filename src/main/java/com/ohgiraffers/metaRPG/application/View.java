package com.ohgiraffers.metaRPG.application;

import com.ohgiraffers.metaRPG.BGM;
import com.ohgiraffers.metaRPG.application.controller.UpgradeController;
import com.ohgiraffers.metaRPG.application.dto.item.ShowUserItemDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeItemDTO;
import com.ohgiraffers.metaRPG.application.dto.item.UpgradeResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class View {

    private final UpgradeController upgradeController;
    private final Scanner sc = new Scanner(System.in);
    @Autowired
    public View(UpgradeController upgradeController) {
        this.upgradeController = upgradeController;
    }

    public void setGame() {
//        BGM bgm = new BGM();
//        bgm.setDaemon(true);
//        bgm.start();
        BGM bgm = new BGM();
        bgm.setDaemon(true);
        bgm.start();
        System.out.print("사용자의 이름을 입력해주세요 : ");
        String userName = sc.next();
        boolean gameRun = true;
        while(gameRun){
            System.out.println("1. 게임시작");
            System.out.println("3. 도움말");
            System.out.println("3. 게임종료");
            System.out.print("메뉴를 선택해주세요(숫자로) : ");
            int select = sc.nextInt();
            switch(select){
                case 1:
                    upgradeRun(userName);
                    break;
                case 2:
                    break;
                case 3:
                    gameRun = false;
                    break;
            }
        }
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
}
