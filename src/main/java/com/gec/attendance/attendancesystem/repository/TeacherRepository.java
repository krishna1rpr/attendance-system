package com.gec.attendance.attendancesystem.repository;

import com.gec.attendance.attendancesystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
