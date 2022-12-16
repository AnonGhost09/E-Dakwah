package com.myProject.dakwah.repositories;

import com.myProject.dakwah.models.Attendance;
import com.myProject.dakwah.models.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
    @Query(value = "SELECT * FROM tb_attendance",nativeQuery = true)
    List<Attendance> getAllQuery();

    @Query(value = "SELECT * FROM tb_attendance WHERE attendance_id=?1",nativeQuery = true)
    Optional<Attendance> getByIdQuery(Integer id);
}
