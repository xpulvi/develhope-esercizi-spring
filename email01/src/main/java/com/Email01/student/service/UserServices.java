package com.Email01.student.service;

import com.Email01.student.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServices {

    static List<Student> users = Arrays.asList(
            new Student("1", "Lorenzo", "DE ho", "lory1990@gmail.com"),
            new Student("2", "Mario", "rossi", "jon@gmail.com"),
            new Student("3", "giulio", "verdi", "lory199@gmail.com"),
            new Student("4", "Giovanna", "Giallo", "giovanna@develhope.co")
    );

}
