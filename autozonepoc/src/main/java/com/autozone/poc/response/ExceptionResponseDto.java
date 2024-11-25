package com.autozone.poc.response;


import lombok.Data;

@Data
public class ExceptionResponseDto {



    int statusCode;
    String statusDescription;
    String  cause;
}
