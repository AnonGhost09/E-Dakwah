package com.myProject.dakwah.models.requests;

import com.myProject.dakwah.models.Mosque;

public class KajianRequest {
    private Mosque mosque;
    private String description;

    public Mosque getMosque() {
        return mosque;
    }

    public void setMosque(Mosque mosque) {
        this.mosque = mosque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
