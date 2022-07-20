package com.sudhir.crudapp.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
    Controller advice is used to apply exception handling technique across the application.
    This annotation can be used on top of the class; then the class will act as controller advice.
    It is something similar to Interceptor or filter.
    It pre process the request to the controller and post process the response to handle exceptions

 */

@ControllerAdvice
public class EmployeeExceptionHandler {


    @ExceptionHandler
    /*@Exception handler annotation going to return response entity   */
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeDetailsException enf){
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setMessage(enf.getMessage());
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setMessage(exc.getMessage());
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
