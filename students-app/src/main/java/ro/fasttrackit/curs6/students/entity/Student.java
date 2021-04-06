package ro.fasttrackit.curs6.students.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
