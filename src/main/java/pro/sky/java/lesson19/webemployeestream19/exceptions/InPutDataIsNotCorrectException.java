package pro.sky.java.lesson19.webemployeestream19.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InPutDataIsNotCorrectException extends RuntimeException {

    public InPutDataIsNotCorrectException() {

    }

    public InPutDataIsNotCorrectException(String message) {
        super(message);
    }

    public InPutDataIsNotCorrectException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
