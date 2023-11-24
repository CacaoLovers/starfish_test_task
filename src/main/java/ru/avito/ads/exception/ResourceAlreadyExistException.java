package ru.avito.ads.exception;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistException extends GlobalServiceException{
    private static final String RESOURCE_ALREADY_EXIST_DEFAULT_MESSAGE = "Resource already exist";
    private static final HttpStatus RESOURCE_ALREADY_EXIST_DEFAULT_CODE = HttpStatus.BAD_REQUEST;

    public ResourceAlreadyExistException() {
        super(RESOURCE_ALREADY_EXIST_DEFAULT_MESSAGE, RESOURCE_ALREADY_EXIST_DEFAULT_CODE);
    }

    public ResourceAlreadyExistException(String id) {
        super("Resource with identification " + id + " already exist", RESOURCE_ALREADY_EXIST_DEFAULT_CODE);
    }

    public ResourceAlreadyExistException(String id, Class<?> clazz) {
        super(clazz.getSimpleName() + " with identification " + id + " already exist", RESOURCE_ALREADY_EXIST_DEFAULT_CODE);
    }
}
