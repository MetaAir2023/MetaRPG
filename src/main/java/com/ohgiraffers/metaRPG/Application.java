package com.ohgiraffers.metaRPG;

import com.ohgiraffers.metaRPG.application.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        View gameView = context.getBean("view", View.class);
        gameView.setGame();
    }
}
