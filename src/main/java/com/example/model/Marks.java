package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Student_marks")
public class Marks {

    @Column
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subject;

    @Column
    private int marks;

    @Column(name = "sm_fid")
    private Long studentForeignKey;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Long getStudentForeignKey() {
        return studentForeignKey;
    }

    public void setStudentForeignKey(Long studentForeignKey) {
        this.studentForeignKey = studentForeignKey;
    }

}
