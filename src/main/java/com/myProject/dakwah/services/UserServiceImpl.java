package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.ConstraintException;
import com.myProject.dakwah.exception.EntityExistException;
import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.Profile;
import com.myProject.dakwah.models.User;
import com.myProject.dakwah.repositories.ProfileRepository;
import com.myProject.dakwah.repositories.UserRepository;
import com.myProject.dakwah.utils.Md5;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Value("${user.password.salt}")
    private String salt;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) throws Exception{

            Optional<User> user = userRepository.getByIdQuery(id);

            if (user.isEmpty()) {
                throw new NotFoundException("Data User Tidak Ada");
            }

            return user.get();
    }

    @Transactional
    @Override
    public User createUser(User user) throws NoSuchAlgorithmException, Exception {
            Optional<User> uniqueCheck = userRepository.checkEmailUser(user.getEmail());

            if(!uniqueCheck.isEmpty()){
                throw new EntityExistException("Email user sudah ada");
            }

            user.setPassword(Md5.md5(salt,user.getPassword()));
            User userResult = userRepository.save(user);

            return userResult;
    }

    @Override
    public List<User> getAllUser() throws Exception{
            List<User> users = userRepository.getAllQuery();

            if(users.isEmpty()){
                throw new NotFoundException("Data User Tidak Tersedia");
            }

            return users;
    }
}
