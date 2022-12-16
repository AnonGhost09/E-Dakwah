package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.*;
import com.myProject.dakwah.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceRepository attendanceRepository;
    private KajianScheduleService kajianScheduleService;
    private ProfileService profileService;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, KajianScheduleService kajianScheduleService, ProfileService profileService) {
        this.attendanceRepository = attendanceRepository;
        this.kajianScheduleService = kajianScheduleService;
        this.profileService = profileService;
    }

    @Override
    public Attendance findById(Integer id) throws Exception{
        Optional<Attendance> attendance = attendanceRepository.getByIdQuery(id);

        if (attendance.isEmpty()) {
            throw new NotFoundException("Data Attendance Tidak Ada");
        }

        return attendance.get();
    }

    @Transactional
    @Override
    public Attendance createAttendance(Attendance attendance) throws Exception {
        System.out.println("tes1");
            Profile profile = profileService.findById(attendance.getProfile().getProfileId());
            KajianSchedule kajianSchedule = kajianScheduleService.findById(attendance.getKajianSchedule().getKajianScheduleId());
        System.out.println("tes1");
            attendance.setProfile(profile);
            attendance.setKajianSchedule(kajianSchedule);
            attendance.setListDate(new Date());

            return attendanceRepository.save(attendance);

    }

    @Override
    public List<Attendance> getAllAttendance() throws Exception{
        List<Attendance> attendances= attendanceRepository.getAllQuery();

        if(attendances.isEmpty()){
            throw new NotFoundException("Data attendance Tidak Tersedia");
        }

        return attendances;
    }
}
