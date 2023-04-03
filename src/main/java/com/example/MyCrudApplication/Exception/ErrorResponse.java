package com.example.MyCrudApplication.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
 
    private int statusCode;
    private String message;
 
    public ErrorResponse(int i, String message)
    {
        super();
        this.message = message;
    }
}
	
