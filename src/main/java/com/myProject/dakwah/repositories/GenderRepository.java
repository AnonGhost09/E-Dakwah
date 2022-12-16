package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.Mosque;
import com.myProject.dakwah.models.Preacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GenderRepository extends CrudRepository<Gender, Integer> {
    @Query(value = "SELECT * FROM tb_gender",nativeQuery = true)
    List<Gender> getAllQuery();

    @Query(value = "SELECT * FROM tb_gender WHERE gender_id=?1",nativeQuery = true)
    Optional<Gender> getByIdQuery(Integer id);
}
