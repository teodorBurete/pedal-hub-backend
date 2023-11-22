package org.pedalhub.pedalhubbackend.exceptions.handling;

import org.pedalhub.pedalhubbackend.exceptions.IllegalSearchCriteriaException;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class, IllegalSearchCriteriaException.class, ResourceNotFoundException.class})
    public final ResponseEntity<Object> handleException(
            Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof MethodArgumentNotValidException) {
            return handleMethodArgumentNotValid(
                    (MethodArgumentNotValidException) ex, headers,
                    HttpStatus.BAD_REQUEST, request);
        }

        if (ex instanceof IllegalSearchCriteriaException) {
            return handleIllegalSearchCriteria(
                    (IllegalSearchCriteriaException) ex, headers,
                    HttpStatus.BAD_REQUEST, request);
        }

        if (ex instanceof ResourceNotFoundException) {
            return handleResourceNotFoundException((ResourceNotFoundException) ex, headers, HttpStatus.NOT_FOUND, request);
        }
        return null;

    }

    private ResponseEntity<Object> handleIllegalSearchCriteria(IllegalSearchCriteriaException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {

        Map<String, Object> response = new HashMap<>();
        response.put("isSuccess", false);
        response.put("data", null);
        response.put("status", status);
        response.put("message", ex.getMessage());
        response.put("searchCriteria", ex.getSearchCriteria());
        return new ResponseEntity<>(response, status);
    }

    private ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                   HttpHeaders headers,
                                                                   HttpStatus status,
                                                                   WebRequest request) {

        Map<String, Object> response = new HashMap<>();
        response.put("isSuccess", false);
        response.put("data", null);
        response.put("status", status);
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, status);
    }

    private ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        Map<String, Object> fieldError = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors();
        fieldErrors.stream().forEach(error -> fieldError.put(
                error.getField(), error.getDefaultMessage()));
        Map<String, Object> response = new HashMap<>();
        response.put("isSuccess", false);
        response.put("data", null);
        response.put("status", status);
        response.put("fieldError", fieldError);
        return new ResponseEntity<>(response, status);
    }
}