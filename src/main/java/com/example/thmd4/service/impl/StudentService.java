package com.example.thmd4.service.impl;

import com.example.thmd4.dto.request.Pageable;
import com.example.thmd4.exception.AppException;
import com.example.thmd4.exception.ErrorCode;
import com.example.thmd4.exception.ValidationException;
import com.example.thmd4.model.Student;
import com.example.thmd4.repository.StudentRepository;
import com.example.thmd4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.thmd4.dto.request.Pageable.DEFAULT_PAGE;
import static com.example.thmd4.dto.request.Pageable.DEFAULT_PAGE_SIZE;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size));
    }


    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        String email = student.getEmail();
        if (checkEmailExists(email)) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        studentRepository.save(student);
    }

    @Override
    public Student create(Student student) throws ValidationException {
        String email = student.getEmail();
        if (checkEmailExists(email)) {
            throw new ValidationException("Email", "Existed");
        }
        studentRepository.save(student);
        return student;

    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Page<Student> searchByName(int page, int size, String name) {
        return studentRepository.searchByName(PageRequest.of(page, size), name);
    }

    @Override
    public Page<Student> searchByName1(Pageable pageable, String name) {
        if(pageable.getPage() == null | pageable.getPageSize() == null) {
            return studentRepository.searchByName(PageRequest.of(DEFAULT_PAGE, DEFAULT_PAGE_SIZE), name);
        }
        return studentRepository.searchByName(PageRequest.of(pageable.getPage(), pageable.getPageSize()), name);
    }

    @Override
    public List<Student> sortByNameDesc() {
        return studentRepository.sortByNameDesc();
    }

    @Override
    public List<Student> sortByNameAcs() {
        return studentRepository.sortByNameAsc();
    }

    @Override
    public List<Student> sortByAgeDesc() {
        return studentRepository.sortByAgeDesc();
    }

    @Override
    public List<Student> sortByAgeAcs() {
        return studentRepository.sortByAgeAsc();
    }

    @Override
    public Boolean checkEmailExists(String email) {
        return studentRepository.checkEmailCreateExits(email) != 0;
    }

    @Override
    public Boolean checkEmailUpdateExists(String email, Long id) {
        return studentRepository.checkEmailUpdateExits(email, id) != 0;
    }

    @Override
    public Page<Student> findByClass(int page, int size, Long id) {
        return studentRepository.findByClass(PageRequest.of(page, size), id);
    }
}
