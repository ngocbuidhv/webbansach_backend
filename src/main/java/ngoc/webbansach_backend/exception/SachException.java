package ngoc.webbansach_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SachException extends RuntimeException{
    public SachException(String message) {
        super(message);
    }
}
