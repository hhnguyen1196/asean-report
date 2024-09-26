package com.asean.service.impl;

import com.asean.entity.Report;
import com.asean.repository.ReportRepository;
import com.asean.request.InsertListReportRequest;
import com.asean.request.InsertOrUpdateReportRequest;
import com.asean.response.GetAllReportResponse;
import com.asean.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    @Override
    public List<GetAllReportResponse> getAll(Integer month, Integer year) {
        return reportRepository.findAllByMonthAndYear(month, year).stream().map(e -> GetAllReportResponse
                .builder()
                .id(e.getId())
                .deliveryPartner(e.getDeliveryPartner())
                .recipient(e.getRecipient())
                .equipment(e.getEquipment())
                .quantity(e.getQuantity())
                .deviceCode(e.getDeviceCode())
                .condition(e.getCondition())
                .deliveryDate(e.getDeliveryDate())
                .build()).collect(Collectors.toList());
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

    @Override
    @Transactional
    public void insertList(List<InsertListReportRequest> requests) {
        List<Report> reports = requests.stream().map(request -> Report.builder()
                        .id(request.getId())
                        .deliveryPartner(request.getDeliveryPartner())
                        .recipient(request.getRecipient())
                        .equipment(request.getEquipment())
                        .quantity(request.getQuantity())
                        .deviceCode(request.getDeviceCode())
                        .condition(request.getCondition())
                        .deliveryDate(request.getDeliveryDate())
                        .build())
                .collect(Collectors.toList());
        reportRepository.saveAll(reports);
    }
}
