package pl.edu.ug.tent.springmvcdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class IdMismatchException extends RuntimeException {

    public IdMismatchException(String message, Throwable cause){
        super(message, cause);
    }

    public IdMismatchException(){
        super();
    }
}