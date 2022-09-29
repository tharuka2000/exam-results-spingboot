package com.example.service;

import com.example.domin.StudentMarks;
import com.example.model.Marks;
import com.example.model.Student;
import com.example.repository.MarksRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MarksService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MarksRepository marksRepository;

    public List<StudentMarks> getStudentMarks (){
        Iterable<Marks> marks = marksRepository.findAll();
        ArrayList<StudentMarks> studentMarksArrayList = new ArrayList<>();
        marks.forEach(mark -> {
            StudentMarks studentMarks = new StudentMarks();
            studentMarks.setMark(mark.getMarks());
            studentMarks.setStudentName(mark.getSubject());
            if(mark.getStudentForeignKey() !=null){
                Optional <Student> student = studentRepository.findById(mark.getStudentForeignKey());
                if (student.isPresent()){
                    Student foundStudent = student.get();
                    studentMarks.setStudentName(foundStudent.getName());
                }
            }
           studentMarksArrayList.add(studentMarks);
        });
        return studentMarksArrayList;
    }
//    public List<StudentMarks> getStudentMarks () {
//        Iterable <Student> student = studentRepository.findAll();
//        ArrayList<StudentMarks> studentMarksArrayList = new ArrayList<>();
//        student.forEach(student1 -> {
//            StudentMarks studentMarks = new StudentMarks();
//            student1.getMarks().forEach(mark -> {
//                studentMarks.setMark(mark.getMarks());
//                studentMarks.setStudentName(student1.getName());
//                studentMarks.setSubjectName(mark.getSubject());
//
//                studentMarksArrayList.add(studentMarks);
//            });
//        });
//
//        return studentMarksArrayList;
//    }

    public String  saveMarksForSubject( Long studentId, Marks marks){
        Optional<Student> student = studentRepository.findById(studentId);

        if (!student.isPresent()){return "Student doesn't exist";}

        List<Marks> studentMarksWithSubject = marksRepository.findByStudentForeignKeyAndSubject(studentId,marks.getSubject());
        if(studentMarksWithSubject.size()==0){
            marks.setStudentForeignKey(studentId);
            marksRepository.save(marks);
            return " Marks added";
        };
        studentMarksWithSubject.forEach(marks1 -> {
            marks1.setMarks(marks.getMarks());
            marksRepository.save(marks1);
        });

        return "Marks Updated";
    }
    }
