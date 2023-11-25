package ru.avito.ads.exception;

import org.springframework.http.HttpStatus;

public class UnacceptableActionException extends GlobalServiceException{
    private static final String RESOURCE_NOT_FOUND_DEFAULT_MESSAGE = "Unacceptable action";
    private static final HttpStatus RESOURCE_NOT_FOUND_DEFAULT_CODE = HttpStatus.BAD_REQUEST;

    public UnacceptableActionException(){
        super(RESOURCE_NOT_FOUND_DEFAULT_MESSAGE, RESOURCE_NOT_FOUND_DEFAULT_CODE);
    }


}
