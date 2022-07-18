package br.com.dbc.vemser.pessoaapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class RegraDeNegocioException extends Exception{

    public RegraDeNegocioException(String message) {
        super(message);
    }
}
