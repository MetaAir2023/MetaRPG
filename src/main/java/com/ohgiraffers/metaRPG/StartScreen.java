package com.ohgiraffers.metaRPG;

import org.springframework.stereotype.Component;

@Component
public class StartScreen {

    public static final String black    = "\u001B[30m" ;
        public static final String red      = "\u001B[31m" ;
        public static final String green    = "\u001B[32m" ;
        public static final String yellow   = "\u001B[33m" ;
        public static final String blue     = "\u001B[34m" ;
        public static final String purple   = "\u001B[35m" ;
        public static final String cyan     = "\u001B[36m" ;
        public static final String white     = "\u001B[37m" ;

        public static final String exit     = "\u001B[0m" ;
        public static final String BACKGROUND_BLACK = "\u001B[40m";
        public static final String BACKGROUND_RED = "\u001B[41m";
        public static final String BACKGROUND_GREEN = "\u001B[42m";
        public static final String BACKGROUND_YELLOW = "\u001B[43m";
        public static final String BACKGROUND_BLUE = "\u001B[44m";
        public static final String BACKGROUND_PURPLE = "\u001B[45m";
        public static final String BACKGROUND_CYAN = "\u001B[46m";
        public static final String BACKGROUND_WHITE = "\u001B[47m";
        public void start() throws InterruptedException {




        String MetaRPG[] = {


                BACKGROUND_RED +   " ---   ---   -------   -------    -----      -----    ------     -----     " + exit,
                BACKGROUND_RED +   " |  \\_/  |   | |\"\"\"\"   --   --   / /_\\ \\    | ---- |  | | | |   / /  \\ \\   " + exit,
                BACKGROUND_GREEN + " | |\'\'\'| |   | |____     | |     | /-\\ |    | \"\"\"\" |  | |\"\"\"\"   | |   |_|  " + exit,
                BACKGROUND_GREEN + " | |   | |   | |\"\"\"\"     | |     | | | |    | \"\"\"\\    | |       | |  ____  " + exit,
                BACKGROUND_YELLOW +" |_|   |_|   |_|____     |_|     |_| |_|    |_| \\_\\   |_|       | |  \"/ /  " + exit,
                BACKGROUND_YELLOW +"  \"     \"     \"\"\"\"\"\"      \"       \"   \"      \"   \"     \"         \"\"\"\"\"\"    " + exit


        };
        for (int i = 0; i < MetaRPG.length; i++) {
            // 초 간 중지한다
            Thread.sleep(1000);
            // 메세지를 출력한다
            System.out.println(MetaRPG[i]);
        }

    }
}
