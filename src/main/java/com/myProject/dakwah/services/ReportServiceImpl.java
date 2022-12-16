package com.myProject.dakwah.services;

import com.myProject.dakwah.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    private MosqueService mosqueService;
    private KajianService kajianService;
    private PreacherService preacherService;
    private UserService userService;
    private KajianScheduleService kajianScheduleService;

    public ReportServiceImpl(MosqueService mosqueService, KajianService kajianService, PreacherService preacherService, UserService userService, KajianScheduleService kajianScheduleService) {
        this.mosqueService = mosqueService;
        this.kajianService = kajianService;
        this.preacherService = preacherService;
        this.userService = userService;
        this.kajianScheduleService = kajianScheduleService;
    }

    public Report getReportingCount() throws Exception {
        List<Mosque> mosques = mosqueService.getAllMosque();
        List<Kajian> kajians = kajianService.getAllKajian();
        List<Preacher> preachers = preacherService.getAllPreacher();
        List<User> users = userService.getAllUser();
        List<KajianSchedule> kajianSchedules = kajianScheduleService.getAllKajianSchedule();

        Long totalMosque = mosques.stream().count();
        Long totalKajian = kajians.stream().count();
        Long totalPreacher = preachers.stream().count();
        Long totalUser = users.stream().count();
        Long totalKajianSchedules = kajianSchedules.stream().count();

        Report report = new Report();
        report.setTotalKajian(totalKajian);
        report.setTotalMosque(totalMosque);
        report.setTotalPreacher(totalPreacher);
        report.setTotalUser(totalUser);
        report.setTotalUserKajian(totalKajianSchedules);

        return report;
    }
}
