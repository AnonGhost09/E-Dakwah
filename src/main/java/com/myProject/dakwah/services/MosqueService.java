package com.myProject.dakwah.services;

import com.myProject.dakwah.models.Mosque;

import java.util.List;

public interface MosqueService {
    Mosque createMosque(Mosque mosque);
    List<Mosque> getAllMosque() throws Exception;
    Mosque findById(Integer id) throws Exception;
    Mosque deleteMosque(Integer id);
}
