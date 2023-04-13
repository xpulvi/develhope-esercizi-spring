package co.develhope.Crud_Test.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@Entity
public class Student {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private boolean isWorking;

    public Student(String name, String surname, boolean isWorking) {
        this.id = 0L;
        this.name = name;
        this.surname = surname;
        this.isWorking = isWorking;
    }

    public Student toggleWorkingStatus() {
        this.isWorking = !this.isWorking;
        return this;
    }

    public Student clone(){
        return new Student().setName(this.name)
                .setSurname(this.surname)
                .setWorking(this.isWorking)
                .setId(this.id);
    }
}
