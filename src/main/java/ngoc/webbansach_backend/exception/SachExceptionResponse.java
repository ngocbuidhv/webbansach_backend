package ngoc.webbansach_backend.exception;

import lombok.Data;

@Data
public class SachExceptionResponse {
    private String message;

    public SachExceptionResponse(String message) {
        this.message = message;
    }
}
