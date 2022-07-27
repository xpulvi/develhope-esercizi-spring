package co.develhope.demoexercise.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity @NoArgsConstructor
@Table("todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private LocalDateTime creationDateTime;

    @NotNull
    @NotBlank
    private String message;

    @NotNull
    @NotBlank
    private Boolean isDone;

    public ToDo(String message){
        this.message = message;
        isDone = false;
        creationDateTime = LocalDateTime.ofInstant(
                System.currentTimeMillis(),
                Zon
        )
    }



}
