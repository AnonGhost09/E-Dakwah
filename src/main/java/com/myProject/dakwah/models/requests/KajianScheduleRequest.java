package com.myProject.dakwah.models.requests;

import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Preacher;

import javax.persistence.*;
import java.util.Date;

public class KajianScheduleRequest {
    private Date startDate;

    private Date endDate;

    private Preacher preacher;

    private Kajian kajian;

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
}
