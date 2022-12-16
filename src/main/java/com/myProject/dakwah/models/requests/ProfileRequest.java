package com.myProject.dakwah.models.requests;

import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.User;

import javax.persistence.*;
import java.util.Date;

public class ProfileRequest {
    private String name;

    private Date dateBirth;

    private String placeBirth;

    private Gender gender;

    private String phone;
    private User user;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
