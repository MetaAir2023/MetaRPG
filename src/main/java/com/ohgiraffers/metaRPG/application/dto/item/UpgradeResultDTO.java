package com.ohgiraffers.metaRPG.application.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpgradeResultDTO {
    private int status;
    private int resultUpgradeLevel;
}
