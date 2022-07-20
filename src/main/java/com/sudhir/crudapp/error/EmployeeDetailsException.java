package com.sudhir.crudapp.error;

public class EmployeeDetailsException extends RuntimeException{

    public EmployeeDetailsException(String message){
        super(message);
    }

    public EmployeeDetailsException(String message, Throwable cause){
        super(message,cause);
    }

    public EmployeeDetailsException(Throwable cause){
        super(cause);
    }


}
