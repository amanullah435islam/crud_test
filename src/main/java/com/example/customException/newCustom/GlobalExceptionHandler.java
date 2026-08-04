package com.example.customException.newCustom;


import com.example.config.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyExists(
            ResourceAlreadyExistsException ex,
            HttpServletRequest request
    ){

        ErrorResponseDTO response =
                new ErrorResponseDTO(
                        LocalDateTime.now(),
                        400,
                        "BAD_REQUEST",
                        ex.getMessage(),
                        request.getRequestURI()
                );


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(
            Exception ex,
            HttpServletRequest request
    ){

        ErrorResponseDTO response =
                new ErrorResponseDTO(
                        LocalDateTime.now(),
                        500,
                        "INTERNAL_SERVER_ERROR",
                        ex.getMessage(),
                        request.getRequestURI()
                );


        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

}
