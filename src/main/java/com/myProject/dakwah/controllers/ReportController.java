package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.ReportCount;
import com.myProject.dakwah.models.ReportUserKajian;
import com.myProject.dakwah.models.responses.DownloadResponse;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.ReportService;
import com.myProject.dakwah.utils.ToCsv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.REPORT_URL)
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/count")
    public ResponseEntity getReportCount() throws Exception {
       ReportCount result = reportService.getReportingCount();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get report", result));
    }

    @GetMapping("/attendance")
    public ResponseEntity getReportUserKajian() throws Exception {
        List<ReportUserKajian> result = reportService.getReportingUserToKajian();

        ToCsv toCsv = new ToCsv("src/main/java/com/myProject/dakwah/assets/reportAttendance.csv");
        String path = toCsv.getPath();
        toCsv.writeData(result);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new DownloadResponse<>( "Success get all reporting, link download ada di paling bawah",path,result));
    }
}
