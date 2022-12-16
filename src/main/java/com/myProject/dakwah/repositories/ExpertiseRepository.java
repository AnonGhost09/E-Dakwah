package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.Expertise;
import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExpertiseRepository extends CrudRepository<Expertise, Integer> {
    @Query(value = "SELECT * FROM tb_expertise e",nativeQuery = true)
    List<Expertise> getAllQuery();

    @Query(value = "SELECT * FROM tb_expertise WHERE expertise_id=?1",nativeQuery = true)
    Optional<Expertise> getByIdQuery(Integer id);

}
