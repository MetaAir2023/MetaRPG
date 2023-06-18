package com.ohgiraffers.metaRPG.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//임시
public class UserDTO {
    private int sequence;
    private String name;
    private int hp;
    private int str;
    private int level;
    private int money;
    private int itemSequence;
    private int itemUpLv;

    public UserDTO(Integer sequence, String name, Integer money, Integer hp, Integer sequence1, Integer itemSequence, Integer itemUpLv) {
    }
}
