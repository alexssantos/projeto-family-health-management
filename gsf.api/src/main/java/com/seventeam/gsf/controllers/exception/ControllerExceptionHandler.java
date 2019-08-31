package com.seventeam.gsf.controllers.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler
{

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<StandardError> objectNotFound(ChangeSetPersister.NotFoundException e, HttpServletRequest request)
    {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Não Encontrado",
                e.getMessage(),
                request.getRequestURI()
        );

        return  ResponseEntity.status(status).body(error);
    }
}
