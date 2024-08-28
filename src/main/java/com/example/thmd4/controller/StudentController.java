package com.example.thmd4.controller;

import com.example.thmd4.dto.request.SearchRequest;
import com.example.thmd4.dto.response.DfResponse;
import com.example.thmd4.exception.ValidationException;
import com.example.thmd4.model.Student;
import com.example.thmd4.service.IImageService;
import com.example.thmd4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {


    @Autowired
    private IStudentService studentService;
    @Autowired
    private IImageService imageService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Student>> findAll() {
        Iterable<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping()
    public Page<Student> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size) {
        return studentService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findOne(@PathVariable("id") Long id) {
        Optional<Student> studentOptional = studentService.findOne(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody @Valid Student student) {
//        if (student.getId() != null) {
//            if (studentService.checkEmailUpdateExists(student.getEmail(), student.getId())) {
//                return new ResponseEntity<>("Invalid email", HttpStatus.BAD_REQUEST);
//            }
//        } else {
//            if (studentService.checkEmailExists(student.getEmail())) {
//                return new ResponseEntity<>("Invalid email", HttpStatus.BAD_REQUEST);
//            }
//        }
//        studentService.save(student);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//    @PostMapping
//    public ApiResponse<Student> save(@RequestBody @Valid Student student) {
//        ApiResponse<Student> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(studentService.create(student));
//        return apiResponse;
//    }
    @PostMapping
    public ResponseEntity<DfResponse<Student>> addOne(@RequestBody @Valid Student rq)
            throws ValidationException {
        return DfResponse.okEntity(studentService.create(rq));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/search")
//    public ResponseEntity<Page<Student>> searchByName(@RequestParam(defaultValue = "0") int page,
//                                                      @RequestParam(defaultValue = "5") int size,
//                                                      @Param("name") String name) {
//        Page<Student> students = studentService.searchByName(page, size, name);
//        return new ResponseEntity<>(students, HttpStatus.OK);
//    }
    @PostMapping("/search")
    public ResponseEntity<DfResponse<Page<Student>>> searchByName(@RequestBody SearchRequest request) {
        String name = request.getName();
        Page<Student> students = studentService.searchByName1(request.getPageable(), request.getName());
        return DfResponse.okEntity(students);
    }


    @GetMapping("/sortNameDesc")
    public ResponseEntity<List<Student>> sortByNameDesc() {
        List<Student> students = studentService.sortByNameDesc();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/sortNameAsc")
    public ResponseEntity<List<Student>> sortByNameAcs() {
        List<Student> students = studentService.sortByNameAcs();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/sortAgeDesc")
    public ResponseEntity<List<Student>> sortByAgeDesc() {
        List<Student> students = studentService.sortByAgeDesc();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/sortAgeAsc")
    public ResponseEntity<List<Student>> sortByAgeAcs() {
        List<Student> students = studentService.sortByAgeAcs();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/findByCategory/{id}")
    public ResponseEntity<Page<Student>> findByCategory(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int size,
                                                        @PathVariable Long id) {
        Page<Student> students = studentService.findByClass(page, size, id);
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

}
