package com.example.thmd4.service.impl;

import com.example.thmd4.model.Classroom;
import com.example.thmd4.repository.ClassroomRepository;
import com.example.thmd4.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findOne(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public void save(Classroom classroom) {
        classroomRepository.save(classroom);

    }

    @Override
    public void delete(Long id) {
        classroomRepository.deleteById(id);

    }
}
