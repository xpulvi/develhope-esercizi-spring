package co.develhope.Redis.entities.redis;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@RedisHash(value = "utente", timeToLive = 3600)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRedis implements Serializable {

    @Id
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
