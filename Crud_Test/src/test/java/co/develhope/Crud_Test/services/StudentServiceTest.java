package co.develhope.Crud_Test.services;

import co.develhope.Crud_Test.entities.Student;
import co.develhope.Crud_Test.exceptions.ConflictException;
import co.develhope.Crud_Test.exceptions.NoContentException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
//Resume DB status after each test
@Transactional
public class StudentServiceTest {
    @Autowired
    private StudentService service;

    @Test
    void StudentServiceBeanCreation() {
        assertThat(service).isNotNull();
    }

    @Test
    void createAStudentTest() {
        Student student = createStudent();

        Student resultStudent = service.createNewStudent(student);

        assertThat(resultStudent.getId()).isNotEqualTo(0L);

        assertThat(student.getName()).isEqualTo(resultStudent.getName());
        assertThat(student.getSurname()).isEqualTo(resultStudent.getSurname());
        assertThat(student.isWorking()).isEqualTo(resultStudent.isWorking());
    }

    @Test
    void getAllStudentsTest() {
        List<Student> allStudents = service.getAllStudents();

        //we expect to have a list of student
        assertThat(allStudents).isNotNull();
        //we expect the list size equals 44 (from the data-h2.sql)
        assertThat(allStudents.size()).isEqualTo(44);
    }

    @Test
    void getStudentsByIdTest() {
        Student student = service.getStudentById(22);

        //from data-h2
        //INSERT INTO "PUBLIC"."STUDENT" VALUES
        //("ID", "IS_WORKING", "NAME", "SURNAME") VALUES
        //(22, FALSE, 'd6275191-b769-4693-bccb-d88dee2ed98e', '11fb0e3c-22a8-40db-887d-e97b3e010624'),

        assertThat(student).isNotNull();
        assertThat(student.getId()).isEqualTo(22);
        assertThat(student.isWorking()).isEqualTo(false);
        assertThat(student.getName()).isEqualTo("d6275191-b769-4693-bccb-d88dee2ed98e");
        assertThat(student.getSurname()).isEqualTo("11fb0e3c-22a8-40db-887d-e97b3e010624");
    }

    @Test
    void updateStudentIdTest() {
        //from data-h2
        //INSERT INTO "PUBLIC"."STUDENT" VALUES
        //("ID", "IS_WORKING", "NAME", "SURNAME") VALUES
        //(22, FALSE, 'd6275191-b769-4693-bccb-d88dee2ed98e', '11fb0e3c-22a8-40db-887d-e97b3e010624');

        //Valid new Id
        final long validNewId = 80L;
        //Not Valid new Id
        final long notValidNewId = 3L;

        final long oldId = 22L;
        Student validStudent = service.getStudentById(oldId).clone();
        Student wrongStudent = validStudent.clone().setName("wrong name");

        //check about conflict on new id
        assertThatThrownBy(
                () -> service.updateStudentId(notValidNewId, validStudent)
        ).isInstanceOf(ConflictException.class);

        //check about no valid Student data
        assertThatThrownBy(
                () -> service.updateStudentId(validNewId, wrongStudent)
        ).isInstanceOf(NoContentException.class);

        //check if service work with valid data
        Student resultStudent = service.updateStudentId(validNewId, validStudent);

        assertThat(resultStudent).isNotNull();
        assertThat(resultStudent.getId()).isNotEqualTo(notValidNewId);
        assertThat(validStudent.getName()).isEqualTo(resultStudent.getName());
        assertThat(validStudent.getSurname()).isEqualTo(resultStudent.getSurname());
        assertThat(validStudent.isWorking()).isEqualTo(resultStudent.isWorking());
    }

    @Test
    void updateStudentWorkingStatus() {
        //from data-h2
        //INSERT INTO "PUBLIC"."STUDENT" VALUES
        //("ID", "IS_WORKING", "NAME", "SURNAME") VALUES
        //(15, FALSE, '0dd6cfdd-ecfb-4794-99b6-658caa544fc0', 'a6041987-031f-4149-bb9a-298fed0347de');
        final long id = 15L;
        final Student studentBeforeTest = service.getStudentById(id).clone();

        final boolean sameStatusFromOrigin = false;
        Student StudentAfterTest = service.updateStudentWorkingStatus(id, sameStatusFromOrigin);
        //we expect that isWorking status is not changed
        assertThat(StudentAfterTest.isWorking()).isEqualTo(sameStatusFromOrigin);
        assertThat(StudentAfterTest.isWorking()).isEqualTo(studentBeforeTest.isWorking());

        final boolean differentStatusFromOrigin = true;
        StudentAfterTest = service.updateStudentWorkingStatus(id, differentStatusFromOrigin);
        //we expect that isWorking status is changed
        assertThat(StudentAfterTest.isWorking()).isEqualTo(differentStatusFromOrigin);
        assertThat(StudentAfterTest.isWorking()).isNotEqualTo(studentBeforeTest.isWorking());
    }

    @Test
    void deleteStudentStatus() {
        //from data-h2
        //INSERT INTO "PUBLIC"."STUDENT" VALUES
        //("ID", "IS_WORKING", "NAME", "SURNAME") VALUES
        //(27, FALSE, '897c8f11-7c46-4008-b993-5ff6929d536c', '5000039a-7fc8-4509-bf27-533ffaf053d0');

        final long idThatNotExists = 80L;
        //we expect that student with idThatNotExists does not exist
        assertThatThrownBy(
                () -> service.deleteStudent(idThatNotExists)
        ).isInstanceOf(NoContentException.class);

        final long idThatExist = 27L;
        service.deleteStudent(idThatExist);
        //we expect that student with idThatExist exists
        assertThatThrownBy(
                () -> service.getStudentById(idThatExist)
        ).isInstanceOf(NoContentException.class);
    }

    private Student createStudent() {
        Random random = new Random();
        return new Student(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                random.nextBoolean()
        );
    }
}
