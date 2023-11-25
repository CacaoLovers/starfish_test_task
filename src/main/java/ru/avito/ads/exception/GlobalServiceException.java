package ru.avito.ads.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GlobalServiceException extends RuntimeException{

    private final static HttpStatus HTTP_DEFAULT_EXCEPTION_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
    private final static String HTTP_DEFAULT_EXCEPTION_MESSAGE= "Внутренняя ошибка сервера";

    private String message;
    private HttpStatus status;


    public GlobalServiceException(){
        this.message = HTTP_DEFAULT_EXCEPTION_MESSAGE;
        this.status = HTTP_DEFAULT_EXCEPTION_STATUS;
    }

    public GlobalServiceException(String message){
        this.message = message;
        this.status = HTTP_DEFAULT_EXCEPTION_STATUS;
    }

    public GlobalServiceException(String message, HttpStatus httpStatus){
        this.message = message;
        this.status = httpStatus;
    }
}
