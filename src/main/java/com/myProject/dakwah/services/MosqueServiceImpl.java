package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Mosque;
import com.myProject.dakwah.repositories.MosqueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MosqueServiceImpl implements MosqueService{

    private MosqueRepository mosqueRepository;

    public MosqueServiceImpl(MosqueRepository mosqueRepository) {
        this.mosqueRepository = mosqueRepository;
    }

    @Override
    public Mosque findById(Integer id) throws Exception {
            Optional<Mosque> mosque = mosqueRepository.getByIdQuery(id);

            if (mosque.isEmpty()) {
                throw new NotFoundException("Data Mosque Tidak Ada");
            }

            return mosque.get();
    }

    @Transactional
    @Override
    public Mosque createMosque(Mosque mosque) {
        try {
            return mosqueRepository.save(mosque);
          } catch (Exception e) {
           throw new RuntimeException("Mosque gagal dimasukan" );
        }
    }

    @Transactional
    @Override
    public Mosque deleteMosque(Integer id) {
        try {
            Mosque mosque = findById(id);
            mosqueRepository.deleteById(id);
            return mosque;
        } catch (Exception e) {
            throw new RuntimeException("Mosque gagal dihapus " + e.getMessage() );
        }
    }

    @Override
    public List<Mosque> getAllMosque() throws Exception{
            List<Mosque> mosques = mosqueRepository.getAllQuery();

            if(mosques.isEmpty()){
                throw new NotFoundException("Data Mosque Tidak Tersedia");
            }

            return mosques;
    }
}
