package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.KajianSchedule;
import com.myProject.dakwah.models.Preacher;
import com.myProject.dakwah.repositories.KajianScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KajianScheduleServiceImpl implements KajianScheduleService{

    private KajianScheduleRepository kajianScheduleRepository;
    private KajianService kajianService;
    private PreacherService preacherService;


    public KajianScheduleServiceImpl(KajianScheduleRepository kajianScheduleRepository, KajianService kajianService, PreacherService preacherService) {
        this.kajianScheduleRepository = kajianScheduleRepository;
        this.kajianService = kajianService;
        this.preacherService = preacherService;
    }

    @Override
    public KajianSchedule findById(Integer id) throws Exception {

            Optional<KajianSchedule> kajianSchedule = kajianScheduleRepository.getByIdQuery(id);

            if (kajianSchedule.isEmpty()) {
                throw new NotFoundException("Data KajianSchedule Tidak Ada");
            }

            return kajianSchedule.get();
    }

    @Transactional
    @Override
    public KajianSchedule createKajianSchedule(KajianSchedule kajianSchedule){
        try {
            Kajian kajian = kajianService.findById(kajianSchedule.getKajian().getKajianId());
            Preacher preacher = preacherService.findById(kajianSchedule.getPreacher().getPreacherId());

            kajianSchedule.setKajian(kajian);
            kajianSchedule.setPreacher(preacher);

            return kajianScheduleRepository.save(kajianSchedule);
        } catch (Exception e) {
            throw new RuntimeException("KajianSchedule gagal dimasukan" );
        }
    }

    @Override
    public List<KajianSchedule> getAllKajianSchedule() throws Exception {

            List<KajianSchedule> kajianSchedules = kajianScheduleRepository.getAllQuery();

            if(kajianSchedules.isEmpty()){
                throw new NotFoundException("Data KajianSchedule Tidak Tersedia");
            }

            return kajianSchedules;
    }
}
