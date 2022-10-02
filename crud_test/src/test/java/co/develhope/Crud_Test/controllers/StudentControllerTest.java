package co.develhope.Crud_Test.controllers;

import co.develhope.Crud_Test.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
//Resume DB status after each test
@Transactional
public class StudentControllerTest {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private StudentController controller;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void StudentControllerBeanCreation() {
        assertThat(controller).isNotNull();
    }

    @Test
    void createAUserTest() throws Exception {
        Student student = createStudent();

        String studentJson = mapper.writeValueAsString(student);

        ResultActions result = mockMvc.perform(
                post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson)
        );

        String body = result
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Student resultStudent = mapper.readValue(body, Student.class);

        assertThat(resultStudent).isNotNull();
    }

    @Test
    void getAllStudentsTest() throws Exception {
        ResultActions result = mockMvc.perform(get("/students"));

        String body = result
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Student> resultStudents = Arrays.asList(
                mapper.readValue(body, Student[].class)
        );

        //we expect that the response body is a list of student
        assertThat(resultStudents).isNotNull();
        //we expect that the list of student is not empty
        assertThat(resultStudents.size()).isNotZero();
    }

    @Test
    void getStudentById() throws Exception {
        //we expect bad request on /student/{not_long_value}
        ResultActions result = mockMvc.perform(get("/students/ciccio"));
        result.andDo(print()).andExpect(status().isBadRequest());

        //we expect no content on /student/{id_that_not_exist}
        result = mockMvc.perform(get("/students/50"));
        result.andDo(print()).andExpect(status().isNoContent());

        //we expect that we can get student with id 38
        result = mockMvc.perform(get("/students/38"));
        String body = result.andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Student resultStudent = mapper.readValue(body, Student.class);

        //we expect that student exists and all field are populated
        assertThat(resultStudent).isNotNull();
        assertThat(resultStudent.getId()).isEqualTo(38);
        assertThat(resultStudent.getName()).isNotNull();
        assertThat(resultStudent.getSurname()).isNotNull();
        assertThat(resultStudent.isWorking()).isNotNull();
    }

    @Test
    void updateStudentWorkingStatusTest() throws Exception {
        //from data-h2
        //INSERT INTO "PUBLIC"."STUDENT" VALUES
        //("ID", "IS_WORKING", "NAME", "SURNAME") VALUES
        //(22, FALSE, 'd6275191-b769-4693-bccb-d88dee2ed98e', '11fb0e3c-22a8-40db-887d-e97b3e010624'),

        //we expect badRequest on /student/{something_not_long}
        ResultActions result = mockMvc.perform(put("/students/ciccio"));
        result.andDo(print()).andExpect(status().isBadRequest());

        //we expect badRequest on /student/{long} without working query param
        result = mockMvc.perform(put("/students/2"));
        result.andDo(print()).andExpect(status().isBadRequest());

        //we expect no content on /student/{id_that_not_exist}?working=true
        result = mockMvc.perform(put("/students/800")
                .queryParam("working", "true"));
        result.andDo(print()).andExpect(status().isNoContent());

        //we expect no content on /student/{id_that_not_exist}?working=true
        result = mockMvc.perform(put("/students/22")
                .queryParam("working", "true"));
        String body = result
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Student resultStudent = mapper.readValue(body, Student.class);

        //we expect that student exists and all field are populated
        assertThat(resultStudent).isNotNull();
        assertThat(resultStudent.getId()).isEqualTo(22);
        assertThat(resultStudent.getName()).isNotNull();
        assertThat(resultStudent.getSurname()).isNotNull();
        assertThat(resultStudent.isWorking()).isTrue();
    }

    @Test
    void updateStudentIdTest() throws Exception {
        //from data-h2
        //INSERT INTO "PUBLIC"."STUDENT" VALUES
        //("ID", "IS_WORKING", "NAME", "SURNAME") VALUES
        //(22, FALSE, 'd6275191-b769-4693-bccb-d88dee2ed98e', '11fb0e3c-22a8-40db-887d-e97b3e010624'),
        ResultActions result = mockMvc.perform(put("/students/22/update-id"));
        result.andDo(print()).andExpect(status().isBadRequest());
        //we expect bad request on /student/{something_not_long}/update-id without payload
        result = mockMvc.perform(put("/students/zdfhah/update-id"));
        result.andDo(print()).andExpect(status().isBadRequest());

        //we expect bad request on /student/22/update-id wih wrong payload
        result = mockMvc.perform(put("/students/22/update-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "wrongPayload": 22,
                            "name": "d6275191-b769-4693-bccb-d88dee2ed98e",
                            "surname": "11fb0e3c-22a8-40db-887d-e97b3e010624",
                            "working": false
                        }
                        """));
        result.andDo(print()).andExpect(status().isBadRequest());

        //we expect no content on /student/{correct_id}/update-id and wrong payload
        result = mockMvc.perform(put("/students/60/update-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "id": 22,
                            "name": "wrong",
                            "surname": "student data",
                            "working": false
                        }
                        """));
        result.andDo(print()).andExpect(status().isNoContent());

        //we expect no content on /student/{id_not_exist} with payload
        result = mockMvc.perform(put("/students/60/update-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "id": 800,
                            "name": "d6275191-b769-4693-bccb-d88dee2ed98e",
                            "surname": "11fb0e3c-22a8-40db-887d-e97b3e010624",
                            "working": false
                        }
                        """));
        result.andDo(print()).andExpect(status().isNoContent());

        //we expect conflict on request with new id that already exist
        result = mockMvc.perform(put("/students/20/update-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "id": 22,
                            "name": "d6275191-b769-4693-bccb-d88dee2ed98e",
                            "surname": "11fb0e3c-22a8-40db-887d-e97b3e010624",
                            "working": false
                        }
                        """));
        result.andDo(print()).andExpect(status().isConflict());

        //Correct request
        result = mockMvc.perform(put("/students/60/update-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "id": 22,
                            "name": "d6275191-b769-4693-bccb-d88dee2ed98e",
                            "surname": "11fb0e3c-22a8-40db-887d-e97b3e010624",
                            "working": false
                        }
                        """));
        String body = result
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Student resultStudent = mapper.readValue(body, Student.class);

        assertThat(resultStudent).isNotNull();
        assertThat(resultStudent.getId()).isNotNull();
        assertThat(resultStudent.getName()).isNotNull();
        assertThat(resultStudent.getSurname()).isNotNull();
        assertThat(resultStudent.isWorking()).isNotNull();
    }

    @Test
    void deleteExistingStudentTest() throws Exception {
        ResultActions result = mockMvc.perform(delete("/students/ciccio"));
        result.andDo(print()).andExpect(status().isBadRequest());

        //we expect no content on /student/{id_that_not_exist}
        result = mockMvc.perform(delete("/students/800"));
        result.andDo(print()).andExpect(status().isNoContent());

        //we expepect ok status on correct request
        result = mockMvc.perform(delete("/students/38"));
        result.andDo(print())
                .andExpect(status().isOk());

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
