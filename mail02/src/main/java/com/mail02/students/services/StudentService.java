package com.mail02.students.services;


import com.mail02.students.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "John", "Walker", "john@walker.com"),
            new Student("2", "Walter", "White", "walter@white.com"),
            new Student("3", "Samuel", "Dungeon", "samuel@dangeon.com"),
            new Student("4", "Ursula", "Von Der Leyen", "joyibef827@ploneix.com")
            );

    public Student getStudentById(String studentId) {
        Optional<Student> studentFromList = students.stream().filter(student -> student.getId().equals(studentId)).findAny();
        return studentFromList.isPresent() ? studentFromList.get() : null;
    }
}
