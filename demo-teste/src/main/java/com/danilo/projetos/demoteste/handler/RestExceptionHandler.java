package com.danilo.projetos.demoteste.handler;

import com.danilo.projetos.demoteste.model.error.ErrorMessage;
import com.danilo.projetos.demoteste.model.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Manipulador de exceções Rest
 *
 * @ControllerAdvice indica para o Spring que esse cara é um controlador na aplicacao
 */
@ControllerAdvice
public class RestExceptionHandler {
    /**
     * Escuta a api para quando acontecer uma exception desse tipo
     *
     * @param exception tipo de exception que será manipulada
     * @return qualquer objeto
     */
    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {

        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        ErrorMessage error = new ErrorMessage("Erro de conversão", HttpStatus.PRECONDITION_FAILED.value(),
                "Error ao ler valor passado: "+ exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.PRECONDITION_FAILED);
    }
}
