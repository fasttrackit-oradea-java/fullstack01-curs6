package ro.fasttrackit.curs6.students.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs6.students.entity.Student;
import ro.fasttrackit.curs6.students.exceptions.ResourceNotFoundException;
import ro.fasttrackit.curs6.students.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    List<Student> getStudents() {
        return service.getAll();
    }

    @GetMapping("{studentId}")
    Student getStudent(@PathVariable int studentId) {
        return service.getStudent(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find student with id " + studentId));
    }

    @PostMapping
    Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }
}
