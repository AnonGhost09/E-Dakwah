package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.User;
import com.myProject.dakwah.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM tb_user p",nativeQuery = true)
    List<User> getAllQuery();

    @Query(value = "SELECT * FROM tb_user p WHERE p.user_id = ?1",  nativeQuery = true)
    Optional<User> getByIdQuery(Integer id);

    @Query(value = "SELECT * FROM tb_user p WHERE p.email = ?1",  nativeQuery = true)
    Optional<User> checkEmailUser(String email);
}
