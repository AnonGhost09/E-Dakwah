package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.repositories.GenderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {
    private GenderRepository genderRepository;

    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Gender findById(Integer id) throws Exception{
            Optional<Gender> gender = genderRepository.getByIdQuery(id);

            if (gender.isEmpty()) {
                throw new NotFoundException("Data Gender Tidak Ada");
            }

            return gender.get();
    }

    @Transactional
    @Override
    public Gender createGender(Gender gender){
        try {
            return genderRepository.save(gender);
        } catch (Exception e) {
            throw new RuntimeException("Gender gagal dimasukan" );
        }
    }

    @Override
    public List<Gender> getAllGender() throws Exception {

            List<Gender> genders = genderRepository.getAllQuery();

            if(genders.isEmpty()){
                throw new NotFoundException("Data Gender Tidak Tersedia");
            }

            return genders;
    }
}
