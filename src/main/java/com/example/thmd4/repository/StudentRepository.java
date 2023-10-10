package com.example.thmd4.repository;

import com.example.thmd4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student s where s.name like %?%", nativeQuery = true)
    List<Student> searchByName(String name);
}
