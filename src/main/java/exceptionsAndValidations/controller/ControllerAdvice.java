package exceptionsAndValidations.controller;

import exceptionsAndValidations.dto.ErrorDTO;
import exceptionsAndValidations.exceptions.BusinessException;
import exceptionsAndValidations.exceptions.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value =  RuntimeException.class)
    public ResponseEntity <ErrorDTO> runtimeExceptionHandler (RuntimeException ex){
        //Vamos a instanciar el objeto que vamos a retornar
        ErrorDTO error = ErrorDTO.builder().code("P-500"/*Diccionario de errores*/).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //Implementando la excepción que yo cree
    @ExceptionHandler(value =  RequestException.class)
    public ResponseEntity <ErrorDTO> requestExceptionHandler (RequestException ex){
        //Vamos a instanciar el objeto que vamos a retornar
        ErrorDTO error = ErrorDTO.builder().code(ex.getCode()/*Aqui se reemplaza por el atributo que hay en la excpeción que cree*/).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value =  BusinessException.class)
    public ResponseEntity <ErrorDTO> businesstExceptionHandler (BusinessException ex){
        //Vamos a instanciar el objeto que vamos a retornar
        ErrorDTO error = ErrorDTO.builder().code(ex.getCode()/*Aqui se reemplaza por el atributo que hay en la excpeción que cree*/).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
