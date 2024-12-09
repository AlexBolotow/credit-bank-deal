package com.bolotov.creditbankdeal.controller.advice;

import com.bolotov.creditbankdeal.exception.ClientNotFoundException;
import com.bolotov.creditbankdeal.exception.PassportException;
import com.bolotov.creditbankdeal.exception.StatementNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ProblemDetail> handleValidationExceptions(BindException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setProperty("message", "Validation failed");
        problemDetail.setProperty("errors",
                e.getAllErrors().stream()
                        .map(ObjectError::getDefaultMessage)
                        .toList());

        return ResponseEntity.badRequest()
                .body(problemDetail);
    }

    @ExceptionHandler(PassportException.class)
    public ResponseEntity<ProblemDetail> handlePassportException(PassportException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setProperty("message", e.getMessage());

        return ResponseEntity.status(409)
                .body(problemDetail);
    }

    @ExceptionHandler({StatementNotFoundException.class, ClientNotFoundException.class})
    public ResponseEntity<ProblemDetail> handleStatementNotFoundException(Exception e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setProperty("message", e.getMessage());

        return ResponseEntity.notFound()
                .build();
    }


}
