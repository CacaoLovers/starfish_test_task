package ru.avito.ads.controller.handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.avito.ads.controller.exception.ExceptionMessage;
import ru.avito.ads.exception.GlobalServiceException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HttpControllerHandler {

    @ExceptionHandler(GlobalServiceException.class)
    public ResponseEntity<ExceptionMessage> httpControllerHandle(GlobalServiceException exception){
        return ResponseEntity.status(exception.getStatus())
                .body(ExceptionMessage.builder()
                        .code(exception.getStatus().value())
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionMessage> handleValidationExceptions(ConstraintViolationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionMessage.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(exception.getMessage())
                        .build());
    }

}
