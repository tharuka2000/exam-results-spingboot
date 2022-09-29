package com.example.domin;

import com.example.model.Marks;

import java.util.ArrayList;

public class StudentMarks {
    private String studentName;

    private String SubjectName;
    private int mark;




    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
