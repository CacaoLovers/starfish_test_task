package ru.avito.ads.exception;

import org.springframework.http.HttpStatus;

public class DeletingRelatedEntityException extends GlobalServiceException{
    private static final String DELETING_RELATED_ENTITY_DEFAULT_MESSAGE = "Deleting a related entity. First delete the linked entities";
    private static final HttpStatus DELETING_RELATED_ENTITY_DEFAULT_CODE = HttpStatus.BAD_REQUEST;

    public DeletingRelatedEntityException() {
        super(DELETING_RELATED_ENTITY_DEFAULT_MESSAGE, DELETING_RELATED_ENTITY_DEFAULT_CODE);
    }

}
