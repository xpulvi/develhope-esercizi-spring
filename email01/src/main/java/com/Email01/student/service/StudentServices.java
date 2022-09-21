package com.Email01.student.service;

import com.Email01.student.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    static List<Student> studentsList = Arrays.asList(
            new Student("1", "Lorenzo", "DE ho", "lory199@gmail.co"),
            new Student("2", "Mario", "rossi", "xpulvi42@gmail.com"),
            new Student("3", "giulio", "verdi", "lory199@gmail.com"),
            new Student("4", "Giovanna", "Giallo", "giovanna@develhope.co")
    );

    public Student getStudentById(String studentId) {
        Optional<Student> studentFromDb = studentsList.stream().filter(student -> student.getId().equals(studentId)).findAny();
        if (studentFromDb.isPresent()) return studentFromDb.get();
        return null;
    }

}
