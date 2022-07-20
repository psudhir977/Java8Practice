package com.sudhir.crudapp.error;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private Long timestamp;

    public EmployeeErrorResponse(int status, String message,Long timestamp){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }


}
