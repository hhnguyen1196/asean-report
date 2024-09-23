package com.asean.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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

    private LocalDate deliveryDate;

}
