package com.example.model;

import org.w3c.dom.stylesheets.LinkStyle;
import org.yaml.snakeyaml.error.Mark;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private  String name;
    @Column
    private String number;

    @OneToMany(cascade = CascadeType.ALL)
    /*Define foreign Key*/
   @JoinColumn(name = "sm_fid", referencedColumnName = "id")
    private
    List <Marks> marks = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }
}
