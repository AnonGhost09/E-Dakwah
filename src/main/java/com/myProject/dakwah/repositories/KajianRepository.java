package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface KajianRepository extends CrudRepository<Kajian, Integer> {
    @Query(value = "SELECT * FROM tb_kajian k LEFT JOIN tb_mosque m ON k.kajian_id=m.mosque_id",nativeQuery = true)
    List<Kajian> getAllQuery();

    @Query(value = "SELECT * FROM tb_kajian WHERE kajian_id=?1",nativeQuery = true)
    Optional<Kajian> getByIdQuery(Integer id);
}
