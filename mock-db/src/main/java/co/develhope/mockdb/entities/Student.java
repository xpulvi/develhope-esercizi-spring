package co.develhope.mockdb.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "studenti")
@Data
public class Student {
//@ Pasquale non ho capito come eseguire il test con h2
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private String firstName;
    private String lastName;

    @Column
    private String email;

}