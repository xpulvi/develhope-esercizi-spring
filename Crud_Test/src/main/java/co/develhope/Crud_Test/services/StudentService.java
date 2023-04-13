package co.develhope.Crud_Test.services;

import co.develhope.Crud_Test.entities.Student;
//import co.develhope.Crud_Test.exceptions.ConflictException;
import co.develhope.Crud_Test.exceptions.NoContentException;

import co.develhope.Crud_Test.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createNewStudent(Student student) {
        if (student == null) return null;

        //prevents override
        student.setId(0L);

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoContentException("No student found with id []"));
    }

    public Student updateStudentId(long newId, Student studentFromRequest) {
        Student studentFromDatabase = studentRepository.findById(studentFromRequest.getId())
                .orElseThrow(() -> new NoContentException("This student have no matches."));

        if (studentRepository.existsById(newId))
            throw new ConflictException("A student with this id already exist");

        if (!studentFromRequest.equals(studentFromDatabase))
            throw new NoContentException("the student in the request doesn't matches the persisted user");

        return studentRepository.save(studentFromDatabase.setId(newId));
    }

    public Student updateStudentWorkingStatus(long id, boolean working) {
        Student student = this.getStudentById(id);
        if (student.isWorking() == working)
            return student;
        else
            return studentRepository.save(
                    student.toggleWorkingStatus()
            );
    }

    public void deleteStudent(long id) {
        if (!studentRepository.existsById(id))
            throw new NoContentException("This student id have no matches.");

        studentRepository.deleteById(id);
    }
}
