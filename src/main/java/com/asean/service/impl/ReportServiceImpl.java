package com.asean.service.impl;

import com.asean.entity.Report;
import com.asean.enums.ReportConditionEnum;
import com.asean.repository.ReportRepository;
import com.asean.request.InsertOrUpdateReportRequest;
import com.asean.response.GetAllReportResponse;
import com.asean.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    private final String NEW = "Mới";

    private final String OLD = "Cũ";

    @Override
    public List<GetAllReportResponse> getAll() {
        return reportRepository.findAll().stream().map(e -> GetAllReportResponse
                .builder()
                .id(e.getId())
                .deliveryPartner(e.getDeliveryPartner())
                .recipient(e.getRecipient())
                .equipment(e.getEquipment())
                .quantity(e.getQuantity())
                .deviceCode(e.getDeviceCode())
                .condition(ReportConditionEnum.valueOf(e.getCondition()) == ReportConditionEnum.NEW ?
                        NEW : OLD)
                .deliveryDate(e.getDeliveryDate())
                .build()).toList();
    }

    @Override
    public void insertOrUpdateReport(InsertOrUpdateReportRequest request) {
        reportRepository.save(Report.builder()
                .id(request.getId())
                .deliveryPartner(request.getDeliveryPartner())
                .recipient(request.getRecipient())
                .equipment(request.getEquipment())
                .quantity(request.getQuantity())
                .deviceCode(request.getDeviceCode())
                .condition(request.getCondition())
                .deliveryDate(request.getDeliveryDate())
                .build());
    }

    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
