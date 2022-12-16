package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.Profile;
import com.myProject.dakwah.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    @Query(value = "SELECT * FROM tb_profile",nativeQuery = true)
    List<Profile> getAllQuery();

    @Query(value = "SELECT * FROM tb_profile WHERE profile_id=?1",nativeQuery = true)
    Optional<Profile> getByIdQuery(Integer id);

    @Query(value = "SELECT * FROM tb_profile WHERE user_id=?1",nativeQuery = true)
    Optional<Profile> findByUserId(Integer userId);
}
