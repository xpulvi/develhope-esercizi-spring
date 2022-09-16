package com.crud_test.services;

import com.crud_test.entiti.Student;
import com.crud_test.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServices {
    private final StudentRepository studentRepository;

    public Student createNewStudent(Student student){
        if (student == null) return  null;

        //prevents overried
        student.setId(0L);
        return studentRepository.save(student);
    }


}
