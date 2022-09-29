package com.example.controllers;

import com.example.model.Student;
import com.example.repository.MarksRepository;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class StudentController {



    @Autowired
    private StudentService studentService;


    @RequestMapping(method = RequestMethod.GET , value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping( value ="/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/student")
    public String saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student/{id}")
    public String updateStudent(@PathVariable long id, @RequestBody Student student){
      return studentService.updateStudent(id,student);
    }


}
