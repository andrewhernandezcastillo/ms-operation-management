package com.demo.ms.infraestructure.adapter.input;

import com.demo.ms.dominio.exception.DoesNotExistCardException;
import com.demo.ms.dominio.exception.DoesNotExistTypeOperationException;
import com.demo.ms.dominio.exception.InsufficientFundsException;
import com.demo.ms.infraestructure.adapter.input.model.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(value= DoesNotExistCardException.class)
    public ResponseEntity<ErrorInfo> doesnotexistcardException(DoesNotExistCardException ex){
        ErrorInfo error = ErrorInfo.builder().code(ex.getCode()).description(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value= InsufficientFundsException.class)
    public ResponseEntity<ErrorInfo> insufficientFundsException(InsufficientFundsException ex){
        ErrorInfo error = ErrorInfo.builder().code(ex.getCode()).description(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value= DoesNotExistTypeOperationException.class)
    public ResponseEntity<ErrorInfo> doesNotExistTypeOperationException(DoesNotExistTypeOperationException ex){
        ErrorInfo error = ErrorInfo.builder().code(ex.getCode()).description(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
