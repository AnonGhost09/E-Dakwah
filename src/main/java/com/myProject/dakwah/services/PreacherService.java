package com.myProject.dakwah.services;

import com.myProject.dakwah.models.Preacher;

import java.util.List;

public interface PreacherService {
    Preacher createPreacher(Preacher preacher);
    List<Preacher> getAllPreacher() throws Exception;
    Preacher findById(Integer id) throws Exception;
}
