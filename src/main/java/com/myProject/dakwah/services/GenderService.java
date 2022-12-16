package com.myProject.dakwah.services;

import com.myProject.dakwah.models.Gender;

import java.util.List;

public interface GenderService {
    Gender createGender(Gender gender);
    List<Gender> getAllGender() throws Exception;
    Gender findById(Integer id) throws Exception;
}
