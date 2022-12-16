package com.myProject.dakwah.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Integer attendanceId;

    @Temporal(TemporalType.DATE)
    @Column(name = "list_date")
    private Date listDate;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @JsonIgnoreProperties("attendance")
    private Profile profile;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kajian_schedule_id")
    @JsonIgnoreProperties("attendance")
    private KajianSchedule kajianSchedule;

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getListDate() {
        return listDate;
    }

    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public KajianSchedule getKajianSchedule() {
        return kajianSchedule;
    }

    public void setKajianSchedule(KajianSchedule kajianSchedule) {
        this.kajianSchedule = kajianSchedule;
    }
}
