package co.develhope.Crud_Test.exceptions.handler;

import co.develhope.Crud_Test.exceptions.ConflictException;
import co.develhope.Crud_Test.exceptions.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ConflictExceptionHandler {
    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<ErrorDto> confirmationJustExpiredExceptionHandler(
            ConflictException e,
            HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorDto()
                        .setError("Conflict Exception")
                        .setErrorMessage(e.getMessage())
                        .setStatus(HttpStatus.CONFLICT)
                        .setPath(
                                request.getRequestURI()
                                        .substring(
                                                request.getContextPath().length())),
                HttpStatus.CONFLICT
        );
    }
}
