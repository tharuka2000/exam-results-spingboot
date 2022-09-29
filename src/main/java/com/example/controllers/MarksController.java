package com.example.controllers;

import com.example.domin.StudentMarks;
import com.example.model.Marks;
import com.example.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/marks")
public class MarksController {

    @Autowired
    MarksService marksService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<StudentMarks> getMarks(){
        return marksService.getStudentMarks();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/student/{studentId}")
    public String saveMarksForSubject(@PathVariable Long studentId, @RequestBody Marks marks){

        return marksService.saveMarksForSubject(studentId,marks);
    }


}
