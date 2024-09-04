package com.demo.ms.dominio.exception;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class DoesNotExistCardException extends RuntimeException{
    private String code;
    private HttpStatus status;

    public DoesNotExistCardException(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status= status;

    }
}
