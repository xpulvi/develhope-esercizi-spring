package co.develhope.Crud_Test.exceptions;

public class NoContentException extends RuntimeException {
    public NoContentException(String message) {
        super(message);
    }

    public NoContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
