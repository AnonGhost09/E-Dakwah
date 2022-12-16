package com.myProject.dakwah.models.requests;

import com.myProject.dakwah.models.KajianSchedule;
import com.myProject.dakwah.models.Profile;

import javax.persistence.*;
import java.util.Date;

public class AttendanceRequest {
    private Profile profile;

    private KajianSchedule kajianSchedule;

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
