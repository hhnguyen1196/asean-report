package com.asean.enums;

import lombok.Getter;

@Getter
public enum ReportConditionEnum {

    NEW("Mới"),
    OLD("Cũ");

    private final String name;

    ReportConditionEnum(String name) {
        this.name = name;
    }

}
