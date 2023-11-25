package ru.avito.ads.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends GlobalServiceException{
    private static final String RESOURCE_NOT_FOUND_DEFAULT_MESSAGE = "Resource not found";
    private static final HttpStatus RESOURCE_NOT_FOUND_DEFAULT_CODE = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException(){
        super(RESOURCE_NOT_FOUND_DEFAULT_MESSAGE, RESOURCE_NOT_FOUND_DEFAULT_CODE);
    }
    public ResourceNotFoundException(String id){
        super("Resource with id " + id + " not found", RESOURCE_NOT_FOUND_DEFAULT_CODE);
    }

    public ResourceNotFoundException(String id, Class<?> clazz){
        super(clazz.getSimpleName() + " with id " + id + " not found", RESOURCE_NOT_FOUND_DEFAULT_CODE);
    }
}
