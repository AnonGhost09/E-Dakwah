package com.myProject.dakwah.models.requests;

import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.Profile;

import javax.persistence.Column;
import java.util.Date;

public class UserRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
