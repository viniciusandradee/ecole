package br.com.fiap.exception;

public class MetodoNaoImplementadoException extends RuntimeException{
    public MetodoNaoImplementadoException(String message) {
        super(message);
    }
}
