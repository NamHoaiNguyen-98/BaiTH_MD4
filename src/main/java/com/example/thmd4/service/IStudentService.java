package com.example.thmd4.service;

import com.example.thmd4.model.Student;

import java.util.List;

public interface IStudentService extends IGenerateService<Student>{
    List<Student> searchByName(String name);
}
