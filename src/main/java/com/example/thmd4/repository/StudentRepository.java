package com.example.thmd4.repository;

import com.example.thmd4.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM student s where s.name like %?%", nativeQuery = true)
    Page<Student> searchByName(Pageable pageable, String name);
    @Query(value = "SELECT * FROM student s order by s.name desc ", nativeQuery = true)
    List<Student> sortByNameDesc();
    @Query(value = "SELECT * FROM student s order by s.name asc ", nativeQuery = true)
    List<Student> sortByNameAsc();
    @Query(value = "SELECT * FROM student s order by s.dob desc ", nativeQuery = true)
    List<Student> sortByAgeDesc();
    @Query(value = "SELECT * FROM student s order by s.dob asc ", nativeQuery = true)
    List<Student> sortByAgeAsc();
    @Query(value = "SELECT COUNT(*) from student where email = ?", nativeQuery = true)
    Integer checkEmailCreateExits(String email);
    @Query(value = "SELECT COUNT(*) from student where email = ? and id != ?", nativeQuery = true)
    Integer checkEmailUpdateExits(String email, Long id);
    @Query(value = "SELECT * from student where classroom_id = ?", nativeQuery = true)
    Page<Student> findByClass(Pageable pageable, Long id);

}
