package co.develhope.Crud_Test.exceptions.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ErrorDto {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private HttpStatus status;
    private String error;
    private String errorMessage;
    private String path;
}
