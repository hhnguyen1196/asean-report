package com.asean.request;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class InsertListReportRequest {

    private Long id;

    private String deliveryPartner;

    private String recipient;

    private String equipment;

    private String quantity;

    private String deviceCode;

    private String condition;

    private ZonedDateTime deliveryDate;

}
