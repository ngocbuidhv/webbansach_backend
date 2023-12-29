package ngoc.webbansach_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomSachEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SachException.class)
    public final ResponseEntity<Object> handleCategoryException(SachException ex, WebRequest request){
        SachExceptionResponse exceptionResponse = new SachExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
