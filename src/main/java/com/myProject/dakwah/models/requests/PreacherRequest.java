package com.myProject.dakwah.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myProject.dakwah.models.Expertise;
import com.myProject.dakwah.models.Gender;

import javax.persistence.*;
import java.util.Date;

public class PreacherRequest {
    private String name;

    private Gender gender;

    private Date dateBirth;

    private String placeBirth;

    private Expertise expertise;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public Expertise getExpertise() {
        return expertise;
    }

    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }
}
