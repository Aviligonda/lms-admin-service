package com.bridgelabz.lmsadminservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseClass {
    private int errorCode;
    private String message;
    private Object token;
}
