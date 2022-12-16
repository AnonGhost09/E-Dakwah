package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;
import com.myProject.dakwah.repositories.KajianRepository;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KajianServiceImpl implements KajianService {
    private KajianRepository kajianRepository;
    private MosqueService mosqueService;

    public KajianServiceImpl(KajianRepository kajianRepository, MosqueService mosqueService) {
        this.kajianRepository = kajianRepository;
        this.mosqueService = mosqueService;
    }

    @Transactional
    @Override
    public Kajian createKajian(Kajian kajian){
        try {
            Mosque mosque = mosqueService.findById(kajian.getMosque().getMosqueId());
            kajian.setMosque(mosque);
            return kajianRepository.save(kajian);
        } catch (Exception e) {
            throw new RuntimeException("Kajian gagal dimasukan" );
        }
    }

    @Override
    public Kajian findById(Integer id) throws Exception{
            Optional<Kajian> kajian = kajianRepository.getByIdQuery(id);

            if (kajian.isEmpty()) {
                throw new NotFoundException("Data Kajian Tidak Ada");
            }

            return kajian.get();
    }

    @Override
    public List<Kajian> getAllKajian() throws Exception{
           List<Kajian> kajians = kajianRepository.getAllQuery();

            if(kajians.isEmpty()){
                throw new NotFoundException("Data Kajian Tidak Tersedia");
            }

            return kajians;
    }
}
