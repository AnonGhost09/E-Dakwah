package com.myProject.dakwah.services;

import com.myProject.dakwah.models.Expertise;
import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;

import java.util.List;

public interface ExpertiseService {
    Expertise createExpertise(Expertise expertise);
    List<Expertise> getAllExpertise() throws Exception;
    Expertise findById(Integer id) throws Exception;

}
