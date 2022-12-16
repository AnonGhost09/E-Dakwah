package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Attendance;
import com.myProject.dakwah.models.Attendance;
import com.myProject.dakwah.models.requests.AttendanceRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.ATTENDANCE_URL)
public class AttendanceController {
    private AttendanceService attendanceService;
    private ModelMapper modelMapper;

    public AttendanceController(AttendanceService attendanceService, ModelMapper modelMapper) {
        this.attendanceService = attendanceService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createAttendance(@RequestBody AttendanceRequest attendanceRequest) throws Exception{
        Attendance attendance = modelMapper.map(attendanceRequest, Attendance.class);
        Attendance result = attendanceService.createAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create attendance",result));
    }

    @GetMapping
    public ResponseEntity getAttendance() throws  Exception{
        List<Attendance> result = attendanceService.getAllAttendance();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get all attendance", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getAttendanceById(@PathVariable Integer id) throws Exception {

        Attendance result = attendanceService.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create attendance", result));
    }
}
