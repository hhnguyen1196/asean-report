package com.asean.controller;

import com.asean.request.InsertListReportRequest;
import com.asean.request.InsertOrUpdateReportRequest;
import com.asean.response.GetAllReportResponse;
import com.asean.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReportController {

    private ReportService reportService;

    @GetMapping("/reports")
    public ResponseEntity<List<GetAllReportResponse>> getAllReport(@RequestParam("month") Integer month,
                                                                   @RequestParam("year") Integer year) {
        return ResponseEntity.ok(reportService.getAll(month, year));
    }

    @PostMapping("/reports")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertOrUpdateReport(@RequestBody InsertOrUpdateReportRequest request) {
        reportService.insertOrUpdateReport(request);
    }

    @DeleteMapping("/reports/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable("id") Long id) {
        reportService.deleteReport(id);
    }

    @PostMapping("/reports/list")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertListReport(@RequestBody List<InsertListReportRequest> request) {
        reportService.insertList(request);
    }

}
