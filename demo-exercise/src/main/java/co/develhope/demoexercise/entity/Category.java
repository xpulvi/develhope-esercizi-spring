package co.develhope.demoexercise.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity =  ToDo.class)
    private Set<ToDo> todos;

}
