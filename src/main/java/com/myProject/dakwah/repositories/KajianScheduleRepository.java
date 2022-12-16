package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.KajianSchedule;
import com.myProject.dakwah.models.Preacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface KajianScheduleRepository extends CrudRepository<KajianSchedule, Integer> {
    @Query(value = "SELECT * FROM tb_kajian_schedule", nativeQuery = true)
    List<KajianSchedule> getAllQuery();

    @Query(value = "SELECT * FROM tb_kajian_schedule ks WHERE ks.kajian_schedule_id=?1",  nativeQuery = true)
    Optional<KajianSchedule> getByIdQuery(Integer id);
}
