package ru.reksoft.interns.carstore.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.reksoft.interns.carstore.dto.FieldDto;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(NotValidException.class)
    public Error methodArgumentNotValidException(NotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private Error processFieldErrors(List<FieldError> fieldErrors) {
        Error error = new Error(BAD_REQUEST.value(), "validation error","name");
        for (FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }

    static class Error {
        private final String name;
        private final int status;
        private final String message;
        private List<FieldDto> fieldErrors = new ArrayList<>();

        Error(int status, String message,String name) {
            this.status = status;
            this.message = message;
            this.name=name;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public void addFieldError(String path, String message) {
            FieldDto error = new FieldDto(path,message);
            fieldErrors.add(error);
        }

        public List<FieldDto> getFieldErrors() {
            return fieldErrors;
        }
    }
}