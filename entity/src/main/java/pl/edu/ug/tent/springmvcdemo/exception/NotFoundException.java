package pl.edu.ug.tent.springmvcdemo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public NotFoundException(){
        super();
    }
}
