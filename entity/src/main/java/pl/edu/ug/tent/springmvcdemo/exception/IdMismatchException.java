package pl.edu.ug.tent.springmvcdemo.exception;

public class IdMismatchException extends RuntimeException {

    public IdMismatchException(String message, Throwable cause){
        super(message, cause);
    }

    public IdMismatchException(){
        super();
    }
}