package co.develhope.Redis.entities.jpa;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "utente")
@AllArgsConstructor
@NoArgsConstructor
public class UserJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String profilePicture;
    @NotNull
    private String email;
    private String passwordEncrypted;
    private String domicileAddress;
    private String domicileCity;
    private String domicileNumber;
    private String domicileState;
    private String fiscalCode;
}
