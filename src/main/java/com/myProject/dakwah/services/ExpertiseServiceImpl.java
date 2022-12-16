package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Expertise;
import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Expertise;
import com.myProject.dakwah.repositories.ExpertiseRepository;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExpertiseServiceImpl implements ExpertiseService{
    private ExpertiseRepository expertiseRepository;

    public ExpertiseServiceImpl(ExpertiseRepository expertiseRepository) {
        this.expertiseRepository = expertiseRepository;
    }

    @Override
    public Expertise findById(Integer id) throws Exception{
            Optional<Expertise> expertise = expertiseRepository.getByIdQuery(id);

            if (expertise.isEmpty()) {
                throw new NotFoundException("Data Expertise Tidak Ada");
            }

            return expertise.get();
    }

    @Transactional
    @Override
    public Expertise createExpertise(Expertise expertise) {
        try {
            return expertiseRepository.save(expertise);
        }catch (Exception e){
            throw new RuntimeException("Expertise gagal dimasukan");
        }
    }

    @Override
    public List<Expertise> getAllExpertise() throws Exception{
            List<Expertise> expertises= expertiseRepository.getAllQuery();

            if(expertises.isEmpty()){
                throw new NotFoundException("Data expertise Tidak Tersedia");
            }

            return expertises;
    }
}
