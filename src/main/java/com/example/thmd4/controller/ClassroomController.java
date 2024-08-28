package com.example.thmd4.controller;
import com.example.thmd4.model.Classroom;
import com.example.thmd4.model.Student;
import com.example.thmd4.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<Classroom> findOne(@PathVariable("id") Long id) {
        Optional<Classroom> classroomOptional = classroomService.findOne(id);
        if(classroomOptional.isPresent()) {
            Classroom classroom = classroomOptional.get();
            return new ResponseEntity<>(classroom, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Classroom classroom) {

        classroomService.save(classroom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        classroomService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
