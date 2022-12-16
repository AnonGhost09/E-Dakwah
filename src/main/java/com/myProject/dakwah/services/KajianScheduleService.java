package com.myProject.dakwah.services;

import com.myProject.dakwah.models.KajianSchedule;
import com.myProject.dakwah.models.Mosque;

import java.util.List;

public interface KajianScheduleService {
    KajianSchedule createKajianSchedule(KajianSchedule kajianSchedule);
    List<KajianSchedule> getAllKajianSchedule() throws Exception;
    KajianSchedule findById(Integer id) throws Exception;
}
