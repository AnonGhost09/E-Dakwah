package com.myProject.dakwah.services;

import com.myProject.dakwah.models.ReportCount;
import com.myProject.dakwah.models.ReportUserKajian;

import java.util.List;

public interface ReportService {
    ReportCount getReportingCount() throws Exception;

    List<ReportUserKajian> getReportingUserToKajian() throws Exception;
}