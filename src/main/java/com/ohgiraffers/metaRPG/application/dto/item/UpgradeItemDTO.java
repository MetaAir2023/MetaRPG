package com.ohgiraffers.metaRPG.application.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpgradeItemDTO {
   /*
    *  DTO 필드 형태 고민 필요
    *  1. 아래와 같이 각각의 타입을 정해주는 것이 더 좋은 구조인지
    *  2. 혹은 ItemEntity 를 타입으로 설정하는 것이 더 좋을지 강사님께 질문
    */
    private int itemSequence;
    private int userSequence;
    private int userItemUpgradeLevel;
    private int userMoney;
    private int upgradeCost;
}
