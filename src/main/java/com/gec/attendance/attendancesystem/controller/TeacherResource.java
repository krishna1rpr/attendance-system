package com.gec.attendance.attendancesystem.controller;

import com.gec.attendance.attendancesystem.model.Teacher;
import com.gec.attendance.attendancesystem.service.TeacherService;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/teachers")
public class TeacherResource {

    private TeacherService teacherService;

    public TeacherResource(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/addTeacher")
    public String formView(){
        return "FORM HERE!!";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@RequestBody Teacher teacher){

        System.out.println("----------------------------------");
        System.out.println("----------------------------------ADD TEACHER CONTROLLER CALLED----------------------------------");
        System.out.println("----------------------------------");
        System.out.println(teacher);
        teacherService.save(teacher);
        return "Teacher added to DB";

//        boolean check = teacherService.addTeacher(teacher);
//        if(check){
//            return "Teacher added to DB";
//        } else{
//            return "Error!! Techer Not Added!";
//        }
    }

    @GetMapping("/findAll")
    public List<Teacher> Teachers(){

        System.out.println("----------------------------------");
        System.out.println("----------------------------------GET ALL TEACHER CONTROLLER CALLED----------------------------------");
        System.out.println("----------------------------------");

        List<Teacher> teacherList = teacherService.findAllTeacher();

        return teacherList;
    }

}
