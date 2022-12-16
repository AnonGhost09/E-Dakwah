package com.myProject.dakwah.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_kajian_schedule")
public class KajianSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kajian_schedule_id")
    private Integer kajianScheduleId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "penceramah_id")
    private Preacher preacher;

    @ManyToOne
    @JoinColumn(name = "kajian_id")
    @JsonIgnoreProperties("kajianSchedules")
    private Kajian kajian;

    @OneToMany(mappedBy = "kajianSchedule",cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("kajianSchedules")
    private List<Attendance> attendance;

    public Integer getKajianScheduleId() {
        return kajianScheduleId;
    }

    public void setKajianScheduleId(Integer kajianScheduleId) {
        this.kajianScheduleId = kajianScheduleId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Preacher getPreacher() {
        return preacher;
    }

    public void setPreacher(Preacher preacher) {
        this.preacher = preacher;
    }

    public Kajian getKajian() {
        return kajian;
    }

    public void setKajian(Kajian kajian) {
        this.kajian = kajian;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }
}
