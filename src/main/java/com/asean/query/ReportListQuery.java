package com.asean.query;

import java.time.LocalDate;

public interface ReportListQuery {

    Long getId();

    String getDeliveryPartner();

    String getRecipient();

    String getEquipment();

    String getQuantity();

    String getDeviceCode();

    String getCondition();

    LocalDate getDeliveryDate();

}
