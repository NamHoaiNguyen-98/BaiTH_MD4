package com.example.thmd4.service;

import com.example.thmd4.dto.request.Pageable;
import com.example.thmd4.exception.ValidationException;
import com.example.thmd4.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService extends IGenerateService<Student>{
    Page<Student> findAll(int page, int size);
    Page<Student> searchByName(int page, int size, String name);
    Page<Student> searchByName1(Pageable pageable, String name);

    List<Student> sortByNameDesc();
    List<Student> sortByNameAcs();
    List<Student> sortByAgeDesc();
    List<Student> sortByAgeAcs();
    Boolean checkEmailExists(String email);
    Boolean checkEmailUpdateExists(String email, Long id);
    Page<Student> findByClass(int page, int size,Long id);

    Student create(Student student) throws ValidationException;
}
