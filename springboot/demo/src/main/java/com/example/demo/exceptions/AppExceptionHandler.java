package com.example.demo.exceptions;

import com.example.demo.models.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
        return getObjectResponseEntity(ex);

    }

    @ExceptionHandler(value ={ NullPointerException.class,UserServiceException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest request){
        return getObjectResponseEntity(ex);

    }




    private ResponseEntity<Object> getObjectResponseEntity(Exception ex) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(errorMessageDescription);
        errorMessage.setTimestamp(new java.util.Date());

        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
