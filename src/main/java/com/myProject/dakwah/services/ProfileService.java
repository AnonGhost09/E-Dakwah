package com.myProject.dakwah.services;

import com.myProject.dakwah.models.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile profile) throws Exception;
    List<Profile> getAllProfile() throws Exception;
    Profile findById(Integer id) throws Exception;
    Profile deleteProfile(Integer id);

    Profile updateProfile(Profile profile) throws Exception;
}
