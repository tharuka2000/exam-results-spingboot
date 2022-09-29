package com.example.service;

import com.example.model.Student;
import com.example.repository.MarksRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MarksRepository marksRepository;

    public String updateStudent(Long id, Student student){
        Optional<Student> studentResponse = studentRepository.findById(id);
        if(studentResponse.isPresent()){
            Student updateStudent =studentResponse.get();
            updateStudent.setName(student.getName());
            updateStudent.setNumber(student.getNumber());
            updateStudent.setMarks(student.getMarks());
            studentRepository.save(updateStudent);
            return "Updated ...";
        }
        return "User doesn't exist";

    }

    public String saveStudent(Student student){
        studentRepository.save(student);

        return "Saved ...";
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

}
