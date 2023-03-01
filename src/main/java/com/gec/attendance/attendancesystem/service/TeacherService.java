package com.gec.attendance.attendancesystem.service;

import com.gec.attendance.attendancesystem.model.Teacher;
import com.gec.attendance.attendancesystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public String teacherServiceTest(){
        return "teacherServiceTest";
    }

    public void save (Teacher teacher){
        teacherRepository.save(teacher);

    }

    public List<Teacher> findAllTeacher(){
        List<Teacher> teacherList = teacherRepository.findAll();

        return teacherList;
    }
}
