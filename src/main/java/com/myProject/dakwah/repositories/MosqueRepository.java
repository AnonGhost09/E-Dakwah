package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface MosqueRepository extends CrudRepository<Mosque, Integer>{

    @Query(value = "SELECT * FROM tb_mosque",nativeQuery = true)
    List<Mosque> getAllQuery();

    @Query(value = "SELECT * FROM tb_mosque WHERE mosque_id=?1",nativeQuery = true)
    Optional<Mosque> getByIdQuery(Integer id);
}
