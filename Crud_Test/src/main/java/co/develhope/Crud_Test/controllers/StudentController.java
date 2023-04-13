package co.develhope.Crud_Test.controllers;

import co.develhope.Crud_Test.entities.Student;
//import co.develhope.Crud_Test.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createNewStudent(@Valid @RequestBody Student student) {

        Student createdStudent = studentService.createNewStudent(student);

        return ResponseEntity
                .created(
                        URI.create(
                                ServletUriComponentsBuilder
                                        .fromCurrentContextPath()
                                        .path("students/" + createdStudent.getId())
                                        .toUriString()
                        )
                )
                .body(createdStudent);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentWorkingStatus(@PathVariable long id, @RequestParam(required = true) boolean working) {
        return studentService.updateStudentWorkingStatus(id, working);
    }

    @PutMapping("/{newId}/update-id")
    public ResponseEntity<Student> updateStudentId(@PathVariable Long newId, @Valid @RequestBody Student studentToModify) {
        Student editedStudent;

        if (Objects.equals(newId, studentToModify.getId()))
            editedStudent = studentToModify;
        else
            editedStudent = studentService.updateStudentId(newId, studentToModify);

        return ResponseEntity
                .created(
                        URI.create(
                                ServletUriComponentsBuilder
                                        .fromCurrentContextPath()
                                        .path("students/" + editedStudent.getId())
                                        .toUriString()
                        )
                )
                .body(editedStudent);
    }

    @DeleteMapping("{id}")
    public void deleteExistingStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
