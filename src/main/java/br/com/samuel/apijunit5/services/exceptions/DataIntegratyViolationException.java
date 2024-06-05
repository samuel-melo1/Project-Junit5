package br.com.samuel.apijunit5.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {

    public DataIntegratyViolationException(String msg){
        super(msg);
    }
}
