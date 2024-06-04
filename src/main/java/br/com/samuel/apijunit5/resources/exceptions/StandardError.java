package br.com.samuel.apijunit5.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timesstamp;
    private Integer status;
    private String error;
    private String path;


}
