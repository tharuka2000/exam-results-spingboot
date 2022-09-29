package com.example.repository;

import com.example.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    public List<Marks> findByStudentForeignKey(Long studentId);
    public List<Marks> findByStudentForeignKeyAndSubject(Long studentId, String subject);
}
