package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Expertise;
import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.Preacher;
import com.myProject.dakwah.repositories.PreacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PreacherServiceImpl implements PreacherService{
    private PreacherRepository preacherRepository;
    private GenderService genderService;
    private ExpertiseService expertiseService;

    public PreacherServiceImpl(PreacherRepository preacherRepository, GenderService genderService, ExpertiseService expertiseService) {
        this.preacherRepository = preacherRepository;
        this.genderService = genderService;
        this.expertiseService = expertiseService;
    }

    @Override
    public Preacher findById(Integer id) throws Exception {
            Optional<Preacher> preacher = preacherRepository.getByIdQuery(id);

            if (preacher.isEmpty()) {
                throw new NotFoundException("Data Preacher Tidak Ada");
            }

            return preacher.get();
    }

    @Transactional
    @Override
    public Preacher createPreacher(Preacher preacher) {
        try {
            Gender gender = genderService.findById(preacher.getGender().getGenderId());
            Expertise expertise = expertiseService.findById(preacher.getExpertise().getExpertiseId());

            preacher.setGender(gender);
            preacher.setExpertise(expertise);

            return preacherRepository.save(preacher);
        } catch (Exception e) {
            throw new RuntimeException("Preacher gagal dimasukan" );
        }
    }

    @Override
    public List<Preacher> getAllPreacher() throws Exception{
            List<Preacher> preachers = preacherRepository.getAllQuery();

            if(preachers.isEmpty()){
                throw new NotFoundException("Data Preacher Tidak Tersedia");
            }

            return preachers;
    }
}
