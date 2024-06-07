package br.com.samuel.apijunit5.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timesstamp;
    private Integer status;
    private String error;
    private String path;


}
