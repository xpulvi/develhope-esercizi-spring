package develhope_exercises.Api02.dto;

import lombok.Data;
import lombok.ToString;

//elimina questa classe prima di caricare l'esercizio
@Data
@ToString
public class UserDto {
    //DTO e un oggeto che rapresenta il bodi della richiesrta
    private String id;
    private String name;
    private String surname;


}
