package br.com.jardessouza.service.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExeceptionHandler {
    @ExceptionHandler(TecnicoNotFoundException.class)
    public ResponseEntity<StandardError> tecnicoNotFoundException(TecnicoNotFoundException ex,
                                                                  HttpServletRequest request){
        StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Tecnico não encontrado")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ClienteNotFound.class)
    public ResponseEntity<StandardError> clienteNotFoundException(ClienteNotFound ex,
                                                                  HttpServletRequest request){
        StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Cliente não encontrado")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> tecnicoNotFoundException(DataIntegrityViolationException ex,
                                                                  HttpServletRequest request){
        StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Violação de dados")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException ex,
                                                                  HttpServletRequest request){
        ValidationError errors = new ValidationError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                "Erro na validação dos campos",
                request.getRequestURI()
        );

        for(FieldError x: ex.getBindingResult().getFieldErrors()){
            errors.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
