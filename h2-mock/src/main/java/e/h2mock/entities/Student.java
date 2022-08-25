package e.h2mock.entities;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "studenti")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String firstName;


    private String lastName;

    @Column(unique = true)
    private String email;

}


