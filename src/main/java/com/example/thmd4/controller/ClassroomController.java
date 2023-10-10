package com.example.thmd4.controller;

import com.example.thmd4.model.Classroom;
import com.example.thmd4.repository.ClassroomRepository;
import com.example.thmd4.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classrooms")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;
    @GetMapping
    public ResponseEntity<Iterable<Classroom>> findAll() {
        Iterable<Classroom> classrooms = classroomService.findAll();
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

}
