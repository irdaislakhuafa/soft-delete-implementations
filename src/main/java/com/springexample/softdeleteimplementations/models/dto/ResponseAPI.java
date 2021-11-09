package com.springexample.softdeleteimplementations.models.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPI {
    private HttpStatus status;
    private String messages;
    private Object data;
}
