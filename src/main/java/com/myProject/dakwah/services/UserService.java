package com.myProject.dakwah.services;

import com.myProject.dakwah.models.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    User createUser(User user) throws NoSuchAlgorithmException, Exception;
    List<User> getAllUser() throws Exception;
    User findById(Integer id) throws Exception;
}
