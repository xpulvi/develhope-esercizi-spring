package com.Email01.api.controller;

import com.Email01.api.entitis.NotificationDto;
import com.Email01.email.service.EmailServices;
import com.Email01.student.Student;
import com.Email01.student.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/notificatioon")
public class NotificationController {

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private EmailServices emailServices;

    @PostMapping("/student")
    public ResponseEntity sendNotification(@RequestBody @Valid NotificationDto payload){
        try {
            //prendiamo lutente dal data base
            Student studentToSendNotification = studentServices.getStudentById(payload.getUserId());
            System.out.println("Getting the student: " + studentToSendNotification);
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("I couldn't find the student :(");
            }
            //invio del mail
            emailServices.sendTo(studentToSendNotification.getEmail(), payload.getTitle(), payload.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            System.err.println("Error in notification controller: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
