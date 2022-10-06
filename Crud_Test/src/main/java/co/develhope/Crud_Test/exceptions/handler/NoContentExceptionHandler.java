package co.develhope.Crud_Test.exceptions.handler;

import co.develhope.Crud_Test.exceptions.NoContentException;
import co.develhope.Crud_Test.exceptions.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class NoContentExceptionHandler {
    @ExceptionHandler({NoContentException.class})
    public ResponseEntity<ErrorDto> confirmationJustExpiredExceptionHandler(
            NoContentException e,
            HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorDto()
                        .setError("No Content Found")
                        .setErrorMessage(e.getMessage())
                        .setStatus(HttpStatus.NO_CONTENT)
                        .setPath(
                                request.getRequestURI()
                                        .substring(
                                                request.getContextPath().length())),
                HttpStatus.NO_CONTENT
        );
    }
}
