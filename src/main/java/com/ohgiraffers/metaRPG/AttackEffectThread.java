package com.ohgiraffers.metaRPG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class AttackEffectThread implements Runnable {

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

    private String type;//생성자에 어떤 공격효과메소드를 불러올지 정하기 위한 변수

    public AttackEffectThread(String type){//생성자에 입력된 타입에 따라 공격 효과 메소드가 결정됨
        this.type=type;

    }
    //---------------모험가 공격 효과--------------------------------------------
    public void executeAdventurerAttack() {
        String[] attackImages=new String[7];

        attackImages[0]="                    \n"+
                "                    \n"+
                "                    \n"+
                "      .             \n"+
                ".... ...            \n"+
                "...:v....           \n"+
                ":..:r7Qi.r...       \n"+
                ".rs:.IBr7BBJ... ..  \n"+
                "sBL:iIg.UBQ7vE:: .  \n"+
                "Bb:.:7I:EBg755Bd.::.\n"+
                "MIs15BZBBBsrrrr.::::\n"+
                "i.iuu5:QD. ..       \n"+
                ".UBs.:.. .....      \n"+
                ".vi...r....         \n"+
                "....:r....          \n"+
                "... PS.             \n"+
                "                    \n"+
                "                    \n"+
                "                    \n"+
                "                    \n"+
                "                    ";

        attackImages[1]="                                        \n"+
                "                                        \n"+
                "   . .7. .                              \n"+
                "    . Bg  .               .             \n"+
                "      iB . :r...K7 ..... ...            \n"+
                "      .r. ..:...DS.....:v....           \n"+
                "         .   ... 7U.:..:r7Qi.r...       \n"+
                "          ..:::..2B..rs:.IBr7BBJ... ..  \n"+
                "     . ....::::i.IS.sBL:iIg.UBQ7vE:: .  \n"+
                "7r7iirsrri:...:r7SXLBb:.:7I:EBg755Bd.::.\n"+
                "iirriv5UqbKEX5KBuU2KMIs15BZBBBsrrrr.::::\n"+
                "       .:iYJi:iU..:ji.iuu5:QD. ..       \n"+
                "     . .. Xq .YL.:rr.UBs.:.. .....      \n"+
                "    . idr DK .Qi..:..vi...r....         \n"+
                "   .. jB..Lb bB.........:r....          \n"+
                "  . . QS..:BBBi ..  ... PS.             \n"+
                "   ..sL....bBY . .                      \n"+
                "    .. ....                             \n"+
                "       .                                \n"+
                "                                        \n"+
                "                                        ";

        attackImages[2]="                                                            \n"+
                "                                                            \n"+
                "P7:. .                 . .7. .                              \n"+
                "Rui....                 . Bg  .               .             \n"+
                ".:.... .:.                iB . :r...K7 ..... ...            \n"+
                "i.:..:: .                 .r. ..:...DS.....:v....           \n"+
                ":.....                       .   ... 7U.:..:r7Qi.r...       \n"+
                ":i...     .                   ..:::..2B..rs:.IBr7BBJ... ..  \n"+
                "vsYvri:ii:....           . ....::::i.IS.sBL:iIg.UBQ7vE:: .  \n"+
                "Sjj7YLsvrii::iriiiir7r7iirsrri:...:r7SXLBb:.:7I:EBg755Bd.::.\n"+
                "XqXqSqqqIK2s2qKSuL77iirriv5UqbKEX5KBuU2KMIs15BZBBBsrrrr.::::\n"+
                ":.::.....                  .:iYJi:iU..:ji.iuu5:QD. ..       \n"+
                " .                       . .. Xq .YL.:rr.UBs.:.. .....      \n"+
                ".                       . idr DK .Qi..:..vi...r....         \n"+
                " .                     .. jB..Lb bB.........:r....          \n"+
                ".                     . . QS..:BBBi ..  ... PS.             \n"+
                "                       ..sL....bBY . .                      \n"+
                "                        .. ....                             \n"+
                "                           .                                \n"+
                "                                                            \n"+
                "                                                            ";

        attackImages[3]="                 .                                                              \n"+
                "    .   ..                                                                      \n"+
                " ... rbv..i1Lr.7JrrXP7:. .                 . .7. .                              \n"+
                "..:J77r:75qY2gBQBBBRRui....                 . Bg  .               .             \n"+
                "...YI::irrYDQBQBdr...:.... .:.                iB . :r...K7 ..... ...            \n"+
                "......::sQBJEEY:..i7i.:..:: .                 .r. ..:...DS.....:v....           \n"+
                ".::::i1BX7:jsir7vbi::.....                       .   ... 7U.:..:r7Qi.r...       \n"+
                ":ir1gd2:.:::ij2sQi:.:i...     .                   ..:::..2B..rs:.IBr7BBJ... ..  \n"+
                "vL7EIrrL7r:UdY7PP:irvsYvri:ii:....           . ....::::i.IS.sBL:iIg.UBQ7vE:: .  \n"+
                "QE5XPDdPP5RM5I2gBdKbSjj7YLsvrii::iriiiir7r7iirsrri:...:r7SXLBb:.:7I:EBg755Bd.::.\n"+
                "sJJvrrrsvgRuj11SXbKqXqXqSqqqIK2s2qKSuL77iirriv5UqbKEX5KBuU2KMIs15BZBBBsrrrr.::::\n"+
                "LYi:..7Y7v:.:.::7i:::.::.....                  .:iYJi:iU..:ji.iuu5:QD. ..       \n"+
                ".:i::vsU7:......X... .                       . .. Xq .YL.:rr.UBs.:.. .....      \n"+
                "....iL... .....Dr::..                       . idr DK .Qi..:..vi...r....         \n"+
                " ...:. ........r.i.. .                     .. jB..Lb bB.........:r....          \n"+
                ". . .7 ....... .L.. .                     . . QS..:BBBi ..  ... PS.             \n"+
                " .  .B. ..... iZ:. .                       ..sL....bBY . .                      \n"+
                "     DB:  ..:IR: ..                         .. ....                             \n"+
                "   .  BBBBBBQI  ..                             .                                \n"+
                "  ... :bi7rii:. .                                                               \n"+
                "     . ..  ..                                                                   ";

        attackImages[4]="                                     .                                                              \n"+
                "                        .   ..                                                                      \n"+
                "                     ... rbv..i1Lr.7JrrXP7:. .                 . .7. .                              \n"+
                "                    ..:J77r:75qY2gBQBBBRRui....                 . Bg  .               .             \n"+
                "         .       ......YI::irrYDQBQBdr...:.... .:.                iB . :r...K7 ..... ...            \n"+
                "         :.      .........::sQBJEEY:..i7i.:..:: .                 .r. ..:...DS.....:v....           \n"+
                "           .s: . ....::::i1BX7:jsir7vbi::.....                       .   ... 7U.:..:r7Qi.r...       \n"+
                "   ..   ....Svi:....:ir1gd2:.:::ij2sQi:.:i...     .                   ..:::..2B..rs:.IBr7BBJ... ..  \n"+
                "...::. ...:r:iiiir7vvL7EIrrL7r:UdY7PP:irvsYvri:ii:....           . ....::::i.IS.sBL:iIg.UBQ7vE:: .  \n"+
                "L::ivv77r:rjjsuuUXq5QE5XPDdPP5RM5I2gBdKbSjj7YLsvrii::iriiiir7r7iirsrri:...:r7SXLBb:.:7I:EBg755Bd.::.\n"+
                "irvuU2Liii77:iii:r7vsJJvrrrsvgRuj11SXbKqXqXqSqqqIK2s2qKSuL77iirriv5UqbKEX5KBuU2KMIs15BZBBBsrrrr.::::\n"+
                "  .      .:.  . ...:LYi:..7Y7v:.:.::7i:::.::.....                  .:iYJi:iU..:ji.iuu5:QD. ..       \n"+
                "       . . . .....::.:i::vsU7:......X... .                       . .. Xq .YL.:rr.UBs.:.. .....      \n"+
                "          i   .  iL ....iL... .....Dr::..                       . idr DK .Qi..:..vi...r....         \n"+
                "                     ...:. ........r.i.. .                     .. jB..Lb bB.........:r....          \n"+
                "                    . . .7 ....... .L.. .                     . . QS..:BBBi ..  ... PS.             \n"+
                "                     .  .B. ..... iZ:. .                       ..sL....bBY . .                      \n"+
                "                         DB:  ..:IR: ..                         .. ....                             \n"+
                "                       .  BBBBBBQI  ..                             .                                \n"+
                "                      ... :bi7rii:. .                                                               \n"+
                "                         . ..  ..                                                                   ";

        attackImages[5]="                                                         .                                                              \n"+
                "                                            .   ..                                                                      \n"+
                "                                         ... rbv..i1Lr.7JrrXP7:. .                 . .7. .                              \n"+
                "                                        ..:J77r:75qY2gBQBBBRRui....                 . Bg  .               .             \n"+
                "                             .       ......YI::irrYDQBQBdr...:.... .:.                iB . :r...K7 ..... ...            \n"+
                "                             :.      .........::sQBJEEY:..i7i.:..:: .                 .r. ..:...DS.....:v....           \n"+
                "                               .s: . ....::::i1BX7:jsir7vbi::.....                       .   ... 7U.:..:r7Qi.r...       \n"+
                "            .          ..   ....Svi:....:ir1gd2:.:::ij2sQi:.:i...     .                   ..:::..2B..rs:.IBr7BBJ... ..  \n"+
                "           ::      ....::. ...:r:iiiir7vvL7EIrrL7r:UdY7PP:irvsYvri:ii:....           . ....::::i.IS.sBL:iIg.UBQ7vE:: .  \n"+
                ".................:rL::ivv77r:rjjsuuUXq5QE5XPDdPP5RM5I2gBdKbSjj7YLsvrii::iriiiir7r7iirsrri:...:r7SXLBb:.:7I:EBg755Bd.::.\n"+
                ".:::.:...........::iirvuU2Liii77:iii:r7vsJJvrrrsvgRuj11SXbKqXqXqSqqqIK2s2qKSuL77iirriv5UqbKEX5KBuU2KMIs15BZBBBsrrrr.::::\n"+
                "                      .      .:.  . ...:LYi:..7Y7v:.:.::7i:::.::.....                  .:iYJi:iU..:ji.iuu5:QD. ..       \n"+
                "                           . . . .....::.:i::vsU7:......X... .                       . .. Xq .YL.:rr.UBs.:.. .....      \n"+
                "                              i   .  iL ....iL... .....Dr::..                       . idr DK .Qi..:..vi...r....         \n"+
                "                                         ...:. ........r.i.. .                     .. jB..Lb bB.........:r....          \n"+
                "                                        . . .7 ....... .L.. .                     . . QS..:BBBi ..  ... PS.             \n"+
                "                                         .  .B. ..... iZ:. .                       ..sL....bBY . .                      \n"+
                "                                             DB:  ..:IR: ..                         .. ....                             \n"+
                "                                           .  BBBBBBQI  ..                             .                                \n"+
                "                                          ... :bi7rii:. .                                                               \n"+
                "                                             . ..  ..                                                                   ";

        attackImages[6]="                                                                      .                                                              \n"+
                "                                                         .   ..                                                                      \n"+
                "                                                      ... rbv..i1Lr.7JrrXP7:. .                 . .7. .                              \n"+
                "                                                     ..:J77r:75qY2gBQBBBRRui....                 . Bg  .               .             \n"+
                "                                          .       ......YI::irrYDQBQBdr...:.... .:.                iB . :r...K7 ..... ...            \n"+
                "                                          :.      .........::sQBJEEY:..i7i.:..:: .                 .r. ..:...DS.....:v....           \n"+
                "                                            .s: . ....::::i1BX7:jsir7vbi::.....                       .   ... 7U.:..:r7Qi.r...       \n"+
                "                         .          ..   ....Svi:....:ir1gd2:.:::ij2sQi:.:i...     .                   ..:::..2B..rs:.IBr7BBJ... ..  \n"+
                "                        ::      ....::. ...:r:iiiir7vvL7EIrrL7r:UdY7PP:irvsYvri:ii:....           . ....::::i.IS.sBL:iIg.UBQ7vE:: .  \n"+
                "             ..................:rL::ivv77r:rjjsuuUXq5QE5XPDdPP5RM5I2gBdKbSjj7YLsvrii::iriiiir7r7iirsrri:...:r7SXLBb:.:7I:EBg755Bd.::.\n"+
                "             .:::.:...........::iirvuU2Liii77:iii:r7vsJJvrrrsvgRuj11SXbKqXqXqSqqqIK2s2qKSuL77iirriv5UqbKEX5KBuU2KMIs15BZBBBsrrrr.::::\n"+
                "                                   .      .:.  . ...:LYi:..7Y7v:.:.::7i:::.::.....                  .:iYJi:iU..:ji.iuu5:QD. ..       \n"+
                "                                        . . . .....::.:i::vsU7:......X... .                       . .. Xq .YL.:rr.UBs.:.. .....      \n"+
                "                                           i   .  iL ....iL... .....Dr::..                       . idr DK .Qi..:..vi...r....         \n"+
                "                                                      ...:. ........r.i.. .                     .. jB..Lb bB.........:r....          \n"+
                "                                                     . . .7 ....... .L.. .                     . . QS..:BBBi ..  ... PS.             \n"+
                "                                                      .  .B. ..... iZ:. .                       ..sL....bBY . .                      \n"+
                "                                                          DB:  ..:IR: ..                         .. ....                             \n"+
                "                                                        .  BBBBBBQI  ..                             .                                \n"+
                "                                                       ... :bi7rii:. .                                                               \n"+
                "                                                          . ..  ..                                                                   ";
        for(int i=0; i<100; i++) {
            System.out.println("");
        }
        for(int i=0; i<attackImages.length; i++ ) {
            for(int j=0;j<30;j++) {
                System.out.println("");
            }
            System.out.println(attackImages[i]);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {

            }

        }
    }

    public void executeAdventurerSkill() {
        String[] skillImages=new String[6];

        skillImages[0]="                    \n"+
                "                    \n"+
                "                    \n"+
                "                    \n"+
                "                    \n"+
                "                    \n"+
                "                    \n"+
                ".  ...2.            \n"+
                "77i:i7i             \n"+
                "rr7rrr7i..i.        \n"+
                "iriiirr77iii  .     \n"+
                "..:..:iirrrr:.:     \n"+
                "      ...rrriii.    \n"+
                "         :iirri.    \n"+
                "         ..:iri     \n"+
                "          .:ri      \n"+
                "          .:ii      \n"+
                "         .::irv     \n"+
                "       ....iii7:    \n"+
                ".. .:...i:ii7i:.    \n"+
                ":::i::.irrr7r.      \n"+
                "rrririir7rr:        \n"+
                "rririr7vr...        \n"+
                "77rr77i.  JZ.       \n"+
                "::::.     r:        \n"+
                "                    \n"+
                "                    \n"+
                "                    \n"+
                ":                   \n"+
                "                    \n"+
                "                    \n"+
                "                    ";

        skillImages[1]="                                        \n"+
                "              r:                        \n"+
                "..        SBBBB:                        \n"+
                "..  .     i:7.                          \n"+
                "::i:.:rr:.                              \n"+
                ":  .:.:..q7U                            \n"+
                " .r.      :7                            \n"+
                "::         : .iii::..  ...2.            \n"+
                ".    ..:::i:.::ir7rv77i:i7i             \n"+
                "i  .::ir7r7r7rrirrrrrr7rrr7i..i.        \n"+
                ":ir777rrrrirrrrrii:iiriiirr77iii  .     \n"+
                ".:riririiiiiiiiii::...:..:iirrrr:.:     \n"+
                ":iiririrrri::.......      ...rrriii.    \n"+
                "777rrrriiii::....            :iirri.    \n"+
                "::........ . . .             ..:iri     \n"+
                "                              .:ri      \n"+
                "........                      .:ii      \n"+
                "rii:::::::::::..             .::irv     \n"+
                "rrrrii:::::::......        ....iii7:    \n"+
                "rr7rrri:i:i:i:i::..... .:...i:ii7i:.    \n"+
                ":ii::iirrrrrrr::::ii:::i::.irrr7r.      \n"+
                "i   .:rrrrririrrrrrirrririir7rr:        \n"+
                "   ::iiiiiiiiririrrrrririr7vr...        \n"+
                "  :       ..ii7rrrrr77rr77i.  JZ.       \n"+
                " :.    .:iii::::irrr::::.     r:        \n"+
                ".s .:  ::   .                           \n"+
                "PJ i:  7                                \n"+
                "i     :i.        uBK                    \n"+
                "     .           .UB:                   \n"+
                "             7                          \n"+
                " :           i                          \n"+
                "                                        ";

        skillImages[2]="                                                            \n"+
                "                                  r:                        \n"+
                "                    ..        SBBBB:                        \n"+
                "                    ..  .     i:7.                          \n"+
                "5i                  ::i:.:rr:.                              \n"+
                "BB7                v:  .:.:..q7U                            \n"+
                "MQ7          .       .r.      :7                            \n"+
                "d:..     .rs5suK7   ::         : .iii::..  ...2.            \n"+
                " i 7:i77JJi.   :j  Y.    ..:::i:.::ir7rv77i:i7i             \n"+
                " J: ..Ir      :    .i  .::ir7r7r7rrirrrrrr7rrr7i..i.        \n"+
                "  ::..iX     B.   ..:ir777rrrrirrrrrii:iiriiirr77iii  .     \n"+
                ":      Q.   :D      .:riririiiiiiiiii::...:..:iirrrr:.:     \n"+
                "      .Y    ri     ::iiririrrri::.......      ...rrriii.    \n"+
                " ...:.i:::i:j7irrrv7777rrrriiii::....            :iirri.    \n"+
                "iiirrriiii:PUU2I2j::::........ . . .             ..:iri     \n"+
                "           .i.:.rE.                               .:ri      \n"+
                "irii:i:i::::.....:..........                      .:ii      \n"+
                "::iivYsvYvLrrrvusirrrii:::::::::::..             .::irv     \n"+
                " .ivi:     .7PXYr7r7rrrrii:::::::......        ....iii7:    \n"+
                "r57        ss:  ..:irr7rrri:i:i:i:i::..... .:...i:ii7i:.    \n"+
                "P.        Ur.      .:ii::iirrrrrrr::::ii:::i::.irrr7r.      \n"+
                ".         YEL.  ..rri   .:rrrrririrrrrrirrririir7rr:        \n"+
                "           .JggEsQP    ::iiiiiiiiririrrrrririr7vr...        \n"+
                "                .7    :       ..ii7rrrrr77rr77i.  JZ.       \n"+
                " ..  ..        r.  . :.    .:iii::::irrr::::.     r:        \n"+
                "iv....        ::    .s .:  ::   .                           \n"+
                "r..           .i   :PJ i:  7                                \n"+
                "             .i . YXi     :i.        uBK                    \n"+
                "            .g. ...      .           .UB:                   \n"+
                "              i:.                7                          \n"+
                "                     :           i                          \n"+
                "                                                            ";

        skillImages[3]="                 KL                                                             \n"+
                "                bB.                                   r:                        \n"+
                "                 r                      ..        SBBBB:                        \n"+
                "                                        ..  .     i:7.                          \n"+
                "    .qU7         7BQ5i                  ::i:.:rr:.                              \n"+
                "   bBBBq         SBBBB7                v:  .:.:..q7U                            \n"+
                "  QBBQr         .BQQMQ7          .       .r.      :7                            \n"+
                ".v1:           7BBQQd:..     .rs5suK7   ::         : .iii::..  ...2.            \n"+
                "       .:i    jBgMZI i 7:i77JJi.   :j  Y.    ..:::i:.::ir7rv77i:i7i             \n"+
                "..       jb7v:i5i..  J: ..Ir      :    .i  .::ir7r7r7rrirrrrrr7rrr7i..i.        \n"+
                " .Q:     vP5sIYri..r  ::..iX     B.   ..:ir777rrrrirrrrrii:iiriiirr77iii  .     \n"+
                ":vv     .UD.      iu:      Q.   :D      .:riririiiiiiiiii::...:..:iirrrr:.:     \n"+
                "K    i:..sr      :U2      .Y    ri     ::iiririrrri::.......      ...rrriii.    \n"+
                "    :  .i       :Db: ...:.i:::i:j7irrrv7777rrrriiii::....            :iirri.    \n"+
                "  .. .:i...::::YPJ::iiirrriiii:PUU2I2j::::........ . . .             ..:iri     \n"+
                "irriiii:::::..:5:              .i.:.rE.                               .:ri      \n"+
                ":::irrrrr7r7rr2j:iiririi:i:i::::.....:..........                      .:ii      \n"+
                "   .          7u::::::iivYsvYvLrrrvusirrrii:::::::::::..             .::irv     \n"+
                " .i           1u i:  .ivi:     .7PXYr7r7rrrrii:::::::......        ....iii7:    \n"+
                "bQg       iJ2Lr   rIr57        ss:  ..:irr7rrri:i:i:i:i::..... .:...i:ii7i:.    \n"+
                "gq.      ZP:       ZP.        Ur.      .:ii::iirrrrrrr::::ii:::i::.irrr7r.      \n"+
                "         .gr      vB.         YEL.  ..rri   .:rrrrririrrrrrirrririir7rr:        \n"+
                "          .P7.   :g.           .JggEsQP    ::iiiiiiiiririrrrrririr7vr...        \n"+
                "            7BBUqU                  .7    :       ..ii7rrrrr77rr77i.  JZ.       \n"+
                "              X      ..  ..        r.  . :.    .:iii::::irrr::::.     r:        \n"+
                "              .iv   iv....        ::    .s .:  ::   .                           \n"+
                "              7BBB::r..           .i   :PJ i:  7                                \n"+
                "              .XBBQ              .i . YXi     :i.        uBK                    \n"+
                "                 K7             .g. ...      .           .UB:                   \n"+
                "                                  i:.                7                          \n"+
                "    rP.                                  :           i                          \n"+
                "    .                                                                           ";

        skillImages[4]="                                     KL                                                             \n"+
                "                                    bB.                                   r:                        \n"+
                "                                     r                      ..        SBBBB:                        \n"+
                "                                                            ..  .     i:7.                          \n"+
                "                        .qU7         7BQ5i                  ::i:.:rr:.                              \n"+
                "                       bBBBq         SBBBB7                v:  .:.:..q7U                            \n"+
                "             XP.      QBBQr         .BQQMQ7          .       .r.      :7                            \n"+
                "            .PD.    .v1:           7BBQQd:..     .rs5suK7   ::         : .iii::..  ...2.            \n"+
                "                   .       .:i    jBgMZI i 7:i77JJi.   :j  Y.    ..:::i:.::ir7rv77i:i7i             \n"+
                "  i.   i:        .su..       jb7v:i5i..  J: ..Ir      :    .i  .::ir7r7r7rrirrrrrr7rrr7i..i.        \n"+
                "  i     7  :Zi.      .Q:     vP5sIYri..r  ::..iX     B.   ..:ir777rrrrirrrrrii:iiriiirr77iii  .     \n"+
                " .:...sP. .US:rYLr:::vv     .UD.      iu:      Q.   :D      .:riririiiiiiiiii::...:..:iirrrr:.:     \n"+
                "J2:..vI  .P:      .ZK    i:..sr      :U2      .Y    ri     ::iiririrrri::.......      ...rrriii.    \n"+
                ":   q     q       1R    :  .i       :Db: ...:.i:::i:j7irrrv7777rrrriiii::....            :iirri.    \n"+
                "   vd     :.     :gi  .. .:i...::::YPJ::iiirrriiii:PUU2I2j::::........ . . .             ..:iri     \n"+
                "   rB..:::.:iiriiq2:irriiii:::::..:5:              .i.:.rE.                               .:ri      \n"+
                "    P2    77 .. 7gi.:::irrrrr7r7rr2j:iiririi:i:i::::.....:..........                      .:ii      \n"+
                "    5sv..vP     ur     .          7u::::::iivYsvYvLrrrvusirrrii:::::::::::..             .::irv     \n"+
                "    qL7uR.   :LU:    .i           1u i:  .ivi:     .7PXYr7r7rrrrii:::::::......        ....iii7:    \n"+
                "        ::   .is7r::bQg       iJ2Lr   rIr57        ss:  ..:irr7rrri:i:i:i:i::..... .:...i:ii7i:.    \n"+
                "          ::     :i7gq.      ZP:       ZP.        Ur.      .:ii::iirrrrrrr::::ii:::i::.irrr7r.      \n"+
                "                             .gr      vB.         YEL.  ..rri   .:rrrrririrrrrrirrririir7rr:        \n"+
                "                              .P7.   :g.           .JggEsQP    ::iiiiiiiiririrrrrririr7vr...        \n"+
                "                                7BBUqU                  .7    :       ..ii7rrrrr77rr77i.  JZ.       \n"+
                "                                  X      ..  ..        r.  . :.    .:iii::::irrr::::.     r:        \n"+
                "                                  .iv   iv....        ::    .s .:  ::   .                           \n"+
                "                                  7BBB::r..           .i   :PJ i:  7                                \n"+
                "                                  .XBBQ              .i . YXi     :i.        uBK                    \n"+
                "                                     K7             .g. ...      .           .UB:                   \n"+
                "                                                      i:.                7                          \n"+
                "                        rP.                                  :           i                          \n"+
                "                        .                                                                           ";


        skillImages[5]="                                               KL                                                             \n"+
                "                                              bB.                                   r:                        \n"+
                "                                               r                      ..        SBBBB:                        \n"+
                "                                                                      ..  .     i:7.                          \n"+
                "                                  .qU7         7BQ5i                  ::i:.:rr:.                              \n"+
                "                                 bBBBq         SBBBB7                v:  .:.:..q7U                            \n"+
                "                       XP.      QBBQr         .BQQMQ7          .       .r.      :7                            \n"+
                "                      .PD.    .v1:           7BBQQd:..     .rs5suK7   ::         : .iii::..  ...2.            \n"+
                "                             .       .:i    jBgMZI i 7:i77JJi.   :j  Y.    ..:::i:.::ir7rv77i:i7i             \n"+
                "            i.   i:        .su..       jb7v:i5i..  J: ..Ir      :    .i  .::ir7r7r7rrirrrrrr7rrr7i..i.        \n"+
                "            i     7  :Zi.      .Q:     vP5sIYri..r  ::..iX     B.   ..:ir777rrrrirrrrrii:iiriiirr77iii  .     \n"+
                "        .  .:...sP. .US:rYLr:::vv     .UD.      iu:      Q.   :D      .:riririiiiiiiiii::...:..:iirrrr:.:     \n"+
                "       rr:J2:..vI  .P:      .ZK    i:..sr      :U2      .Y    ri     ::iiririrrri::.......      ...rrriii.    \n"+
                "ce   l5j J:   q     q       1R    :  .i       :Db: ...:.i:::i:j7irrrv7777rrrriiii::....            :iirri.    \n"+
                "  1l   :i:   vd     :.     :gi  .. .:i...::::YPJ::iiirrriiii:PUU2I2j::::........ . . .             ..:iri     \n"+
                "        .    rB..:::.:iiriiq2:irriiii:::::..:5:              .i.:.rE.                               .:ri      \n"+
                "       r:     P2    77 .. 7gi.:::irrrrr7r7rr2j:iiririi:i:i::::.....:..........                      .:ii      \n"+
                "      :i      5sv..vP     ur     .          7u::::::iivYsvYvLrrrvusirrrii:::::::::::..             .::irv     \n"+
                "              qL7uR.   :LU:    .i           1u i:  .ivi:     .7PXYr7r7rrrrii:::::::......        ....iii7:    \n"+
                "                  ::   .is7r::bQg       iJ2Lr   rIr57        ss:  ..:irr7rrri:i:i:i:i::..... .:...i:ii7i:.    \n"+
                "                    ::     :i7gq.      ZP:       ZP.        Ur.      .:ii::iirrrrrrr::::ii:::i::.irrr7r.      \n"+
                "                                       .gr      vB.         YEL.  ..rri   .:rrrrririrrrrrirrririir7rr:        \n"+
                "                                        .P7.   :g.           .JggEsQP    ::iiiiiiiiririrrrrririr7vr...        \n"+
                "                                          7BBUqU                  .7    :       ..ii7rrrrr77rr77i.  JZ.       \n"+
                "                                            X      ..  ..        r.  . :.    .:iii::::irrr::::.     r:        \n"+
                "                                            .iv   iv....        ::    .s .:  ::   .                           \n"+
                "                                            7BBB::r..           .i   :PJ i:  7                                \n"+
                "                                            .XBBQ              .i . YXi     :i.        uBK                    \n"+
                "                                               K7             .g. ...      .           .UB:                   \n"+
                "                                                                i:.                7                          \n"+
                "                                  rP.                                  :           i                          \n"+
                "                                  .                                                                           ";
        for(int i=0; i<100; i++) {
            System.out.println("");
        }
        for(int i=0; i<skillImages.length; i++ ) {
            for(int j=0;j<50;j++) {
                System.out.println("");
            }
            System.out.println(skillImages[i]);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {

            }

        }



    }


    public void executeAdventurerHyperSkill() {
        String[] hyperSkillImages= new String[9];

        hyperSkillImages[0]= red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"i         \n"+
                red +":.  .:..  \n"+
                red +"   .r.    \n"+
                red +"   .      \n"+
                red +"   :i     \n"+
                red +" .:       \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n"+
                red +"          \n" + exit;

        hyperSkillImages[1]=yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +".                   \n"+
                yellow +"...                 \n"+
                yellow +":....               \n"+
                yellow +"::....              \n"+
                yellow +"rii:...             \n"+
                yellow +"i7ii:...            \n"+
                yellow +"::ri:....           \n"+
                yellow +"i::ri:...           \n"+
                yellow +"rr::i::..           \n"+
                yellow +"rrr:::.:.           \n"+
                yellow +"rr7i::... i         \n"+
                yellow +"rrrv:.....:.  .:..  \n"+
                yellow +"rr77r..::    .r.    \n"+
                yellow +"rrrvi...     .      \n"+
                yellow +"rrv7::.      :i     \n"+
                yellow +"r77iir:    .:       \n"+
                yellow +"77i:.  .r:          \n"+
                yellow +"vr..    .           \n"+
                yellow +"i:.                 \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n"+
                yellow +"                    \n";

        hyperSkillImages[2]=green +"             i.  .r:                    \n"+
                green +"           :   ::                       \n"+
                green +"          i                             \n"+
                green +"                .i                      \n"+
                green +"                :                       \n"+
                green +" . ......i.    ...                      \n"+
                green +"7rriiii:rri::ii......                   \n"+
                green +"i77ssvrriiirrr::::.:...                 \n"+
                green +"iirr77u21vrirrrri:i::....               \n"+
                green +"r77L77rrrvv7r77777ir::....              \n"+
                green +"IUJ7r:i:::::::::rrrrrii:...             \n"+
                green +"7vvririiiiii:::::::ii7ii:...            \n"+
                green +"  ..iL1JJsYv7rririi:::ri:....           \n"+
                green +"     .77rvvsJuL7rriri::ri:...           \n"+
                green +"i.   :rii:i:r7uYvrrirr::i::..           \n"+
                green +"5Xu5s7irrr7r:irsYvrrrrr:::.:.           \n"+
                green +"YLjLYvrrriiir::7jvvrrr7i::... i         \n"+
                green +"iiiiiiii:::::i:7jsv7rrrv:.....:.  .:..  \n"+
                green +"::i:iiir7ri:::rvuvL7rr77r..::    .r.    \n"+
                green +"rrr777ii:ri:.iJ1Lv77rrrvi...     .      \n"+
                green +"21jv7ii:i:::iv1sL7rrrrv7::.      :i     \n"+
                green +"v7riii:iiirsu2sLrrrrr77iir:    .:       \n"+
                green +"iii:ii7vJj1sL7rrrrrr77i:.  .r:          \n"+
                green +"7ii7LjJJv7rririrrr7vvr..    .           \n"+
                green +"YPRgdIJ77rrirrr7YYYi:.                  \n"+
                green +"i77vr7rrr777vYsj7i.                     \n"+
                green +"  .:r7vLJJusYri.                        \n"+
                green +"vjJU1usLri:.                            \n"+
                green +"vrri:.                                  \n"+
                green +"                                        \n"+
                green +"                                        \n";

        hyperSkillImages[3]=blue +	"                                 i.  .r:                    \n"+
                blue +"                                 :   ::                       \n"+
                blue +"                                i                             \n"+
                blue +"                                      .i                      \n"+
                blue +"                                      :                       \n"+
                blue +"                     . . ......i.    ...                      \n"+
                blue +"              ..::rirr7rriiii:rri::ii......                   \n"+
                blue +"           ....:.:.::ii77ssvrriiirrr::::.:...                 \n"+
                blue +"                ....iiiirr77u21vrirrrri:i::....               \n"+
                blue +"r:           . .:::i:rr77L77rrrvv7r77777ir::....              \n"+
                blue +"PPPs:       ..r7vL1IuvIUJ7r:i:::::::::rrrrrii:...             \n"+
                blue +"ISSqq5Lrir::rvvsUPEZPs7vvririiiiii:::::::ii7ii:...            \n"+
                blue +"gZgZMQBQBE2YJLJYLi:.:.  ..iL1JJsYv7rririi:::ri:....           \n"+
                blue +"BBBBBBZSu5dRQR5Li:ir7:     .77rvvsJuL7rriri::ri:...           \n"+
                blue +"UuuYJs2bRQQZKLLJqMBQQgi.   :rii:i:r7uYvrrirr::i::..           \n"+
                blue +"KbdggRggq2L7v5ZQRgqSJJ5Xu5s7irrr7r:irsYvrrrrr:::.:.           \n"+
                blue +"gdEPKUuLJjKdQgdIjvvvYLYLjLYvrrriiir::7jvvrrr7i::... i         \n"+
                blue +"YJsuJ22KqP51v7rrr7rririiiiiiii:::::i:7jsv7rrrv:.....:.  .:..  \n"+
                blue +"v7v77r7ii::::::::.:.::::i:iiir7ri:::rvuvL7rr77r..::    .r.    \n"+
                blue +"rririi:i:i:i:i:::iirirrrr777ii:ri:.iJ1Lv77rrrvi...     .      \n"+
                blue +"PSXSqSXSXIXSKSS2IjssYY21jv7ii:i:::iv1sL7rrrrv7::.      :i     \n"+
                blue +"XKKbPdbbKPIIJjvsLsLsv7v7riii:iiirsu2sLrrrrr77iir:    .:       \n"+
                blue +"vvsYYvLrririi:r7rivrr:iii:ii7vJj1sL7rrrrrr77i:.  .r:          \n"+
                blue +"7v7v7riirj5PPPXr  :j1J7ii7LjJJv7rririrrr7vvr..    .           \n"+
                blue +"    .    .:ivv:      :YPRgdIJ77rrirrr7YYYi:.                  \n"+
                blue +"                     .i77vr7rrr777vYsj7i.                     \n"+
                blue +"                    .   .:r7vLJJusYri.                        \n"+
                blue +"         .:r        :LvjJU1usLri:.                            \n"+
                blue +"      .:ii7i.     .i77vrri:.                                  \n"+
                blue +"   .....     .ri   .                                          \n"+
                blue +"              i.                                              \n";

        hyperSkillImages[4]=cyan +"                                                     i.  .r:                    \n"+
                cyan +"                                                     :   ::                       \n"+
                cyan +"                                                    i                             \n"+
                cyan +"                                                          .i                      \n"+
                cyan +"                                                          :                       \n"+
                cyan +"                                         . . ......i.    ...                      \n"+
                cyan +"                                  ..::rirr7rriiii:rri::ii......                   \n"+
                cyan +"                               ....:.:.::ii77ssvrriiirrr::::.:...                 \n"+
                cyan +"              ...                   ....iiiirr77u21vrirrrri:i::....               \n"+
                cyan +"v:        ..:r7vs11ur:           . .:::i:rr77L77rrrvv7r77777ir::....              \n"+
                cyan +"irr:7s1uII5IX55UIUSXPPPs:       ..r7vL1IuvIUJ7r:i:::::::::rrrrrii:...             \n"+
                cyan +"7uSbPPKqKqSqXKSK552SISSqq5Lrir::rvvsUPEZPs7vvririiiiii:::::::ii7ii:...            \n"+
                cyan +"KII1UUSSqXPPEdDZDDgDgZgZMQBQBE2YJLJYLi:.:.  ..iL1JJsYv7rririi:::ri:....           \n"+
                cyan +"uUUKPgRBBBBBBBBBBBQBBBBBBBZSu5dRQR5Li:ir7:     .77rvvsJuL7rriri::ri:...           \n"+
                cyan +"EZMQBBBQMPP5511j2U1uUuuYJs2bRQQZKLLJqMBQQgi.   :rii:i:r7uYvrrirr::i::..           \n"+
                cyan +"PPRBBDv7777J1I2I2KKqKbdggRggq2L7v5ZQRgqSJJ5Xu5s7irrr7r:irsYvrrrrr:::.:.           \n"+
                cyan +"uQBQILKdDddqPbZZgDgDgdEPKUuLJjKdQgdIjvvvYLYLjLYvrrriiir::7jvvrrr7i::... i         \n"+
                cyan +"QQK2bQgESuLsvYYJsjLsYJsuJ22KqP51v7rrr7rririiiiiiii:::::i:7jsv7rrrv:.....:.  .:..  \n"+
                cyan +"Y:7qQRBRMqIYvrrrrr7rv7v77r7ii::::::::.:.::::i:iiir7ri:::rvuvL7rr77r..::    .r.    \n"+
                cyan +"   .isSDMQQQZKUJvv77rririi:i:i:i:i:::iirirrrr777ii:ri:.iJ1Lv77rrrvi...     .      \n"+
                cyan +"       .rLSbgMQMRgZbPSXSqSXSXIXSKSS2IjssYY21jv7ii:i:::iv1sL7rrrrv7::.      :i     \n"+
                cyan +"           ..irsj2IKXKKbPdbbKPIIJjvsLsLsv7v7riii:iiirsu2sLrrrrr77iir:    .:       \n"+
                cyan +"              ..::rrvvsYYvLrririi:r7rivrr:iii:ii7vJj1sL7rrrrrr77i:.  .r:          \n"+
                cyan +"           ...:i:iir7v7v7riirj5PPPXr  :j1J7ii7LjJJv7rririrrr7vvr..    .           \n"+
                cyan +"                        .    .:ivv:      :YPRgdIJ77rrirrr7YYYi:.                  \n"+
                cyan +"                                         .i77vr7rrr777vYsj7i.                     \n"+
                cyan +"                                        .   .:r7vLJJusYri.                        \n"+
                cyan +"                             .:r        :LvjJU1usLri:.                            \n"+
                cyan +"                          .:ii7i.     .i77vrri:.                                  \n"+
                cyan +"                       .....     .ri   .                                          \n"+
                cyan +"                                  i.                                              \n";

        hyperSkillImages[5]=black +"                                                                        i.  .r:                    \n"+
                black +"                                                                        :   ::                       \n"+
                black +"                                                                        i                             \n"+
                black +"                                                                              .i                      \n"+
                black +"                                                                              :                       \n"+
                black +"                                                             . . ......i.    ...                      \n"+
                black +"                                                      ..::rirr7rriiii:rri::ii......                   \n"+
                black +"   ....:::.::..                                    ....:.:.::ii77ssvrriiirrr::::.:...                 \n"+
                black +"vYuJ1jjJJsJYjJjv7i:               ...                   ....iiiirr77u21vrirrrri:i::....               \n"+
                black +"121ussvvrrii:ii7JUUUv:        ..:r7vs11ur:           . .:::i:rr77L77rrrvv7r77777ir::....              \n"+
                black +"JLsvYvvrrri::::...::irr:7s1uII5IX55UIUSXPPPs:       ..r7vL1IuvIUJ7r:i:::::::::rrrrrii:...             \n"+
                black +"LjsjLsLL7L77rrii:::i7uSbPPKqKqSqXKSK552SISSqq5Lrir::rvvsUPEZPs7vvririiiiii:::::::ii7ii:...            \n"+
                black +"I1IU2j21212JLrri7j5XKII1UUSSqXPPEdDZDDgDgZgZMQBQBE2YJLJYLi:.:.  ..iL1JJsYv7rririi:::ri:....           \n"+
                black +"252SSbbZPKsvr7YU25UUuUUKPgRBBBBBBBBBBBQBBBBBBBZSu5dRQR5Li:ir7:     .77rvvsJuL7rriri::ri:...           \n"+
                black +"KqggQgPjvrr7JuUu11I5EZMQBBBQMPP5511j2U1uUuuYJs2bRQQZKLLJqMBQQgi.   :rii:i:r7uYvrrirr::i::..           \n"+
                black +"ggXLri::ivu215SPKZgQPPRBBDv7777J1I2I2KKqKbdggRggq2L7v5ZQRgqSJJ5Xu5s7irrr7r:irsYvrrrrr:::.:.           \n"+
                black +"r:::rv1XdbEdMMQQBQELuQBQILKdDddqPbZZgDgDgdEPKUuLJjKdQgdIjvvvYLYLjLYvrrriiir::7jvvrrr7i::... i         \n"+
                black + "L5PEdDZggQRQQBQQ1i:SQQK2bQgESuLsvYYJsjLsYJsuJ22KqP51v7rrr7rririiiiiiii:::::i:7jsv7rrrv:.....:.  .:..  \n"+
                black +"BBBQQQBBBBBBBEJ:ijMgY:7qQRBRMqIYvrrrrr7rv7v77r7ii::::::::.:.::::i:iiir7ri:::rvuvL7rr77r..::    .r.    \n"+
                black +"UKPgBBBBQBdL...7jji    .isSDMQQQZKUJvv77rririi:i:i:i:i:::iirirrrr777ii:ri:.iJ1Lv77rrrvi...     .      \n"+
                black +"gQBBBQbv:    .:.           .rLSbgMQMRgZbPSXSqSXSXIXSKSS2IjssYY21jv7ii:i:::iv1sL7rrrrv7::.      :i     \n"+
                black +"77:.                           ..irsj2IKXKKbPdbbKPIIJjvsLsLsv7v7riii:iiirsu2sLrrrrr77iir:    .:       \n"+
                black +"                                  ..::rrvvsYYvLrririi:r7rivrr:iii:ii7vJj1sL7rrrrrr77i:.  .r:          \n"+
                black +"                               ...:i:iir7v7v7riirj5PPPXr  :j1J7ii7LjJJv7rririrrr7vvr..    .           \n"+
                black +"                                            .    .:ivv:      :YPRgdIJ77rrirrr7YYYi:.                  \n"+
                black +"                                                             .i77vr7rrr777vYsj7i.                     \n"+
                black +"                                                            .   .:r7vLJJusYri.                        \n"+
                black +"                                                 .:r        :LvjJU1usLri:.                            \n"+
                black +"                                              .:ii7i.     .i77vrri:.                                  \n"+
                black +"                                           .....     .ri   .                                          \n"+
                black +"                                                      i.                                              \n";

        hyperSkillImages[6]=purple +"                                                                                            i.  .r:                    \n"+
                purple +"                                                                                            :   ::                       \n"+
                purple +"                                                                                            i                             \n"+
                purple +"                                                                                                  .i                      \n"+
                purple +"                                                                                                  :                       \n"+
                purple +"                                                                                 . . ......i.    ...                      \n"+
                purple +"                                                                          ..::rirr7rriiii:rri::ii......                   \n"+
                purple +"                       ....:::.::..                                    ....:.:.::ii77ssvrriiirrr::::.:...                 \n"+
                purple +"                 .:ivYuJ1jjJJsJYjJjv7i:               ...                   ....iiiirr77u21vrirrrri:i::....               \n"+
                purple +"             .:7Y1U2121ussvvrrii:ii7JUUUv:        ..:r7vs11ur:           . .:::i:rr77L77rrrvv7r77777ir::....              \n"+
                purple +"          .:rr77YY1sJLsvYvvrrri::::...::irr:7s1uII5IX55UIUSXPPPs:       ..r7vL1IuvIUJ7r:i:::::::::rrrrrii:...             \n"+
                purple +"         . ..i7ssuYYLjsjLsLL7L77rrii:::i7uSbPPKqKqSqXKSK552SISSqq5Lrir::rvvsUPEZPs7vvririiiiii:::::::ii7ii:...            \n"+
                purple +"           .7u1JJLuuI1IU2j21212JLrri7j5XKII1UUSSqXPPEdDZDDgDgZgZMQBQBE2YJLJYLi:.:.  ..iL1JJsYv7rririi:::ri:....           \n"+
                purple +"         .iJ1UJuY1US252SSbbZPKsvr7YU25UUuUUKPgRBBBBBBBBBBBQBBBBBBBZSu5dRQR5Li:ir7:     .77rvvsJuL7rriri::ri:...           \n"+
                purple +"        .7UU1suYU5KXKqggQgPjvrr7JuUu11I5EZMQBBBQMPP5511j2U1uUuuYJs2bRQQZKLLJqMBQQgi.   :rii:i:r7uYvrrirr::i::..           \n"+
                purple +".irYuPgJiU1usjJ5KPPDggXLri::ivu215SPKZgQPPRBBDv7777J1I2I2KKqKbdggRggq2L7v5ZQRgqSJJ5Xu5s7irrr7r:irsYvrrrrr:::.:.           \n"+
                purple +"BQBBBQjiYJJvs1PbggE1r:::rv1XdbEdMMQQBQELuQBQILKdDddqPbZZgDgDgdEPKUuLJjKdQgdIjvvvYLYLjLYvrrriiir::7jvvrrr7i::... i         \n"+
                purple +"Qd5u7iisjujIqZZDS7r7L5PEdDZggQRQQBQQ1i:SQQK2bQgESuLsvYYJsjLsYJsuJ22KqP51v7rrr7rririiiiiiii:::::i:7jsv7rrrv:.....:.  .:..  \n"+
                purple +"i:iivj52XqdEDgDLLgBBBBBQQQBBBBBBBEJ:ijMgY:7qQRBRMqIYvrrrrr7rv7v77r7ii::::::::.:.::::i:iiir7ri:::rvuvL7rr77r..::    .r.    \n"+
                purple +"15SPqPbEbEPgDqi .irJUKPgBBBBQBdL...7jji    .isSDMQQQZKUJvv77rririi:i:i:i:i:::iirirrrr777ii:ri:.iJ1Lv77rrrvi...     .      \n"+
                purple +"RDgZDZgDgZPs:    .r1gQBBBQbv:    .:.           .rLSbgMQMRgZbPSXSqSXSXIXSKSS2IjssYY21jv7ii:i:::iv1sL7rrrrv7::.      :i     \n"+
                purple +"ivs1juv7:.    .:iLvv77:.                           ..irsj2IKXKKbPdbbKPIIJjvsLsLsv7v7riii:iiirsu2sLrrrrr77iir:    .:       \n"+
                purple +"                                                      ..::rrvvsYYvLrririi:r7rivrr:iii:ii7vJj1sL7rrrrrr77i:.  .r:          \n"+
                purple +"                                                   ...:i:iir7v7v7riirj5PPPXr  :j1J7ii7LjJJv7rririrrr7vvr..    .           \n"+
                purple +"                                                                .    .:ivv:      :YPRgdIJ77rrirrr7YYYi:.                  \n"+
                purple +"                                                                                 .i77vr7rrr777vYsj7i.                     \n"+
                purple +"                                                                                .   .:r7vLJJusYri.                        \n"+
                purple +"                                                                     .:r        :LvjJU1usLri:.                            \n"+
                purple +"                                                                  .:ii7i.     .i77vrri:.                                  \n"+
                purple +"                                                               .....     .ri   .                                          \n"+
                purple +"                                                                          i.                                              \n";

        hyperSkillImages[7]=white +"                                                                                                                i.  .r:                    \n"+
                white +"                                                                                                                :   ::                       \n"+
                white +"                                                                                                                i                             \n"+
                white +"                                                                                                                      .i                      \n"+
                white +"                                                                                                                      :                       \n"+
                white +"                                                                                                     . . ......i.    ...                      \n"+
                white +"                                                                                              ..::rirr7rriiii:rri::ii......                   \n"+
                white +"                                           ....:::.::..                                    ....:.:.::ii77ssvrriiirrr::::.:...                 \n"+
                white +"                                     .:ivYuJ1jjJJsJYjJjv7i:               ...                   ....iiiirr77u21vrirrrri:i::....               \n"+
                white +"                                 .:7Y1U2121ussvvrrii:ii7JUUUv:        ..:r7vs11ur:           . .:::i:rr77L77rrrvv7r77777ir::....              \n"+
                white +"                              .:rr77YY1sJLsvYvvrrri::::...::irr:7s1uII5IX55UIUSXPPPs:       ..r7vL1IuvIUJ7r:i:::::::::rrrrrii:...             \n"+
                white +"                             . ..i7ssuYYLjsjLsLL7L77rrii:::i7uSbPPKqKqSqXKSK552SISSqq5Lrir::rvvsUPEZPs7vvririiiiii:::::::ii7ii:...            \n"+
                white +"                               .7u1JJLuuI1IU2j21212JLrri7j5XKII1UUSSqXPPEdDZDDgDgZgZMQBQBE2YJLJYLi:.:.  ..iL1JJsYv7rririi:::ri:....           \n"+
                white +"                             .iJ1UJuY1US252SSbbZPKsvr7YU25UUuUUKPgRBBBBBBBBBBBQBBBBBBBZSu5dRQR5Li:ir7:     .77rvvsJuL7rriri::ri:...           \n"+
                white +"                            .7UU1suYU5KXKqggQgPjvrr7JuUu11I5EZMQBBBQMPP5511j2U1uUuuYJs2bRQQZKLLJqMBQQgi.   :rii:i:r7uYvrrirr::i::..           \n"+
                white +"                   ..irYuPgJiU1usjJ5KPPDggXLri::ivu215SPKZgQPPRBBDv7777J1I2I2KKqKbdggRggq2L7v5ZQRgqSJJ5Xu5s7irrr7r:irsYvrrrrr:::.:.           \n"+
                white +"              :r2PgBBQBBBQjiYJJvs1PbggE1r:::rv1XdbEdMMQQBQELuQBQILKdDddqPbZZgDgDgdEPKUuLJjKdQgdIjvvvYLYLjLYvrrriiir::7jvvrrr7i::... i         \n"+
                white +"           .iLIgQBBBQd5u7iisjujIqZZDS7r7L5PEdDZggQRQQBQQ1i:SQQK2bQgESuLsvYYJsjLsYJsuJ22KqP51v7rrr7rririiiiiiii:::::i:7jsv7rrrv:.....:.  .:..  \n"+
                white +".::iiirii::.:vgBBBdri:iivj52XqdEDgDLLgBBBBBQQQBBBBBBBEJ:ijMgY:7qQRBRMqIYvrrrrr7rv7v77r7ii::::::::.:.::::i:iiir7ri:::rvuvL7rr77r..::    .r.    \n"+
                white +"     ..:i7uMBBBBILrL15SPqPbEbEPgDqi .irJUKPgBBBBQBdL...7jji    .isSDMQQQZKUJvv77rririi:i:i:i:i:::iirirrrr777ii:ri:.iJ1Lv77rrrvi...     .      \n"+
                white +"...:rL2PBBBBBXusSEQQRDgZDZgDgZPs:    .r1gQBBBQbv:    .:.           .rLSbgMQMRgZbPSXSqSXSXIXSKSS2IjssYY21jv7ii:i:::iv1sL7rrrrv7::.      :i     \n"+
                white +"  .::7s1Lv:.   ..::rivs1juv7:.    .:iLvv77:.                           ..irsj2IKXKKbPdbbKPIIJjvsLsLsv7v7riii:iiirsu2sLrrrrr77iir:    .:       \n"+
                white +"                                                                          ..::rrvvsYYvLrririi:r7rivrr:iii:ii7vJj1sL7rrrrrr77i:.  .r:          \n"+
                white +"                                                                       ...:i:iir7v7v7riirj5PPPXr  :j1J7ii7LjJJv7rririrrr7vvr..    .           \n"+
                white +"                                                                                    .    .:ivv:      :YPRgdIJ77rrirrr7YYYi:.                  \n"+
                white +"                                                                                                     .i77vr7rrr777vYsj7i.                     \n"+
                white +"                                                                                                    .   .:r7vLJJusYri.                        \n"+
                white +"                                                                                         .:r        :LvjJU1usLri:.                            \n"+
                white +"                                                                                      .:ii7i.     .i77vrri:.                                  \n"+
                white +"                                                                                   .....     .ri   .                                          \n"+
                white +"                                                                                              i.                                              \n";

        hyperSkillImages[8]=white +"                                                                                                                         i.  .r:                    \n"+
                white +"                                                                                                                         :   ::                       \n"+
                white +"                                                                                                                        i                             \n"+
                white +"                                                                                                                              .i                      \n"+
                white +"                                                                                                                              :                       \n"+
                white +"                                                                                                             . . ......i.    ...                      \n"+
                black +"                                                                                                      ..::rirr7rriiii:rri::ii......                   \n"+
                black +"                                                   ....:::.::..                                    ....:.:.::ii77ssvrriiirrr::::.:...                 \n"+
                black +"                                             .:ivYuJ1jjJJsJYjJjv7i:               ...                   ....iiiirr77u21vrirrrri:i::....               \n"+
                black +"                                         .:7Y1U2121ussvvrrii:ii7JUUUv:        ..:r7vs11ur:           . .:::i:rr77L77rrrvv7r77777ir::....              \n"+
                purple +"                                      .:rr77YY1sJLsvYvvrrri::::...::irr:7s1uII5IX55UIUSXPPPs:       ..r7vL1IuvIUJ7r:i:::::::::rrrrrii:...             \n"+
                purple +"                                     . ..i7ssuYYLjsjLsLL7L77rrii:::i7uSbPPKqKqSqXKSK552SISSqq5Lrir::rvvsUPEZPs7vvririiiiii:::::::ii7ii:...            \n"+
                purple +"                                       .7u1JJLuuI1IU2j21212JLrri7j5XKII1UUSSqXPPEdDZDDgDgZgZMQBQBE2YJLJYLi:.:.  ..iL1JJsYv7rririi:::ri:....           \n"+
                purple +"                                     .iJ1UJuY1US252SSbbZPKsvr7YU25UUuUUKPgRBBBBBBBBBBBQBBBBBBBZSu5dRQR5Li:ir7:     .77rvvsJuL7rriri::ri:...           \n"+
                purple +"                                    .7UU1suYU5KXKqggQgPjvrr7JuUu11I5EZMQBBBQMPP5511j2U1uUuuYJs2bRQQZKLLJqMBQQgi.   :rii:i:r7uYvrrirr::i::..           \n"+
                purple +"                           ..irYuPgJiU1usjJ5KPPDggXLri::ivu215SPKZgQPPRBBDv7777J1I2I2KKqKbdggRggq2L7v5ZQRgqSJJ5Xu5s7irrr7r:irsYvrrrrr:::.:.           \n"+
                blue +"                      :r2PgBBQBBBQjiYJJvs1PbggE1r:::rv1XdbEdMMQQBQELuQBQILKdDddqPbZZgDgDgdEPKUuLJjKdQgdIjvvvYLYLjLYvrrriiir::7jvvrrr7i::... i         \n"+
                blue +"     .             .iLIgQBBBQd5u7iisjujIqZZDS7r7L5PEdDZggQRQQBQQ1i:SQQK2bQgESuLsvYYJsjLsYJsuJ22KqP51v7rrr7rririiiiiiii:::::i:7jsv7rrrv:.....:.  .:..  \n"+
                blue +"      ...::iiirii::.:vgBBBdri:iivj52XqdEDgDLLgBBBBBQQQBBBBBBBEJ:ijMgY:7qQRBRMqIYvrrrrr7rv7v77r7ii::::::::.:.::::i:iiir7ri:::rvuvL7rr77r..::    .r.    \n"+
                blue +"             ..:i7uMBBBBILrL15SPqPbEbEPgDqi .irJUKPgBBBBQBdL...7jji    .isSDMQQQZKUJvv77rririi:i:i:i:i:::iirirrrr777ii:ri:.iJ1Lv77rrrvi...     .      \n"+
                blue +"        ...:rL2PBBBBBXusSEQQRDgZDZgDgZPs:    .r1gQBBBQbv:    .:.           .rLSbgMQMRgZbPSXSqSXSXIXSKSS2IjssYY21jv7ii:i:::iv1sL7rrrrv7::.      :i     \n"+
                green +"          .::7s1Lv:.   ..::rivs1juv7:.    .:iLvv77:.                           ..irsj2IKXKKbPdbbKPIIJjvsLsLsv7v7riii:iiirsu2sLrrrrr77iir:    .:       \n"+
                green +"                                                                                  ..::rrvvsYYvLrririi:r7rivrr:iii:ii7vJj1sL7rrrrrr77i:.  .r:          \n"+
                green +"                                                                               ...:i:iir7v7v7riirj5PPPXr  :j1J7ii7LjJJv7rririrrr7vvr..    .           \n"+
                green +"                                                                                            .    .:ivv:      :YPRgdIJ77rrirrr7YYYi:.                  \n"+
                green +"                                                                                                             .i77vr7rrr777vYsj7i.                     \n"+
                red +"                                                                                                            .   .:r7vLJJusYri.                        \n"+
                red +"                                                                                                 .:r        :LvjJU1usLri:.                            \n"+
                red +"                                                                                              .:ii7i.     .i77vrri:.                                  \n"+
                red +"                                                                                           .....     .ri   .                                          \n"+
                red +"                                                                                                      i.                                              " + exit;
        for(int i=0; i<100; i++) {
            System.out.println("");
        }
        for(int i=0; i<hyperSkillImages.length; i++ ) {
            for(int j=0;j<50;j++) {
                System.out.println("");
            }
            System.out.println(hyperSkillImages[i]);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {

            }

        }
    }



    //-----------------------------보스 공격 효과---------------------------------
    public void executeBossAttack() {
        String[] attackImages=new String[34];

        attackImages[0]="                                                                                                                               .          ::";
        attackImages[1]="                                                                                                                            :.          7j: ";
        attackImages[2]="                                                                                                         :i.             .rr.        .1gL.  ";
        attackImages[3]="                                                                                                  .::.:vji.            iIJ:    ..  .qBP.    ";
        attackImages[4]="                                                                                               .:s1sjEKr       ::.   rZI:  .:2dL.idBQ:      ";
        attackImages[5]="                                                                                            .:vPQgMRP:      :7Y:  . :L. ..7RBM7rMBBr.       ";
        attackImages[6]="                                                                                         .:7SQBBQBU:     .rK2i  :r.   :ivgBBUuQBBJ..        ";
        attackImages[7]="                                                                                      .:72MBBBBgs.  . .:5DS: .7sr.:iUZgRBBRPBBBI:.          ";
        attackImages[8]="                                                                                    .rJdRBBBREv:.....vEQ2:.ijXs7vXgBBBBBBgQBBbi.            ";
        attackImages[9]="                                                                                 .:vqZMDZbDPji....i2QMU::rSKS2PMBBBRRRQgMQBMu:.             ";
        attackImages[10]="                                                                               .rIPDdqIXdE2Yr::i7PggJiisSKIPZRMMgMZgDgEDgBgU:.              ";
        attackImages[11]="                                                                            .:JqEq5ss1DgqjL77vUPDP177uXU1KQDbPPEPPgZbKdgBRJ.                ";
        attackImages[12]="                                                                          .7SDq2L7r2gQXJsIUUuSSSsLY221YSDgS5IXXPdgKXIZMQqr.                 ";
        attackImages[13]="                                                                       .ijdPI7r:ijgDULXDEUvv1uY7vLjvvJKbSJuu12bPXuUXdZEj:                   ";
        attackImages[14]="                                                                     :7PZK7i:.:2gQUYqBguirY2J7iririrvUbqYYLjIK1sLU5S5qv:                    ";
        attackImages[15]="                                                                  .i5DEYi:..rEBQBZQBDv..iJX52vrrrirrqQSr77Jus7vvuLJSqr.                     ";
        attackImages[16]="                                                                .vdQ5r...:sQBBSJ15Y:.  rbBQDvvsYrirKg7:rr777r7r7ruE2:.                      ";
        attackImages[17]="                                                              iUQDJ. ....i7i. :ii.  .vBBBg7.:iir7rjB2.iiririri:rPb7.                        ";
        attackImages[18]="                                                           .rZBZi   ...... .:r:   .SBBB5:   :72Jr7Db.::::i::::JgU:                          ";
        attackImages[19]="                                                        .:UQBI.       ... ...   iRBBBr    :2gX7:r2r...:::::.iPZr.                           ";
        attackImages[20]="                                                      .7PBMv         ...      jBBBS.    idQPr:.ii.YQ..... .1g1.                             ";
        attackImages[21]="                                                    :sQBK.        iBBB5.   .gQBBr     vZQ5r...:..IBi ..  igPi                               ";
        attackImages[22]="                                                 .iKBQL     .r:.2BBB5.   7BBBq.    .jgPvi: ... .LBE     IQv.                                ";
        attackImages[23]="                                              ..vdBDr     sRBMdBBBi    PBQBr     .KgI:. .:... .igB.   rRP:                                  ";
        attackImages[24]="                                             .7bQEi    .2RKvrIQZ.   :BBBP.     rEMY.         .:PQ:   bM7.                                   ";
        attackImages[25]="                                            .sgqi    iEgu::rqS.   1BBQL      YRb7.           .1E:  7BI:                                     ";
        attackImages[26]="                                           .LQX   .UgZ7..:7K.  .DBBB.     .KRK:.            .rPr .PEi.                                      ";
        attackImages[27]="                                          .rDY  :bB5i   .i2. iBBBg.     rEMJ:              .:7X.:PY.                                        ";
        attackImages[28]="                                         .i2i iEDu:    .:j7rQBBX      LRdv.                .:1jr7:                                          ";
        attackImages[29]="                                        .:s7ruUi.      .riLPBS   .7:JDqi.                  .ri...                                           ";
        attackImages[30]="                                        .vri::         ..:vPv  rZPvuv:                                                                      ";
        attackImages[31]="                                        ..              .rUr.iKIr..                                                                         ";
        attackImages[32]="                                                       :7jrirr.                                                                             ";
        attackImages[33]="                                                      .ii....                                                                               ";
        for(int i=0; i<1000; i++) {
            System.out.println("");
        }
        for(int i=0; i<attackImages.length; i++ ) {
            System.out.println(attackImages[i]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }

    public void executeBossSkill() {
        String[] skillImages=new String[6];

        skillImages[0]="                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                   .ir:   \n"+
                "                                                                                                    .SQBBB\n"+
                "                                                                                                      r.jg\n"+
                "                                                                                                       .  \n"+
                "                                                                                                       ...\n"+
                "                                                                                                     .EXuu\n"+
                "                                                                                                     7BRLr\n"+
                "                                                                                                         v\n"+
                "                                                                                                  .:i.Y   \n"+
                "                                                                                                  :IE.uu7.\n"+
                "                                                                                                  ..:..:j.\n"+
                "                                                                                                     ...i5\n"+
                "                                                                                                      .7:.\n"+
                "                                                                                                       ...\n"+
                "                                                                                                        .U\n"+
                "                                                                                                         .\n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          ";

        skillImages[1]="                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                          \n"+
                "                                                                                                     ... 7\n"+
                "                                                                                                  ..... vB\n"+
                "                                                                                         .     . ....i vBB\n"+
                "                                                                                         .v.  ......7.YBBE\n"+
                "                                                                                          JB7...:..7UXBBBU\n"+
                "                                                                                        . uBX..r:.vgBBBDBg\n"+
                "                                                                                       ..i   .JBrbBBBBEQBQ\n"+
                "                                                                               .ir:   ..:s..  5QBBBBBPgQBB\n"+
                "                                                                                .SQBBBU 57.. iBBBBBBPgQQQB\n"+
                "                                                                                  r.jg  BSri.5BBBBBKKBggBQ\n"+
                "                                                                                   .   BBBQBdBBMQBDsRDqBBB\n"+
                "                                                                                   ...DBBQBBBBQqQZvIZrgBBQ\n"+
                "                                                                                 .EXuuQBBBBBQBK777iIirBQQM\n"+
                "                                                                                 7BRLrdRdsBKUPv.::rr.LPIE1\n"+
                "                                                                                    vRi.SBRPbv77:ii:JJ7Y7\n"+
                "                                                                              .:i.Y   g1iBBBBDSMP:i:iu7i7v\n"+
                "                                                                              :IE.uu7. rBBBBQMDBssuriMv77D\n"+
                "                                                                              ..:..:j.vBBQZBQMBBrIguIBBgIB\n"+
                "                                                                                 ...i5B7. PBQBQgrXRQQBBBdB\n"+
                "                                                                                  .7:.JBI PMBBBd7XBBBBBBBB\n"+
                "                                                                                   ... :. r2gBBDYDBBQBBBBB\n"+
                "                                                                                    .UiLB .:5BBZ5QBBBBBQBB\n"+
                "                                                                                     .PBB.  rBBMPBQBBBPBBB\n"+
                "                                                                                        :b7 :BBMRBBE.2:QBg\n"+
                "                                                                                         7: .BBBBBB:   BBv\n"+
                "                                                                                            .QBBBBg   :Rr:\n"+
                "                                                                                            .BBBBB. ..:v .\n"+
                "                                                                                            .BBQBS  ......\n"+
                "                                                                                             :PBE27Y..   .\n"+
                "                                                                                            . vBL:iu7     \n"+
                "                                                                                            ..rB..        \n"+
                "                                                                                            ..:7  .       \n"+
                "                                                                                             ..:          ";

        skillImages[2]="                                                                                                 .  ..    \n"+
                "                                                                                                 .. .K:   \n"+
                "                                                                                                 :..vB:   \n"+
                "                                                                                                r:. BE    \n"+
                "                                                                                           ... 77. iBB.   \n"+
                "                                                                                        ..... vBI.. :i.   \n"+
                "                                                                               .     . ....i vBBr .. :S:  \n"+
                "                                                                               .v.  ......7.YBBE  .       \n"+
                "                                                                                JB7...:..7UXBBBU .        \n"+
                "                                                                              . uBX..r:.vgBBBDBg  ..... .L\n"+
                "                                                                             ..i   .JBrbBBBBEQBQr. ... rBM\n"+
                "                                                                     .ir:   ..:s..  5QBBBBBPgQBBBI .: 1d: \n"+
                "                                                                      .SQBBBU 57.. iBBBBBBPgQQQBB  Dg2Qi .\n"+
                "                                                                        r.jg  BSri.5BBBBBKKBggBQg 5BjgQPi \n"+
                "                                                                         .   BBBQBdBBMQBDsRDqBBBQBBBPBBY.j\n"+
                "                                                                         ...DBBQBBBBQqQZvIZrgBBQBBBBBQBQMB\n"+
                "                                                                       .EXuuQBBBBBQBK777iIirBQQMRBBBBQgBBB\n"+
                "                                                                       7BRLrdRdsBKUPv.::rr.LPIE1QBDUQZBBBb\n"+
                "                                                                           vRi.SBRPbv77:ii:JJ7Y7PbLsZqbQ17\n"+
                "                                                                    .:i.Y   g1iBBBBDSMP:i:iu7i7vPU7sZIqS:7\n"+
                "                                                                    :IE.uu7. rBBBBQMDBssuriMv77DQbr2EMBgjd\n"+
                "                                                                    ..:..:j.vBBQZBQMBBrIguIBBgIBBQuQBgBBBB\n"+
                "                                                                       ...i5B7. PBQBQgrXRQQBBBdBBBQBBBBDBB\n"+
                "                                                                        .7:.JBI PMBBBd7XBBBBBBBBBBBBBBB.rQ\n"+
                "                                                                         ... :. r2gBBDYDBBQBBBBBBBBBrEK  7\n"+
                "                                                                          .UiLB .:5BBZ5QBBBBBQBBBBB: J:  r\n"+
                "                                                                           .PBB.  rBBMPBQBBBPBBBBB7  : . i\n"+
                "                                                                              :b7 :BBMRBBE.2:QBgBBL . ....\n"+
                "                                                                               7: .BBBBBB:   BBvM..jQ7 .  \n"+
                "                                                                                  .QBBBBg   :Rr:i.BBr.R.  \n"+
                "                                                                                  .BBBBB. ..:v . iDS1Pi   \n"+
                "                                                                                  .BBQBS  .......     2i  \n"+
                "                                                                                   :PBE27Y..   ...EqSULri.\n"+
                "                                                                                  . vBL:iu7       iv77  . \n"+
                "                                                                                  ..rB..                  \n"+
                "                                                                                  ..:7  .                 \n"+
                "                                                                                   ..:                    ";

        skillImages[3]="                                                                          .  ..                           \n"+
                "                                                                          .. .K:                          \n"+
                "                                                                         :..vB:                           \n"+
                "                                                                        r:. BE                            \n"+
                "                                                                   ... 77. iBB.                           \n"+
                "                                                                ..... vBI.. :i.                           \n"+
                "                                                       .     . ....i vBBr .. :S:     .                    \n"+
                "                                                       .v.  ......7.YBBE  .                               \n"+
                "                                                        JB7...:..7UXBBBU .           .                 J7 \n"+
                "                                                      . uBX..r:.vgBBBDBg  ..... .L2...i.             .gg  \n"+
                "                                                     ..i   .JBrbBBBBEQBQr. ... rBMr..:r. .       iXDIBBBi \n"+
                "                                             .ir:   ..:s..  5QBBBBBPgQBBBI .: 1d: ....:....      :1BBQJ7: \n"+
                "                                              .SQBBBU 57.. iBBBBBBPgQQQBB  Dg2Qi .  iY.:....   .   X:     \n"+
                "                                                r.jg  BSri.5BBBBBKKBggBQg 5BjgQPi  rBX7:::..... .KY:      \n"+
                "                                                 .   BBBQBdBBMQBDsRDqBBBQBBBPBBY.jKBQJ .v:7...rQP7. :B7  .\n"+
                "                                                 ...DBBQBBBBQqQZvIZrgBBQBBBBBQBQMBBBQ .Zir:...:SMr.r7.    \n"+
                "                                               .EXuuQBBBBBQBK777iIirBQQMRBBBBQgBBBgBgiBB j. ..  . :Sr IB1P\n"+
                "                                               7BRLrdRdsBKUPv.::rr.LPIE1QBDUQZBBBbZBBBBQjb  rP  ..BQBBBBBQ\n"+
                "                                                   vRi.SBRPbv77:ii:JJ7Y7PbLsZqbQ17EBBBBQBJ iQ..BBBBBQBBBQR\n"+
                "                                            .:i.Y   g1iBBBBDSMP:i:iu7i7vPU7sZIqS:7gQSPBBB5.Bs.BBQEPQEQBqMB\n"+
                "                                            :IE.uu7. rBBBBQMDBssuriMv77DQbr2EMBgjdgPLgQBBRBB.BB2EBBBBB2PBQ\n"+
                "                                            ..:..:j.vBBQZBQMBBrIguIBBgIBBQuQBgBBBBBXbEQBBBBRMBBQMBB7Bg.YP \n"+
                "                                               ...i5B7. PBQBQgrXRQQBBBdBBBQBBBBDBBBBMEEDBBQZgBBg.1j.iBiXP \n"+
                "                                                .7:.JBI PMBBBd7XBBBBBBBBBBBBBBB.rQBQBRKvqMBgPBB. ii.iQKv:.\n"+
                "                                                 ... :. r2gBBDYDBBQBBBBBBBBBrEK  7BBBBBRKS2IQBP..r..   :..\n"+
                "                                                  .UiLB .:5BBZ5QBBBBBQBBBBB: J:  rBDqBBBQZBQBBj ........  \n"+
                "                                                   .PBB.  rBBMPBQBBBPBBBBB7  : . iB. BQBBBBQQXs   ....    \n"+
                "                                                      :b7 :BBMRBBE.2:QBgBBL . ....i   bBBB.SBvDPBdi..     \n"+
                "                                                       7: .BBBBBB:   BBvM..jQ7 .   .  BBM. BB  .:: :.     \n"+
                "                                                          .QBBBBg   :Rr:i.BBr.R.      dU   RBi .r:::.     \n"+
                "                                                          .BBBBB. ..:v . iDS1Pi      .L  .  ZM .:uBU      \n"+
                "                                                          .BBQBS  .......     2i      QX .. r7            \n"+
                "                                                           :PBE27Y..   ...EqSULri. . vB: ..:7.            \n"+
                "                                                          . vBL:iu7       iv77  . .  sB.                  \n"+
                "                                                          ..rB..                     7B.                  \n"+
                "                                                          ..:7  .                    r7                   \n"+
                "                                                           ..:                                            ";

        skillImages[4]="                                                       .  ..                                              \n"+
                "                                                      .. .K:                                              \n"+
                "                                                     :..vB:                                               \n"+
                "                                                    r:. BE                                                \n"+
                "                                               ... 77. iBB.                                               \n"+
                "                                            ..... vBI.. :i.                                               \n"+
                "                                   .     . ....i vBBr .. :S:     .                                        \n"+
                "                                   .v.  ......7.YBBE  .                                                   \n"+
                "                                    JB7...:..7UXBBBU .           .                 J7                     \n"+
                "                                  . uBX..r:.vgBBBDBg  ..... .L2...i.             .gg                      \n"+
                "                                 ..i   .JBrbBBBBEQBQr. ... rBMr..:r. .       iXDIBBBi                     \n"+
                "                         .ir:   ..:s..  5QBBBBBPgQBBBI .: 1d: ....:....      :1BBQJ7:                     \n"+
                "                          .SQBBBU 57.. iBBBBBBPgQQQBB  Dg2Qi .  iY.:....   .   X:                         \n"+
                "                            r.jg  BSri.5BBBBBKKBggBQg 5BjgQPi  rBX7:::..... .KY:                          \n"+
                "                             .   BBBQBdBBMQBDsRDqBBBQBBBPBBY.jKBQJ .v:7...rQP7. :B7  .  :YRj              \n"+
                "                             ...DBBQBBBBQqQZvIZrgBBQBBBBBQBQMBBBQ .Zir:...:SMr.r7.      :.i. .i           \n"+
                "                           .EXuuQBBBBBQBK777iIirBQQMRBBBBQgBBBgBgiBB j. ..  . :Sr IB1PIKv  . 7:  .        \n"+
                "                           7BRLrdRdsBKUPv.::rr.LPIE1QBDUQZBBBbZBBBBQjb  rP  ..BQBBBBBQBBB.. .Y.........   \n"+
                "                               vRi.SBRPbv77:ii:JJ7Y7PbLsZqbQ17EBBBBQBJ iQ..BBBBBQBBBQRQBsiQi:r.  ..::..i..\n"+
                "                        .:i.Y   g1iBBBBDSMP:i:iu7i7vPU7sZIqS:7gQSPBBB5.Bs.BBQEPQEQBqMBBBBBKg2i. : v7:  EZ \n"+
                "                        :IE.uu7. rBBBBQMDBssuriMv77DQbr2EMBgjdgPLgQBBRBB.BB2EBBBBB2PBQQPKBPBQRXBBDBBQb:.QB\n"+
                "                        ..:..:j.vBBQZBQMBBrIguIBBgIBBQuQBgBBBBBXbEQBBBBRMBBQMBB7Bg.YP .2XDBBBBBBBBBuBBMBB7\n"+
                "                           ...i5B7. PBQBQgrXRQQBBBdBBBQBBBBDBBBBMEEDBBQZgBBg.1j.iBiXP  7.7BD1PBBBBr  5QBY \n"+
                "                            .7:.JBI PMBBBd7XBBBBBBBBBBBBBBB.rQBQBRKvqMBgPBB. ii.iQKv:..   YvJSBS::  .1QB2Y\n"+
                "                             ... :. r2gBBDYDBBQBBBBBBBBBrEK  7BBBBBRKS2IQBP..r..   :.. .   .YP:  .. IBBBBB\n"+
                "                              .UiLB .:5BBZ5QBBBBBQBBBBB: J:  rBDqBBBQZBQBBj ........      ..i.  ..i:JBB 7:\n"+
                "                               .PBB.  rBBMPBQBBBPBBBBB7  : . iB. BQBBBBQQXs   ....       . .......PBBs    \n"+
                "                                  :b7 :BBMRBBE.2:QBgBBL . ....i   bBBB.SBvDPBdi..         ::.:..:::BB   . \n"+
                "                                   7: .BBBBBB:   BBvM..jQ7 .   .  BBM. BB  .:: :.         ..YL....7Z.     \n"+
                "                                      .QBBBBg   :Rr:i.BBr.R.      dU   RBi .r:::.           . ... 7.      \n"+
                "                                      .BBBBB. ..:v . iDS1Pi      .L  .  ZM .:uBU                          \n"+
                "                                      .BBQBS  .......     2i      QX .. r7                                \n"+
                "                                       :PBE27Y..   ...EqSULri. . vB: ..:7.                                \n"+
                "                                      . vBL:iu7       iv77  . .  sB.                                      \n"+
                "                                      ..rB..                     7B.                                      \n"+
                "                                      ..:7  .                    r7                                       \n"+
                "                                       ..:                                                                ";

        skillImages[5]="                                     .  ..                                                                \n"+
                "                                    .. .K:                                                                \n"+
                "                                   :..vB:                                                                 \n"+
                "                                  r:. BE                                                                  \n"+
                "                             ... 77. iBB.                                                                 \n"+
                "                          ..... vBI.. :i.                                                                 \n"+
                "                 .     . ....i vBBr .. :S:     .                                                          \n"+
                "                 .v.  ......7.YBBE  .                                                                     \n"+
                "                  JB7...:..7UXBBBU .           .                 J7                                       \n"+
                "                . uBX..r:.vgBBBDBg  ..... .L2...i.             .gg                                        \n"+
                "               ..i   .JBrbBBBBEQBQr. ... rBMr..:r. .       iXDIBBBi                                       \n"+
                "       .ir:   ..:s..  5QBBBBBPgQBBBI .: 1d: ....:....      :1BBQJ7:                                       \n"+
                "        .SQBBBU 57.. iBBBBBBPgQQQBB  Dg2Qi .  iY.:....   .   X:                                           \n"+
                "          r.jg  BSri.5BBBBBKKBggBQg 5BjgQPi  rBX7:::..... .KY:                                            \n"+
                "           .   BBBQBdBBMQBDsRDqBBBQBBBPBBY.jKBQJ .v:7...rQP7. :B7  .  :YRj                                \n"+
                "           ...DBBQBBBBQqQZvIZrgBBQBBBBBQBQMBBBQ .Zir:...:SMr.r7.      :.i. .i                             \n"+
                "         .EXuuQBBBBBQBK777iIirBQQMRBBBBQgBBBgBgiBB j. ..  . :Sr IB1PIKv  . 7:  .                          \n"+
                "         7BRLrdRdsBKUPv.::rr.LPIE1QBDUQZBBBbZBBBBQjb  rP  ..BQBBBBBQBBB.. .Y.........                     \n"+
                "             vRi.SBRPbv77:ii:JJ7Y7PbLsZqbQ17EBBBBQBJ iQ..BBBBBQBBBQRQBsiQi:r.  ..::..i..i...s.            \n"+
                "      .:i.Y   g1iBBBBDSMP:i:iu7i7vPU7sZIqS:7gQSPBBB5.Bs.BBQEPQEQBqMBBBBBKg2i. : v7:  EZ :..:RrYQ.r        \n"+
                "      :IE.uu7. rBBBBQMDBssuriMv77DQbr2EMBgjdgPLgQBBRBB.BB2EBBBBB2PBQQPKBPBQRXBBDBBQb:.QB7 :.  ir.EQSJ:    \n"+
                "      ..:..:j.vBBQZBQMBBrIguIBBgIBBQuQBgBBBBBXbEQBBBBRMBBQMBB7Bg.YP .2XDBBBBBBBBBuBBMBB7:.i irbv:7j::.    \n"+
                "         ...i5B7. PBQBQgrXRQQBBBdBBBQBBBBDBBBBMEEDBBQZgBBg.1j.iBiXP  7.7BD1PBBBBr  5QBY  KgPBBZ: ..s.     \n"+
                "          .7:.JBI PMBBBd7XBBBBBBBBBBBBBBB.rQBQBRKvqMBgPBB. ii.iQKv:..   YvJSBS::  .1QB2YBBBBB:  .  :.     \n"+
                "           ... :. r2gBBDYDBBQBBBBBBBBBrEK  7BBBBBRKS2IQBP..r..   :.. .   .YP:  .. IBBBBBBiJDi             \n"+
                "            .UiLB .:5BBZ5QBBBBBQBBBBB: J:  rBDqBBBQZBQBBj ........      ..i.  ..i:JBB 7:  7i              \n"+
                "             .PBB.  rBBMPBQBBBPBBBBB7  : . iB. BQBBBBQQXs   ....       . .......PBBs     ..               \n"+
                "                :b7 :BBMRBBE.2:QBgBBL . ....i   bBBB.SBvDPBdi..         ::.:..:::BB   .                   \n"+
                "                 7: .BBBBBB:   BBvM..jQ7 .   .  BBM. BB  .:: :.         ..YL....7Z.                       \n"+
                "                    .QBBBBg   :Rr:i.BBr.R.      dU   RBi .r:::.           . ... 7.                        \n"+
                "                    .BBBBB. ..:v . iDS1Pi      .L  .  ZM .:uBU                                            \n"+
                "                    .BBQBS  .......     2i      QX .. r7                                                  \n"+
                "                     :PBE27Y..   ...EqSULri. . vB: ..:7.                                                  \n"+
                "                    . vBL:iu7       iv77  . .  sB.                                                        \n"+
                "                    ..rB..                     7B.                                                        \n"+
                "                    ..:7  .                    r7                                                         \n"+
                "                     ..:                                                                                  ";
        for(int i=0; i<100; i++) {
            System.out.println("");
        }
        for(int i=0; i<skillImages.length; i++ ) {
            for(int j=0;j<50;j++) {
                System.out.println("");
            }
            System.out.println(skillImages[i]);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {

            }
        }
    }


    public void executeBossHyperSkill() {
        String[] hyperSkillImages=new String[7];

        hyperSkillImages[0]="                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                              ..\n"+
                "                                                                                                                                            ...:\n"+
                "                                                                                                                                            ..:v\n"+
                "                                                                                                                                           ..i7J\n"+
                "                                                                                                                                         ..:irv1\n"+
                "                                                                                                                                     ....:i7ivQu\n"+
                "                                                                                                                                  .....:i7J7iQB1\n"+
                "                                                                                                                                 ..::YXPKYi:vEXv\n"+
                "                                                                                                                                ..:rX5js7vJ55vLK\n"+
                "                                                                                                                                ..:Li ..75PY:2gX\n"+
                "                                                                                                                                .:iY   sQ7i:bBL.\n"+
                "                                                                                                                                ..:7:. DE.:iBP.i\n"+
                "                                                                                                                                 ..:::vBE:i:Iu..\n"+
                "                                                                                                                                  ...::su.......\n"+
                "                                                                                                                                     .. ....  ..\n"+
                "                                                                                                                                              .:\n"+
                "                                                                                                                                              .u\n"+
                "                                                                                                                                              .:\n"+
                "                                                                                                                                               .\n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                ";

        hyperSkillImages[1]="                                                                                                                                               :\n"+
                "                                                                                                                                            ....\n"+
                "                                                                                                                                   .rIqSui.  .. \n"+
                "                                                                                                                              .is2bDMQQBBBBQU:.:\n"+
                "                                                                                                                            ....        .iUMBBgb\n"+
                "                                                                                                                                       ...:72SZB\n"+
                "                                                                                                                                      ...rLvrvrY\n"+
                "                                                                                                                                       :I2vv:Jj \n"+
                "                                                                                                                            .rs5EZKU7sZQS7r.rEP.\n"+
                "                                                                                                                          ..ri::7JIdEqs. .:7gBS.\n"+
                "                                                                                                                        ...:iYUSK5srii7IqKgBBK7U\n"+
                "                                                                                                                        ..:v2X1JjUUYs2qgBBBBPII7\n"+
                "                                                                                                                       ..i7J1vsJ. .::rr7UPKur.  \n"+
                "                                                                                                                     ..:irv1:72   ivsLL7:       \n"+
                "                                                                                                                 ....:i7ivQu71  rvrrvvr.  .rvrru\n"+
                "                                                                                                              .....:i7J7iQB155Xqv:7s1JvvviYSP:  \n"+
                "                                                                                                             ..::YXPKYi:vEXvvu1uuvrvj1U22L:PBgj:\n"+
                "                                                                                                            ..:rX5js7vJ55vLKPKXKPq7ir77rvq2LXQBQ\n"+
                "                                                                                                            ..:Li ..75PY:2gXY7777sKPj77. YQQKPgQ\n"+
                "                                                                                                            .:iY   sQ7i:bBL.i7vv7ri1QBBBPbgBBBBB\n"+
                "                                                                                                            ..:7:. DE.:iBP.irr7LJ1Yr71dQBBQPvs7r\n"+
                "                                                                                                             ..:::vBE:i:Iu....:i7s1j7.iKQBg..i::\n"+
                "                                                                                                              ...::su.......:::iv12uvvUqPBZ:r7i:\n"+
                "                                                                                                                 .. ....  ..:Yuvvssvri:rPMPLii:.\n"+
                "                                                                                                                          .:..rjr     rdZJr:::: \n"+
                "                                                                                                                          .uSj7sb5YLLXQZi:7v:i: \n"+
                "                                                                                                                          .:JSqZMBBBBBBBEP1i.ii \n"+
                "                                                                                                                           ....::iisqK2Yi... r1 \n"+
                "                                                                                                                            .........   ...  iR.\n"+
                "                                                                                                                               .........      gB\n"+
                "                                                                                                                                              .B\n"+
                "                                                                                                                                               i\n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                \n"+
                "                                                                                                                                                ";

        hyperSkillImages[2]="                                                                                                                          .::.                 :\n"+
                "                                                                                                                    ....:rI5r:sPDdKI7:.     rBQi\n"+
                "                                                                                                           .rIqSui.  ..   rRBBBgbqqddPZM2    :BB\n"+
                "                                                                                                      .is2bDMQQBBBBQU:.:5MRX7IPY    .rSqgR    :B\n"+
                "                                                                                                    ....        .iUMBBgbU7i  L5Rj     .BdBg    r\n"+
                "                                                                                                               ...:72SZBI:rivKIBQj.:.  .BgB5   7\n"+
                "                                                                                                              ...rLvrvrYQI..1BUMB1 si  .BBBB  .j\n"+
                "                                                                                                               :I2vv:Jj 2Bi:ZBidB7 P: 7PBQDBi : \n"+
                "                                                                                                    .rs5EZKU7sZQS7r.rEP.rBRKDviBQ:7grXBBBSdBr  .\n"+
                "                                                                                                  ..ri::7JIdEqs. .:7gBS.5BEv.:BB2jZMQBBBurMQ  :Q\n"+
                "                                                                                                ...:iYUSK5srii7IqKgBBK7UEr  sBQrsQBBQbBP uQgiuBB\n"+
                "                                                                                                ..:v2X1JjUUYs2qgBBBBPII7  .72. rZBBBEZP rRBBMBBQ\n"+
                "                                                                                               ..i7J1vsJ. .::rr7UPKur.        JXXbBBBJ iRBBQZgMg\n"+
                "                                                                                             ..:irv1:72   ivsLL7:             ..:jRgi vQQQRDDgRg\n"+
                "                                                                                         ....:i7ivQu71  rvrrvvr.  .rvrruPsi7XdU7rSP  2BQMMQQRgEI\n"+
                "                                                                                      .....:i7J7iQB155Xqv:7s1JvvviYSP:  gu :KPLKQI  ZBKPQBQdPKI5\n"+
                "                                                                                     ..::YXPKYi:vEXvvu1uuvrvj1U22L:PBgj:sQL7quvPY .BBjvdBDi iJPM\n"+
                "                                                                                    ..:rX5js7vJ55vLKPKXKPq7ir77rvq2LXQBQgBBgPPXr :BBjiURBg2YLdBQ\n"+
                "                                                                                    ..:Li ..75PY:2gXY7777sKPj77. YQQKPgQQQQRQZi 7BBI.:UPbgQBBBBR\n"+
                "                                                                                    .:iY   sQ7i:bBL.i7vv7ri1QBBBPbgBBBBBBRSPDv XBQLY. ruUqgBBQDX\n"+
                "                                                                                    ..:7:. DE.:iBP.irr7LJ1Yr71dQBBQPvs7r7: rs:EBBRSs   jIKbgEbbZ\n"+
                "                                                                                     ..:::vBE:i:Iu....:i7s1j7.iKQBg..i::: 7PiSBBBQBD:  rIqQD2dgg\n"+
                "                                                                                      ...::su.......:::iv12uvvUqPBZ:r7i: :BsvBBJLRBBK  .1qBQgRgg\n"+
                "                                                                                         .. ....  ..:Yuvvssvri:rPMPLii:. EQiKBq  YQBB.  .7gBQQgg\n"+
                "                                                                                                  .:..rjr     rdZJr:::: rBX:gB  .:bBBs    iBBgZR\n"+
                "                                                                                                  .uSj7sb5YLLXQZi:7v:i: EBjiBE  .:1BBE:    :EBRP\n"+
                "                                                                                                  .:JSqZMBBBBBBBEP1i.ii gBKigB:   .PBQEJ:    :PD\n"+
                "                                                                                                   ....::iisqK2Yi... r1 1BBbPBBq7:ivZBBBMPur.  .\n"+
                "                                                                                                    .........   ...  iR. DBBBBBBBBBMgRBBBBBBQbU7\n"+
                "                                                                                                       .........      gB  idBBBBBBBBBBP2MBBBBBQM\n"+
                "                                                                                                                      .BBJ   .v2XXIs7:  :LXgBBBB\n"+
                "                                                                                                                       iBBBRv         .::::i7sIK\n"+
                "                                                                                                                         7DBBBZ1i.    ...:::::::\n"+
                "                                                                                                                                          ....::\n"+
                "                                                                                                                                               .";
        hyperSkillImages[3]="                                                                                                      .::.                 :s.                  \n"+
                "                                                                                                    ....:rI5r:sPDdKI7:.     rBQi                \n"+
                "                                                                                           .rIqSui.  ..   rRBBBgbqqddPZM2    :BBI               \n"+
                "                                                                                      .is2bDMQQBBBBQU:.:5MRX7IPY    .rSqgR    :BBi              \n"+
                "                                                                                    ....        .iUMBBgbU7i  L5Rj     .BdBg    rB7              \n"+
                "                                                                                               ...:72SZBI:rivKIBQj.:.  .BgB5   7P               \n"+
                "                                                                                              ...rLvrvrYQI..1BUMB1 si  .BBBB  .j  .j            \n"+
                "                                                                                               :I2vv:Jj 2Bi:ZBidB7 P: 7PBQDBi :  iBS            \n"+
                "                                                                                    .rs5EZKU7sZQS7r.rEP.rBRKDviBQ:7grXBBBSdBr  .XBB.            \n"+
                "                                                                                  ..ri::7JIdEqs. .:7gBS.5BEv.:BB2jZMQBBBurMQ  :QBB1           .:\n"+
                "                                                                                ...:iYUSK5srii7IqKgBBK7UEr  sBQrsQBBQbBP uQgiuBBBE       .LEBBBB\n"+
                "                                                                                ..:v2X1JjUUYs2qgBBBBPII7  .72. rZBBBEZP rRBBMBBQdri.  .IBBBBgs. \n"+
                "                                                                               ..i7J1vsJ. .::rr7UPKur.        JXXbBBBJ iRBBQZgMgP1  7gBBBZi     \n"+
                "                                                                             ..:irv1:72   ivsLL7:             ..:jRgi vQQQRDDgRg2.igBBB2      .v\n"+
                "                                                                         ....:i7ivQu71  rvrrvvr.  .rvrruPsi7XdU7rSP  2BQMMQQRgEI75BBBR.       ..\n"+
                "                                                                      .....:i7J7iQB155Xqv:7s1JvvviYSP:  gu :KPLKQI  ZBKPQBQdPKI5gBBBg.    ::   :\n"+
                "                                                                     ..::YXPKYi:vEXvvu1uuvrvj1U22L:PBgj:sQL7quvPY .BBjvdBDi iJPMQRBgi   rKs  2QB\n"+
                "                                                                    ..:rX5js7vJ55vLKPKXKPq7ir77rvq2LXQBQgBBgPPXr :BBjiURBg2YLdBQRQMJi7SQMY  QBBU\n"+
                "                                                                    ..:Li ..75PY:2gXY7777sKPj77. YQQKPgQQQQRQZi 7BBI.:UPbgQBBBBRZKj2EBQPi  BBB. \n"+
                "                                                                    .:iY   sQ7i:bBL.i7vv7ri1QBBBPbgBBBBBBRSPDv XBQLY. ruUqgBBQDXSPRBg5v  :BBK  .\n"+
                "                                                                    ..:7:. DE.:iBP.irr7LJ1Yr71dQBBQPvs7r7: rs:EBBRSs   jIKbgEbbZMQRXv:  5BB7  :i\n"+
                "                                                                     ..:::vBE:i:Iu....:i7s1j7.iKQBg..i::: 7PiSBBBQBD:  rIqQD2dggRgIi  :BBQ. ivLv\n"+
                "                                                                      ...::su.......:::iv12uvvUqPBZ:r7i: :BsvBBJLRBBK  .1qBQgRggRS  .DBBY :PY777\n"+
                "                                                                         .. ....  ..:Yuvvssvri:rPMPLii:. EQiKBq  YQBB.  .7gBQQggQ2:IBB2  5QjirLP\n"+
                "                                                                                  .:..rjr     rdZJr:::: rBX:gB  .:bBBs    iBBgZRQBBQJ..1BBPsL5gB\n"+
                "                                                                                  .uSj7sb5YLLXQZi:7v:i: EBjiBE  .:1BBE:    :EBRPqPKj1EBQEqXKEQBg\n"+
                "                                                                                  .:JSqZMBBBBBBBEP1i.ii gBKigB:   .PBQEJ:    :PDSvrrYUI5SPDgDQBr\n"+
                "                                                                                   ....::iisqK2Yi... r1 1BBbPBBq7:ivZBBBMPur.  .uqEEbKS5XKX1PBX \n"+
                "                                                                                    .........   ...  iR. DBBBBBBBBBMgRBBBBBBQbU7iiir7Ls2qbPEgXr.\n"+
                "                                                                                       .........      gB  idBBBBBBBBBBP2MBBBBBQMEqISqERQQRgPur..\n"+
                "                                                                                                      .BBJ   .v2XXIs7:  :LXgBBBBBBBBBBBBBQQQggZX\n"+
                "                                                                                                       iBBBRv         .::::i7sIKdDDDgRRRMDdP5jsi\n"+
                "                                                                                                         7DBBBZ1i.    ...::::::::::::iiii::....:\n"+
                "                                                                                                                          ....::::ii::::::....  \n"+
                "                                                                                                                               ............     ";

        hyperSkillImages[4]="                                                                                  .::.                 :s.                                      \n"+
                "                                                                                ....:rI5r:sPDdKI7:.     rBQi                                    \n"+
                "                                                                       .rIqSui.  ..   rRBBBgbqqddPZM2    :BBI                                   \n"+
                "                                                                  .is2bDMQQBBBBQU:.:5MRX7IPY    .rSqgR    :BBi                                  \n"+
                "                                                                ....        .iUMBBgbU7i  L5Rj     .BdBg    rB7                                  \n"+
                "                                                                           ...:72SZBI:rivKIBQj.:.  .BgB5   7P                                   \n"+
                "                                                                          ...rLvrvrYQI..1BUMB1 si  .BBBB  .j  .j                                \n"+
                "                                                                           :I2vv:Jj 2Bi:ZBidB7 P: 7PBQDBi :  iBS                                \n"+
                "                                                                .rs5EZKU7sZQS7r.rEP.rBRKDviBQ:7grXBBBSdBr  .XBB.                                \n"+
                "                                                              ..ri::7JIdEqs. .:7gBS.5BEv.:BB2jZMQBBBurMQ  :QBB1           .:rLuUYsY7i:.....     \n"+
                "                                                            ...:iYUSK5srii7IqKgBBK7UEr  sBQrsQBBQbBP uQgiuBBBE       .LEBBBBQdXLr:.             \n"+
                "                                                            ..:v2X1JjUUYs2qgBBBBPII7  .72. rZBBBEZP rRBBMBBQdri.  .IBBBBgs.                     \n"+
                "                                                           ..i7J1vsJ. .::rr7UPKur.        JXXbBBBJ iRBBQZgMgP1  7gBBBZi      .::.               \n"+
                "                                                         ..:irv1:72   ivsLL7:             ..:jRgi vQQQRDDgRg2.igBBB2      .vbbqPEMU            .\n"+
                "                                                     ....:i7ivQu71  rvrrvvr.  .rvrruPsi7XdU7rSP  2BQMMQQRgEI75BBBR.       ...     P7  ...     7r\n"+
                "                                                  .....:i7J7iQB155Xqv:7s1JvvviYSP:  gu :KPLKQI  ZBKPQBQdPKI5gBBBg.    ::   :UZXSK  7 .:i7Yv: iP.\n"+
                "                                                 ..::YXPKYi:vEXvvu1uuvrvj1U22L:PBgj:sQL7quvPY .BBjvdBDi iJPMQRBgi   rKs  2QBBBB UB  . ....r1rURY\n"+
                "                                                ..:rX5js7vJ55vLKPKXKPq7ir77rvq2LXQBQgBBgPPXr :BBjiURBg2YLdBQRQMJi7SQMY  QBBU  Br Bi .:::..rKsrBB\n"+
                "                                                ..:Li ..75PY:2gXY7777sKPj77. YQQKPgQQQQRQZi 7BBI.:UPbgQBBBBRZKj2EBQPi  BBB.   Bb BY i7Y77vPP. iB\n"+
                "                                                .:iY   sQ7i:bBL.i7vv7ri1QBBBPbgBBBBBBRSPDv XBQLY. ruUqgBBQDXSPRBg5v  :BBK  .  Rd7Br:YuL:7KSi:. .\n"+
                "                                                ..:7:. DE.:iBP.irr7LJ1Yr71dQBBQPvs7r7: rs:EBBRSs   jIKbgEbbZMQRXv:  5BB7  :i:rQdsMvi:..r1L7LL7ir\n"+
                "                                                 ..:::vBE:i:Iu....:i7s1j7.iKQBg..i::: 7PiSBBBQBD:  rIqQD2dggRgIi  :BBQ. ivLv:LQg5D7 .rrii7vLLsuP\n"+
                "                                                  ...::su.......:::iv12uvvUqPBZ:r7i: :BsvBBJLRBBK  .1qBQgRggRS  .DBBY :PY777jgBQgdYIMDvirvjSPPKS\n"+
                "                                                     .. ....  ..:Yuvvssvri:rPMPLii:. EQiKBq  YQBB.  .7gBQQggQ2:IBB2  5QjirLPBBQQBQEvUBBBBQMd17i7\n"+
                "                                                              .:..rjr     rdZJr:::: rBX:gB  .:bBBs    iBBgZRQBBQJ..1BBPsL5gBBQRBBBBK..2ZMQgdKIJv\n"+
                "                                                              .uSj7sb5YLLXQZi:7v:i: EBjiBE  .:1BBE:    :EBRPqPKj1EBQEqXKEQBgvdBM1dBBEr     ..iir\n"+
                "                                                              .:JSqZMBBBBBBBEP1i.ii gBKigB:   .PBQEJ:    :PDSvrrYUI5SPDgDQBr:BB7 .r2MBRZbK52XERB\n"+
                "                                                               ....::iisqK2Yi... r1 1BBbPBBq7:ivZBBBMPur.  .uqEEbKS5XKX1PBX SBB. ::..:rvv7YEBBg5\n"+
                "                                                                .........   ...  iR. DBBBBBBBBBMgRBBBBBBQbU7iiir7Ls2qbPEgXr.PBB. ..       rgBb. \n"+
                "                                                                   .........      gB  idBBBBBBBBBBP2MBBBBBQMEqISqERQQRgPur..PBBMi      :YMBBP   \n"+
                "                                                                                  .BBJ   .v2XXIs7:  :LXgBBBBBBBBBBBBBQQQggZXUQRQBBBQBBBBBBM:   .\n"+
                "                                                                                   iBBBRv         .::::i7sIKdDDDgRRRMDdP5jsi .EDQBBBBBBR1    :KB\n"+
                "                                                                                     7DBBBZ1i.    ...::::::::::::iiii::....:r. :r7vv7:    :KBBBB\n"+
                "                                                                                                      ....::::ii::::::....  .i7r:.  .:sdBBBBBQU.\n"+
                "                                                                                                           ............        .7XbRBBBBBZU:    ";

        hyperSkillImages[5]="                                                              .::.                 :s.                                                          \n"+
                "                                                            ....:rI5r:sPDdKI7:.     rBQi                                                        \n"+
                "                                                   .rIqSui.  ..   rRBBBgbqqddPZM2    :BBI                                                       \n"+
                "                                              .is2bDMQQBBBBQU:.:5MRX7IPY    .rSqgR    :BBi                                                      \n"+
                "                                            ....        .iUMBBgbU7i  L5Rj     .BdBg    rB7                                                      \n"+
                "                                                       ...:72SZBI:rivKIBQj.:.  .BgB5   7P                                                       \n"+
                "                                                      ...rLvrvrYQI..1BUMB1 si  .BBBB  .j  .j                                                    \n"+
                "                                                       :I2vv:Jj 2Bi:ZBidB7 P: 7PBQDBi :  iBS                                                    \n"+
                "                                            .rs5EZKU7sZQS7r.rEP.rBRKDviBQ:7grXBBBSdBr  .XBB.                                                    \n"+
                "                                          ..ri::7JIdEqs. .:7gBS.5BEv.:BB2jZMQBBBurMQ  :QBB1           .:rLuUYsY7i:.....                         \n"+
                "                                        ...:iYUSK5srii7IqKgBBK7UEr  sBQrsQBBQbBP uQgiuBBBE       .LEBBBBQdXLr:.                                 \n"+
                "                                        ..:v2X1JjUUYs2qgBBBBPII7  .72. rZBBBEZP rRBBMBBQdri.  .IBBBBgs.                                         \n"+
                "                                       ..i7J1vsJ. .::rr7UPKur.        JXXbBBBJ iRBBQZgMgP1  7gBBBZi      .::.                                   \n"+
                "                                     ..:irv1:72   ivsLL7:             ..:jRgi vQQQRDDgRg2.igBBB2      .vbbqPEMU            ..                   \n"+
                "                                 ....:i7ivQu71  rvrrvvr.  .rvrruPsi7XdU7rSP  2BQMMQQRgEI75BBBR.       ...     P7  ...     7r           ..       \n"+
                "                              .....:i7J7iQB155Xqv:7s1JvvviYSP:  gu :KPLKQI  ZBKPQBQdPKI5gBBBg.    ::   :UZXSK  7 .:i7Yv: iP.         .. rbv     \n"+
                "                             ..::YXPKYi:vEXvvu1uuvrvj1U22L:PBgj:sQL7quvPY .BBjvdBDi iJPMQRBgi   rKs  2QBBBB UB  . ....r1rURY     vbBBBB1  Q7    \n"+
                "                            ..:rX5js7vJ55vLKPKXKPq7ir77rvq2LXQBQgBBgPPXr :BBjiURBg2YLdBQRQMJi7SQMY  QBBU  Br Bi .:::..rKsrBB1:LdBBBBBBBBg jM    \n"+
                "                            ..:Li ..75PY:2gXY7777sKPj77. YQQKPgQQQQRQZi 7BBI.:UPbgQBBBBRZKj2EBQPi  BBB.   Bb BY i7Y77vPP. iBBBBBBQ7   ZBBP:E    \n"+
                "                            .:iY   sQ7i:bBL.i7vv7ri1QBBBPbgBBBBBBRSPDv XBQLY. ruUqgBBQDXSPRBg5v  :BBK  .  Rd7Br:YuL:7KSi:. .rgBX.     IBQM.r .. \n"+
                "                            ..:7:. DE.:iBP.irr7LJ1Yr71dQBBQPvs7r7: rs:EBBRSs   jIKbgEbbZMQRXv:  5BB7  :i:rQdsMvi:..r1L7LL7irUPs   ..  MRgK.::...\n"+
                "                             ..:::vBE:i:Iu....:i7s1j7.iKQBg..i::: 7PiSBBBQBD:  rIqQD2dggRgIi  :BBQ. ivLv:LQg5D7 .rrii7vLLsuPP1:.:::: 1QPDr:rii7v\n"+
                "                              ...::su.......:::iv12uvvUqPBZ:r7i: :BsvBBJLRBBK  .1qBQgRggRS  .DBBY :PY777jgBQgdYIMDvirvjSPPKS5vvssYL::gIKu:7J2Ur.\n"+
                "                                 .. ....  ..:Yuvvssvri:rPMPLii:. EQiKBq  YQBB.  .7gBQQggQ2:IBB2  5QjirLPBBQQBQEvUBBBBQMd17i77LuujJv:5Pr2:71j7:..\n"+
                "                                          .:..rjr     rdZJr:::: rBX:gB  .:bBBs    iBBgZRQBBQJ..1BBPsL5gBBQRBBBBK..2ZMQgdKIJvr:::irrrEYij:suYi:..\n"+
                "                                          .uSj7sb5YLLXQZi:7v:i: EBjiBE  .:1BBE:    :EBRPqPKj1EBQEqXKEQBgvdBM1dBBEr     ..iir7vu5XqXKRY:D1j7:..  \n"+
                "                                          .:JSqZMBBBBBBBEP1i.ii gBKigB:   .PBQEJ:    :PDSvrrYUI5SPDgDQBr:BB7 .r2MBRZbK52XERBBBBBBRPUqDrKi       \n"+
                "                                           ....::iisqK2Yi... r1 1BBbPBBq7:ivZBBBMPur.  .uqEEbKS5XKX1PBX SBB. ::..:rvv7YEBBg52jvi:.  .QQUZIv.    \n"+
                "                                            .........   ...  iR. DBBBBBBBBBMgRBBBBBBQbU7iiir7Ls2qbPEgXr.PBB. ..       rgBb.     :72qUsgBgBBBgEPg\n"+
                "                                               .........      gB  idBBBBBBBBBBP2MBBBBBQMEqISqERQQRgPur..PBBMi      :YMBBP     ij5Sv.   .JdBBBBBB\n"+
                "                                                              .BBJ   .v2XXIs7:  :LXgBBBBBBBBBBBBBQQQggZXUQRQBBBQBBBBBBM:   .sqZd7           ... \n"+
                "                                                               iBBBRv         .::::i7sIKdDDDgRRRMDdP5jsi .EDQBBBBBBR1    :KBBBRi                \n"+
                "                                                                 7DBBBZ1i.    ...::::::::::::iiii::....:r. :r7vv7:    :KBBBBQv                  \n"+
                "                                                                                  ....::::ii::::::....  .i7r:.  .:sdBBBBBQU.                    \n"+
                "                                                                                       ............        .7XbRBBBBBZU:                        ";

        hyperSkillImages[6]="                                      .::.                 :s.                                                                                  \n"+
                "                                    ....:rI5r:sPDdKI7:.     rBQi                                                                                \n"+
                "                           .rIqSui.  ..   rRBBBgbqqddPZM2    :BBI                                                                               \n"+
                "                      .is2bDMQQBBBBQU:.:5MRX7IPY    .rSqgR    :BBi                                                                              \n"+
                "                    ....        .iUMBBgbU7i  L5Rj     .BdBg    rB7                                                                              \n"+
                "                               ...:72SZBI:rivKIBQj.:.  .BgB5   7P                                                                               \n"+
                "                              ...rLvrvrYQI..1BUMB1 si  .BBBB  .j  .j                                                                            \n"+
                "                               :I2vv:Jj 2Bi:ZBidB7 P: 7PBQDBi :  iBS                                                                            \n"+
                "                    .rs5EZKU7sZQS7r.rEP.rBRKDviBQ:7grXBBBSdBr  .XBB.                                                                            \n"+
                "                  ..ri::7JIdEqs. .:7gBS.5BEv.:BB2jZMQBBBurMQ  :QBB1           .:rLuUYsY7i:.....                                                 \n"+
                "                ...:iYUSK5srii7IqKgBBK7UEr  sBQrsQBBQbBP uQgiuBBBE       .LEBBBBQdXLr:.                                                         \n"+
                "                ..:v2X1JjUUYs2qgBBBBPII7  .72. rZBBBEZP rRBBMBBQdri.  .IBBBBgs.                                                                 \n"+
                "               ..i7J1vsJ. .::rr7UPKur.        JXXbBBBJ iRBBQZgMgP1  7gBBBZi      .::.                                                           \n"+
                "             ..:irv1:72   ivsLL7:             ..:jRgi vQQQRDDgRg2.igBBB2      .vbbqPEMU            ..                                           \n"+
                "         ....:i7ivQu71  rvrrvvr.  .rvrruPsi7XdU7rSP  2BQMMQQRgEI75BBBR.       ...     P7  ...     7r           ..                               \n"+
                "      .....:i7J7iQB155Xqv:7s1JvvviYSP:  gu :KPLKQI  ZBKPQBQdPKI5gBBBg.    ::   :UZXSK  7 .:i7Yv: iP.         .. rbv                             \n"+
                "     ..::YXPKYi:vEXvvu1uuvrvj1U22L:PBgj:sQL7quvPY .BBjvdBDi iJPMQRBgi   rKs  2QBBBB UB  . ....r1rURY     vbBBBB1  Q7                            \n"+
                "    ..:rX5js7vJ55vLKPKXKPq7ir77rvq2LXQBQgBBgPPXr :BBjiURBg2YLdBQRQMJi7SQMY  QBBU  Br Bi .:::..rKsrBB1:LdBBBBBBBBg jM                            \n"+
                "    ..:Li ..75PY:2gXY7777sKPj77. YQQKPgQQQQRQZi 7BBI.:UPbgQBBBBRZKj2EBQPi  BBB.   Bb BY i7Y77vPP. iBBBBBBQ7   ZBBP:E                            \n"+
                "    .:iY   sQ7i:bBL.i7vv7ri1QBBBPbgBBBBBBRSPDv XBQLY. ruUqgBBQDXSPRBg5v  :BBK  .  Rd7Br:YuL:7KSi:. .rgBX.     IBQM.r ..                         \n"+
                "    ..:7:. DE.:iBP.irr7LJ1Yr71dQBBQPvs7r7: rs:EBBRSs   jIKbgEbbZMQRXv:  5BB7  :i:rQdsMvi:..r1L7LL7irUPs   ..  MRgK.::...::..              .     \n"+
                "     ..:::vBE:i:Iu....:i7s1j7.iKQBg..i::: 7PiSBBBQBD:  rIqQD2dggRgIi  :BBQ. ivLv:LQg5D7 .rrii7vLLsuPP1:.:::: 1QPDr:rii7vi.              ..      \n"+
                "      ...::su.......:::iv12uvvUqPBZ:r7i: :BsvBBJLRBBK  .1qBQgRggRS  .DBBY :PY777jgBQgdYIMDvirvjSPPKS5vvssYL::gIKu:7J2Ur.               ::       \n"+
                "         .. ....  ..:Yuvvssvri:rPMPLii:. EQiKBq  YQBB.  .7gBQQggQ2:IBB2  5QjirLPBBQQBQEvUBBBBQMd17i77LuujJv:5Pr2:71j7:...            :r.        \n"+
                "                  .:..rjr     rdZJr:::: rBX:gB  .:bBBs    iBBgZRQBBQJ..1BBPsL5gBBQRBBBBK..2ZMQgdKIJvr:::irrrEYij:suYi:..          .rsi          \n"+
                "                  .uSj7sb5YLLXQZi:7v:i: EBjiBE  .:1BBE:    :EBRPqPKj1EBQEqXKEQBgvdBM1dBBEr     ..iir7vu5XqXKRY:D1j7:..          :dgL.           \n"+
                "                  .:JSqZMBBBBBBBEP1i.ii gBKigB:   .PBQEJ:    :PDSvrrYUI5SPDgDQBr:BB7 .r2MBRZbK52XERBBBBBBRPUqDrKi            .IBBE.             \n"+
                "                   ....::iisqK2Yi... r1 1BBbPBBq7:ivZBBBMPur.  .uqEEbKS5XKX1PBX SBB. ::..:rvv7YEBBg52jvi:.  .QQUZIv.     .YDBBBd.               \n"+
                "                    .........   ...  iR. DBBBBBBBBBMgRBBBBBBQbU7iiir7Ls2qbPEgXr.PBB. ..       rgBb.     :72qUsgBgBBBgEPgBBBBQv                  \n"+
                "                       .........      gB  idBBBBBBBBBBP2MBBBBBQMEqISqERQQRgPur..PBBMi      :YMBBP     ij5Sv.   .JdBBBBBBBQu                     \n"+
                "                                      .BBJ   .v2XXIs7:  :LXgBBBBBBBBBBBBBQQQggZXUQRQBBBQBBBBBBM:   .sqZd7           ...                         \n"+
                "                                       iBBBRv         .::::i7sIKdDDDgRRRMDdP5jsi .EDQBBBBBBR1    :KBBBRi                                        \n"+
                "                                         7DBBBZ1i.    ...::::::::::::iiii::....:r. :r7vv7:    :KBBBBQv                                          \n"+
                "                                                          ....::::ii::::::....  .i7r:.  .:sdBBBBBQU.                                            \n"+
                "                                                               ............        .7XbRBBBBBZU:                                                ";
        for(int i=0; i<=100; i++) {
            System.out.println("");
        }
        for(int i=0; i<hyperSkillImages.length; i++ ) {
            for(int j=0;j<50;j++) {
                System.out.println("");
            }
            System.out.println(hyperSkillImages[i]);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {

            }
        }


    }




    //-------------------몬스터 공격 효과---------------------------------------------------


    public void executeMonsterAttack() {
        String[] attackImages=new String[7];
        attackImages[0]= red +"                                                                                                                                        \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                   ..::\n"+
                red +"                                                                                                                             ..i7JqEQBB\n"+
                red +"                                                                                                                          ..LQBBQBBBBBB\n"+
                red +"                                                                                                                          ..BBBBBBBBBBB\n"+
                red +"                                                                                                                          ..jBBBBBBBQBX\n"+
                red +"                                                                                                                           ..rBP7sqgBBI\n"+
                red +"                                                                                                                              .:.....:i\n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       \n"+
                red +"                                                                                                                                       ";

        attackImages[1]=blue +"                                                                                                                                        \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                       \n"+
                blue +"                                                                                                                                      .\n"+
                blue +"                                                                                                                                  ...i7\n"+
                blue +"                                                                                                                                 .:iUgB\n"+
                blue +"                                                                                                                            ..:v5MQBBBB\n"+
                blue +"                                                                                                                      ..:ivUDBBBBBBBBBB\n"+
                blue +"                                                                                                               ..::rYIbBQBBBBBRPqQBBBBB\n"+
                blue +"                                                                                                         ..i7JqEQBBBBBBBBBBQMbbZQBBBBBB\n"+
                blue +"                                                                                                      ..LQBBQBBBBBBBBBQBBBQBQBBBBBBBQBB\n"+
                blue +"                                                                                                      ..BBBBBBBBBBBBBQBBBBBBBBBBBBBBBQQ\n"+
                blue +"                                                                                                      ..jBBBBBBBQBXSUIuKEQQBBBQBBBDMggD\n"+
                blue +"                                                                                                       ..rBP7sqgBBI:......:i7LIKMgI77rr\n"+
                blue +"                                                                                                          .:.....:i              .:..:i\n"+
                blue +"                                                                                                                          .     ..:rSRB\n"+
                blue +"                                                                                                                      iX::rgIU1IqQBBBBB\n"+
                blue +"                                                                                                                     .:QBBQBBBBBBQBBBBB\n"+
                blue +"                                                                                                                      .:IZBBBBDXYvriiii\n"+
                blue +"                                                                                                                       ...iZv.. .      \n"+
                blue +"                                                                                                                                       ";

        attackImages[2]=yellow +"                                                                                                                                        \n"+
                yellow +"                                                                                                                                       \n"+
                yellow +"                                                                                                                                       \n"+
                yellow +"                                                                                                                                       \n"+
                yellow +"                                                                                                                                      :\n"+
                yellow +"                                                                                                                              .:...:YMB\n"+
                yellow +"                                                                                                                          .:rI2i.:vQBBB\n"+
                yellow +"                                                                                                                        ..7qbK1i7uDBQbq\n"+
                yellow +"                                                                                                                      .:sqPIUPPQBBEs777\n"+
                yellow +"                                                                                                                  ..rUgBQggZQQBBBRPIdRB\n"+
                yellow +"                                                                                                              ...i7gBBBBBBBBBBBBBBBBQQd\n"+
                yellow +"                                                                                                             .:iUgBQBBBBBBBBBBBBQQDPQDb\n"+
                yellow +"                                                                                                        ..:v5MQBBBBBBBBBBBBBBBRgdMBBQ1Y\n"+
                yellow +"                                                                                                  ..:ivUDBBBBBBBBBBBBBBQBQBBBQQQBBBZU7r\n"+
                yellow +"                                                                                           ..::rYIbBQBBBBBRPqQBBBBBBQBQBBBBBBBBBgXLvYJr\n"+
                yellow +"                                                                                     ..i7JqEQBBBBBBBBBBQMbbZQBBBBBBBBQBBBQBBBRgD2vYsU21\n"+
                yellow +"                                                                                  ..LQBBQBBBBBBBBBQBBBQBQBBBBBBBQBBBBBBBBBBBgMQBBBQBQBB\n"+
                yellow +"                                                                                  ..BBBBBBBBBBBBBQBBBBBBBBBBBBBBBQQQQRQRQQBQBBBBBQBBBBB\n"+
                yellow +"                                                                                  ..jBBBBBBBQBXSUIuKEQQBBBQBBBDMggDQQBQBBBZPXbbPqEbdPPX\n"+
                yellow +"                                                                                   ..rBP7sqgBBI:......:i7LIKMgI77rr7JSZKSvrjDEZZRRZY7rv\n"+
                yellow +"                                                                                      .:.....:i              .:..:iKggXu2dMBBBBQZDEZPEB\n"+
                yellow +"                                                                                                      .     ..:rSRBBBQBQBBBBBRBBBRgMQQQ\n"+
                yellow +"                                                                                                  iX::rgIU1IqQBBBBBBQQRMPX1uY5MBQBQgEdE\n"+
                yellow +"                                                                                                 .:QBBQBBBBBBQBBBBBBgXPI2Js77vsLssuv1PB\n"+
                yellow +"                                                                                                  .:IZBBBBDXYvriiiii7v7YUdRQr        ..\n"+
                yellow +"                                                                                                   ...iZv.. .       ...:iYBBB5r:iiirrir\n"+
                yellow +"                                                                                                                         ..:2u.        ";

        attackImages[3]=green +"                                                                                                                                 ..     \n"+
                green +"                                                                                                                        .iJqBs.        \n"+
                green +"                                                                                                                       .ruZQQi         \n"+
                green +"                                                                                                                      .:rLqqi          \n"+
                green +"                                                                                                                  :vuUjUvi.            \n"+
                green +"                                                                                                          .:...:YMBBddQ1: .            \n"+
                green +"                                                                                                      .:rI2i.:vQBBBDMBIi..   .:7YJr:   \n"+
                green +"                                                                                                    ..7qbK1i7uDBQbq5v: .:ivuKS17i.     \n"+
                green +"                                                                                                  .:sqPIUPPQBBEs777YvUKEbXYr.          \n"+
                green +"                                                                                              ..rUgBQggZQQBBBRPIdRBQRPui.. ..:ir1PK7rrr\n"+
                green +"                                                                                                 ...i7gBBBBBBBBBBBBBBBBQQdPbPbBBBQBBBBBBZ1rii:\n"+
                green +"                                                                                         .:iUgBQBBBBBBBBBBBBQQDPQDbERQBDDDBBDSq5svJu2jU\n"+
                green +"                                                                                    ..:v5MQBBBBBBBBBBBBBBBRgdMBBQ1Yri7i::rJ7i7rrLuJuYY7\n"+
                green +"                                                                              ..:ivUDBBBBBBBBBBBBBBQBQBBBQQQBBBZU7r:::ii777rr7YYJJjjuJj\n"+
                green +"                                                                       ..::rYIbBQBBBBBRPqQBBBBBBQBQBBBBBBBBBgXLvYJr7rvrUsrrjJujuL7rriri\n"+
                green +"                                                                 ..i7JqEQBBBBBBBBBBQMbbZQBBBBBBBBQBBBQBBBRgD2vYsU21j25qQbrssuSPPMgMEdbE\n"+
                green +"                                                              ..LQBBQBBBBBBBBBQBBBQBQBBBBBBBQBBBBBBBBBBBgMQBBBQBQBBBBBBQDgggPDMQgQQBBBB\n"+
                green +"                                                              ..BBBBBBBBBBBBBQBBBBBBBBBBBBBBBQQQQRQRQQBQBBBBBQBBBBBBBBBQBBBQBdK5SIUYjj5\n"+
                green +"                                                              ..jBBBBBBBQBXSUIuKEQQBBBQBBBDMggDQQBQBBBZPXbbPqEbdPPXKIUJ2UI25S5SS252IIPq\n"+
                green +"                                                               ..rBP7sqgBBI:......:i7LIKMgI77rr7JSZKSvrjDEZZRRZY7rvsSbMbKuU11sjsJYJv7r7\n"+
                green +"                                                                  .:.....:i              .:..:iKggXu2dMBBBBQZDEZPEBBQBBBRRDggMbK1uU5YJS\n"+
                green +"                                                                                  .     ..:rSRBBBQBQBBBBBRBBBRgMQQQRP77iir7rvu2YL7sKbQE\n"+
                green +"                                                                              iX::rgIU1IqQBBBBBBQQRMPX1uY5MBQBQgEdES7s77ri:rr7vK57rYvv:\n"+
                green +"                                                                             .:QBBQBBBBBBQBBBBBBgXPI2Js77vsLssuv1PBBBQBBBBgYirrri:.....\n"+
                green +"                                                                              .:IZBBBBDXYvriiiii7v7YUdRQr        .....i:rii:           \n"+
                green +"                                                                               ...iZv.. .       ...:iYBBB5r:iiirrirrrrriiirr777777v77rr\n"+
                green +"                                                                                                     ..:2u.                            ";

        attackImages[4]=cyan +"                                                                                                         ..                             \n"+
                cyan +"                                                                                                   .iJqBs.                             \n"+
                cyan +"                                                                                                   .ruZQQi                             \n"+
                cyan +"                                                                                                  .:rLqqi                              \n"+
                cyan +"                                                                                              :vuUjUvi.                                \n"+
                cyan +"                                                                                      .:...:YMBBddQ1: .                                \n"+
                cyan +"                                                                                  .:rI2i.:vQBBBDMBIi..   .:7YJr:                       \n"+
                cyan +"                                                                                ..7qbK1i7uDBQbq5v: .:ivuKS17i.                         \n"+
                cyan +"                                                                              .:sqPIUPPQBBEs777YvUKEbXYr.                              \n"+
                cyan +"                                                                          ..rUgBQggZQQBBBRPIdRBQRPui.. ..:ir1PK7rrrrrrriiii::..        \n"+
                cyan +"                                                                      ...i7gBBBBBBBBBBBBBBBBQQdPbPbBBBQBBBBBBZ1rii:i:.....             \n"+
                cyan +"                                                                     .:iUgBQBBBBBBBBBBBBQQDPQDbERQBDDDBBDSq5svJu2jUudZsv7rr::::..      \n"+
                cyan +"                                                                ..:v5MQBBBBBBBBBBBBBBBRgdMBBQ1Yri7i::rJ7i7rrLuJuYY7sqqY1LLL7rrii:i::::.\n"+
                cyan +"                                                          ..:ivUDBBBBBBBBBBBBBBQBQBBBQQQBBBZU7r:::ii777rr7YYJJjjuJjjs7LLvvJrs7rLJii::..\n"+
                cyan +"                                                   ..::rYIbBQBBBBBRPqQBBBBBBQBQBBBBBBBBBgXLvYJr7rvrUsrrjJujuL7rriri::::::ir7LJiii      \n"+
                cyan +"                                             ..i7JqEQBBBBBBBBBBQMbbZQBBBBBBBBQBBBQBBBRgD2vYsU21j25qQbrssuSPPMgMEdbEdgDBBBBBZgPZ51YssJrr\n"+
                cyan +"                                          ..LQBBQBBBBBBBBBQBBBQBQBBBBBBBQBBBBBBBBBBBgMQBBBQBQBBBBBBQDgggPDMQgQQBBBBBBQEKjuLYvYsUSKEQQRD\n"+
                cyan +"                                          ..BBBBBBBBBBBBBQBBBBBBBBBBBBBBBQQQQRQRQQBQBBBBBQBBBBBBBBBQBBBQBdK5SIUYjj5IUsjYY7v7v7vvL7YJJvY\n"+
                cyan +"                                          ..jBBBBBBBQBXSUIuKEQQBBBQBBBDMggDQQBQBBBZPXbbPqEbdPPXKIUJ2UI25S5SS252IIPqKqMgMQQgRDP5K1j7rii:\n"+
                cyan +"                                           ..rBP7sqgBBI:......:i7LIKMgI77rr7JSZKSvrjDEZZRRZY7rvsSbMbKuU11sjsJYJv7r7r7:..i:... .        \n"+
                cyan +"                                              .:.....:i              .:..:iKggXu2dMBBBBQZDEZPEBBQBBBRRDggMbK1uU5YJSKKIUS522SII15IXjU12Y\n"+
                cyan +"                                                              .     ..:rSRBBBQBQBBBBBRBBBRgMQQQRP77iir7rvu2YL7sKbQE7vvL7vLuiivv:ir::i::\n"+
                cyan +"                                                          iX::rgIU1IqQBBBBBBQQRMPX1uY5MBQBQgEdES7s77ri:rr7vK57rYvv:i:i:::ii::i::...... \n"+
                cyan +"                                                         .:QBBQBBBBBBQBBBBBBgXPI2Js77vsLssuv1PBBBQBBBBgYirrri:..... . . .              \n"+
                cyan +"                                                          .:IZBBBBDXYvriiiii7v7YUdRQr        .....i:rii:                               \n"+
                cyan +"                                                           ...iZv.. .       ...:iYBBB5r:iiirrirrrrriiirr777777v77rriri:.:....          \n"+
                cyan +"                                                                                 ..:2u.                                                ";

        attackImages[5]=purple+"                                                                                    ..                                                  \n"+
                purple+"                                                                               .iJqBs.                                                 \n"+
                purple+"                                                                              .ruZQQi                                                  \n"+
                purple+"                                                                             .:rLqqi                                                   \n"+
                purple+"                                                                         :vuUjUvi.                                                     \n"+
                purple+"                                                                 .:...:YMBBddQ1: .                                                     \n"+
                purple+"                                                             .:rI2i.:vQBBBDMBIi..   .:7YJr:                                            \n"+
                purple+"                                                           ..7qbK1i7uDBQbq5v: .:ivuKS17i.                                              \n"+
                purple+"                                                         .:sqPIUPPQBBEs777YvUKEbXYr.                                                   \n"+
                purple+"                                                     ..rUgBQggZQQBBBRPIdRBQRPui.. ..:ir1PK7rrrrrrriiii::..                             \n"+
                purple+"                                                 ...i7gBBBBBBBBBBBBBBBBQQdPbPbBBBQBBBBBBZ1rii:i:.....                                  \n"+
                purple+"                                                .:iUgBQBBBBBBBBBBBBQQDPQDbERQBDDDBBDSq5svJu2jUudZsv7rr::::..                           \n"+
                purple+"                                           ..:v5MQBBBBBBBBBBBBBBBRgdMBBQ1Yri7i::rJ7i7rrLuJuYY7sqqY1LLL7rrii:i::::......                \n"+
                purple+"                                     ..:ivUDBBBBBBBBBBBBBBQBQBBBQQQBBBZU7r:::ii777rr7YYJJjjuJjjs7LLvvJrs7rLJii::......                 \n"+
                purple+"                              ..::rYIbBQBBBBBRPqQBBBBBBQBQBBBBBBBBBgXLvYJr7rvrUsrrjJujuL7rriri::::::ir7LJiii                           \n"+
                purple+"                        ..i7JqEQBBBBBBBBBBQMbbZQBBBBBBBBQBBBQBBBRgD2vYsU21j25qQbrssuSPPMgMEdbEdgDBBBBBZgPZ51YssJrr::::.. .             \n"+
                purple+"                     ..LQBBQBBBBBBBBBQBBBQBQBBBBBBBQBBBBBBBBBBBgMQBBBQBQBBBBBBQDgggPDMQgQQBBBBBBQEKjuLYvYsUSKEQQRDgbEPEdEPdKP5511svrrii\n"+
                purple+"                     ..BBBBBBBBBBBBBQBBBBBBBBBBBBBBBQQQQRQRQQBQBBBBBQBBBBBBBBBQBBBQBdK5SIUYjj5IUsjYY7v7v7vvL7YJJvYYJJUu2UUJUu1JJvv77rri\n"+
                purple+"                     ..jBBBBBBBQBXSUIuKEQQBBBQBBBDMggDQQBQBBBZPXbbPqEbdPPXKIUJ2UI25S5SS252IIPqKqMgMQQgRDP5K1j7rii::..                  \n"+
                purple+"                      ..rBP7sqgBBI:......:i7LIKMgI77rr7JSZKSvrjDEZZRRZY7rvsSbMbKuU11sjsJYJv7r7r7:..i:... .                             \n"+
                purple+"                         .:.....:i              .:..:iKggXu2dMBBBBQZDEZPEBBQBBBRRDggMbK1uU5YJSKKIUS522SII15IXjU12YLvL77rriirr::ii..:. .\n"+
                purple+"                                         .     ..:rSRBBBQBQBBBBBRBBBRgMQQQRP77iir7rvu2YL7sKbQE7vvL7vLuiivv:ir::i::.... .   ..  ..      \n"+
                purple+"                                     iX::rgIU1IqQBBBBBBQQRMPX1uY5MBQBQgEdES7s77ri:rr7vK57rYvv:i:i:::ii::i::......                      \n"+
                purple+"                                    .:QBBQBBBBBBQBBBBBBgXPI2Js77vsLssuv1PBBBQBBBBgYirrri:..... . . .                                   \n"+
                purple+"                                     .:IZBBBBDXYvriiiii7v7YUdRQr        .....i:rii:                                                    \n"+
                purple+"                                      ...iZv.. .       ...:iYBBB5r:iiirrirrrrriiirr777777v77rriri:.:....                               \n"+
                purple+"                                                            ..:2u.                                                                     ";

        attackImages[6]=white+"                                                                     ..                                                                \n"+
                white+"                                                                .iJqBs.                                                                \n"+
                white+"                                                               .ruZQQi                                                                 \n"+
                white+"                                                              .:rLqqi                                                                  \n"+
                white+"                                                          :vuUjUvi.                                                                    \n"+
                white+"                                                  .:...:YMBBddQ1: .                                                                    \n"+
                white+"                                              .:rI2i.:vQBBBDMBIi..   .:7YJr:                                                           \n"+
                white+"                                            ..7qbK1i7uDBQbq5v: .:ivuKS17i.                                                             \n"+
                white+"                                          .:sqPIUPPQBBEs777YvUKEbXYr.                                                                  \n"+
                white+"                                      ..rUgBQggZQQBBBRPIdRBQRPui.. ..:ir1PK7rrrrrrriiii::..                                            \n"+
                white+"                                  ...i7gBBBBBBBBBBBBBBBBQQdPbPbBBBQBBBBBBZ1rii:i:.....                                                 \n"+
                white+"                                 .:iUgBQBBBBBBBBBBBBQQDPQDbERQBDDDBBDSq5svJu2jUudZsv7rr::::..                                          \n"+
                white+"                            ..:v5MQBBBBBBBBBBBBBBBRgdMBBQ1Yri7i::rJ7i7rrLuJuYY7sqqY1LLL7rrii:i::::......                               \n"+
                white+"                      ..:ivUDBBBBBBBBBBBBBBQBQBBBQQQBBBZU7r:::ii777rr7YYJJjjuJjjs7LLvvJrs7rLJii::......                                \n"+
                white+"               ..::rYIbBQBBBBBRPqQBBBBBBQBQBBBBBBBBBgXLvYJr7rvrUsrrjJujuL7rriri::::::ir7LJiii                                          \n"+
                white+"         ..i7JqEQBBBBBBBBBBQMbbZQBBBBBBBBQBBBQBBBRgD2vYsU21j25qQbrssuSPPMgMEdbEdgDBBBBBZgPZ51YssJrr::::.. .                            \n"+
                white+"      ..LQBBQBBBBBBBBBQBBBQBQBBBBBBBQBBBBBBBBBBBgMQBBBQBQBBBBBBQDgggPDMQgQQBBBBBBQEKjuLYvYsUSKEQQRDgbEPEdEPdKP5511svrrii:...           \n"+
                white+"      ..BBBBBBBBBBBBBQBBBBBBBBBBBBBBBQQQQRQRQQBQBBBBBQBBBBBBBBBQBBBQBdK5SIUYjj5IUsjYY7v7v7vvL7YJJvYYJJUu2UUJUu1JJvv77rriiii::::........\n"+
                white+"      ..jBBBBBBBQBXSUIuKEQQBBBQBBBDMggDQQBQBBBZPXbbPqEbdPPXKIUJ2UI25S5SS252IIPqKqMgMQQgRDP5K1j7rii::..                                 \n"+
                white+"       ..rBP7sqgBBI:......:i7LIKMgI77rr7JSZKSvrjDEZZRRZY7rvsSbMbKuU11sjsJYJv7r7r7:..i:... .                                            \n"+
                white+"          .:.....:i              .:..:iKggXu2dMBBBBQZDEZPEBBQBBBRRDggMbK1uU5YJSKKIUS522SII15IXjU12YLvL77rriirr::ii..:. ..              \n"+
                white+"                          .     ..:rSRBBBQBQBBBBBRBBBRgMQQQRP77iir7rvu2YL7sKbQE7vvL7vLuiivv:ir::i::.... .   ..  ..                     \n"+
                white+"                      iX::rgIU1IqQBBBBBBQQRMPX1uY5MBQBQgEdES7s77ri:rr7vK57rYvv:i:i:::ii::i::......                                     \n"+
                white+"                     .:QBBQBBBBBBQBBBBBBgXPI2Js77vsLssuv1PBBBQBBBBgYirrri:..... . . .                                                  \n"+
                white+"                      .:IZBBBBDXYvriiiii7v7YUdRQr        .....i:rii:                                                                   \n"+
                white+"                       ...iZv.. .       ...:iYBBB5r:iiirrirrrrriiirr777777v77rriri:.:....                                              \n"+
                white+"                                             ..:2u.                                                                                    " +exit;
        for(int i=0; i<=100; i++) {
            System.out.println("");
        }
        for(int i=0; i<attackImages.length; i++ ) {
            for(int j=0;j<50;j++) {
                System.out.println("");
            }
            System.out.println(attackImages[i]);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public void run() {//생성자를 통해서 지정해준 type에 따라서 공격 효과가 결정
        switch(type) {
            case "adventurerAttack":
                this.executeAdventurerAttack();
                break;
            case "adventurerSkill":
                this.executeAdventurerSkill();
                break;
            case "adventurerHyperSkill":
                this.executeAdventurerHyperSkill();
                break;
            case "bossAttack":
                this.executeBossAttack();
                break;
            case "bossSkill":
                this.executeBossSkill();
                break;
            case "bossHyperSkill":
                this.executeBossHyperSkill();
                break;
            case "monsterAttack":
                this.executeMonsterAttack();
                break;
        }
    }
}
