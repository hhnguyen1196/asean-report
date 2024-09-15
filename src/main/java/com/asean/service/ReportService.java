package com.asean.service;

import com.asean.request.InsertOrUpdateReportRequest;
import com.asean.response.GetAllReportResponse;

import java.util.List;

public interface ReportService {

    List<GetAllReportResponse> getAll();

    void insertOrUpdateReport(InsertOrUpdateReportRequest request);

    void deleteReport(Long id);
}
