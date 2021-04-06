package ro.fasttrackit.curs6.students.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs6.students.entity.Student;
import ro.fasttrackit.curs6.students.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Optional<Student> getStudent(long studentId) {
        return repository.findById(studentId);
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }
}
