package com.asean.repository;

import com.asean.entity.Report;
import com.asean.query.ReportListQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "SELECT id, delivery_partner AS deliveryPartner, recipient, equipment, quantity, " +
            "device_code AS deviceCode, condition, delivery_date AS deliveryDate FROM report WHERE " +
            "EXTRACT(MONTH FROM delivery_date) = :month ORDER BY delivery_date", nativeQuery = true)
    List<ReportListQuery> findAllByMonth(@Param("month") Integer month);
}
