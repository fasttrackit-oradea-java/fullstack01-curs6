package ro.fasttrackit.curs6.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs6.students.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
