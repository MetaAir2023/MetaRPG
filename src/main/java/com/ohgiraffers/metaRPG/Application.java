package com.ohgiraffers.metaRPG;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
//        BGM bgm = new BGM();
//        bgm.setDaemon(true);
//        bgm.start();
        BGM bgm = new BGM();
        bgm.setDaemon(true);
        bgm.start();
        Scanner sc = new Scanner(System.in);
        while(true){
            int select = sc.nextInt();
            switch(select){
                case 1:
                    System.out.println("게임시작");
                    break;
                case 2:
                    System.out.println("도움말");
                    break;
                case 3:
                    System.out.println("게임종료");
                    break;
            }
        }
    }
}
