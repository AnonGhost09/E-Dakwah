package com.myProject.dakwah.services;

import com.myProject.dakwah.models.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService{
    private MosqueService mosqueService;
    private KajianService kajianService;
    private PreacherService preacherService;
    private UserService userService;
    private KajianScheduleService kajianScheduleService;

    private AttendanceService attendanceService;

    public ReportServiceImpl(MosqueService mosqueService, KajianService kajianService, PreacherService preacherService, UserService userService, KajianScheduleService kajianScheduleService, AttendanceService attendanceService) {
        this.mosqueService = mosqueService;
        this.kajianService = kajianService;
        this.preacherService = preacherService;
        this.userService = userService;
        this.kajianScheduleService = kajianScheduleService;
        this.attendanceService = attendanceService;
    }

    public ReportCount getReportingCount() throws Exception {
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

        ReportCount reportCount = new ReportCount();
        reportCount.setTotalKajian(totalKajian);
        reportCount.setTotalMosque(totalMosque);
        reportCount.setTotalPreacher(totalPreacher);
        reportCount.setTotalUser(totalUser);
        reportCount.setTotalUserKajian(totalKajianSchedules);

        return reportCount;
    }

    public List<ReportUserKajian> getReportingUserToKajian() throws Exception {
        List<Attendance> attendances = attendanceService.getAllAttendance();

        List<ReportUserKajian> reportUserKajians = attendances.stream().map(attendance -> {
            ReportUserKajian reportUserKajian = new ReportUserKajian();
            reportUserKajian.setName(attendance.getProfile().getName());
            reportUserKajian.setPhone(attendance.getProfile().getPhone());
            reportUserKajian.setDateBirth(attendance.getProfile().getDateBirth());
            reportUserKajian.setPlaceBirth(attendance.getProfile().getPlaceBirth());

            return reportUserKajian;
        }).collect(Collectors.toList());

        return reportUserKajians;
    }
}
