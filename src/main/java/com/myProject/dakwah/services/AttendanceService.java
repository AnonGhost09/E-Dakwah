package com.myProject.dakwah.services;

import com.myProject.dakwah.models.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance createAttendance(Attendance attendance) throws Exception;
    List<Attendance> getAllAttendance() throws Exception;
    Attendance findById(Integer id) throws Exception;
}
