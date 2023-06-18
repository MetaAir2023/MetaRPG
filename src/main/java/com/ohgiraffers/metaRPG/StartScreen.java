package com.ohgiraffers.metaRPG;

import org.springframework.stereotype.Component;

@Component
public class StartScreen {
    public void start() throws InterruptedException {


        String MetaRPG[] = {


                " ---   ---   -------   -------    -----      -----    ------     -----  ",
                " |  \\_/  |   | |\"\"\"\"   --   --   / /_\\ \\    | ---- |  | | | |   / /  \\ \\   ",
                " | |\'\'\'| |   | |____     | |     | /-\\ |    | \"\"\"\" |  | |\"\"\"\"   | |   |_|  ",
                " | |   | |   | |\"\"\"\"     | |     | | | |    | \"\"\"\\    | |       | |  ____  ",
                " |_|   |_|   |_|____     |_|     |_| |_|    |_| \\_\\   |_|       | |  \"/ /  ",
                "  \"     \"     \"\"\"\"\"\"      \"       \"   \"      \"   \"     \"         \"\"\"\"\"\"    "


        };
        for (int i = 0; i < MetaRPG.length; i++) {
            // 초 간 중지한다
            Thread.sleep(1000);
            // 메세지를 출력한다
            System.out.println(MetaRPG[i]);
        }

    }
}
