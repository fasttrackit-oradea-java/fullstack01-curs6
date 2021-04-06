package ro.fasttrackit.curs5.homework.countries.exceptions;

import lombok.Value;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

@RestControllerAdvice
public class CountryControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    ApiError handleResourceNotFoundException(ResourceNotFoundException rnfe) {
        return new ApiError(1001, rnfe.getMessage());
    }

    @ExceptionHandler({HeaderNotFoundException.class, MissingRequestHeaderException.class})
    @ResponseStatus(EXPECTATION_FAILED)
    ApiError handleHeaderNotFoundException(Exception hnfe) {
        return new ApiError(2003, hnfe.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleOtherException(Exception ex) {
        return new ApiError(0000, "Generic error " + ex.getMessage());
    }
}

@Value
class ApiError {
    int code;
    String message;
}
