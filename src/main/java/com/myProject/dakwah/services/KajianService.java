package com.myProject.dakwah.services;

import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;

import java.util.List;

public interface KajianService {
    Kajian createKajian(Kajian kajian);
    List<Kajian> getAllKajian() throws Exception;

    Kajian findById(Integer id) throws Exception;
}
