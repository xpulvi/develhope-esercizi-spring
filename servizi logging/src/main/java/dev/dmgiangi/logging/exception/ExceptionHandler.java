package dev.dmgiangi.logging.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> lorenzoDeFrancescoExceptionHandler(
            Exception e,
            HttpServletRequest request) {

        log.error("Oh no, Lorenzo!!!", e);

        return ResponseEntity
                .internalServerError()
                .body(
                        new ErrorDto()
                                .setError("Potevamo farlo meglio?")
                                .setErrorMessage(e.getMessage())
                                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                                .setPath(
                                        request.getRequestURI()
                                                .substring(
                                                        request.getContextPath().length()))
                );
    }
}
