package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;
import com.myProject.dakwah.models.Preacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PreacherRepository extends CrudRepository<Preacher, Integer> {
    @Query(value = "SELECT * FROM tb_preacher p",nativeQuery = true)
    List<Preacher> getAllQuery();

    @Query(value = "SELECT * FROM tb_preacher p WHERE p.preacher_id = ?1",  nativeQuery = true)
    Optional<Preacher> getByIdQuery(Integer id);
}
