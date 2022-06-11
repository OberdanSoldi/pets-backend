package br.com.adopt.petsbackend.exception;

import br.com.adopt.petsbackend.domain.dto.ErrorResponseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MESSAGE = "Houveram erros de validação";

    private final SnakeCaseStrategy snakeCaseStrategy = new SnakeCaseStrategy();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var body = ErrorResponseDto.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .cause(exception.getClass().getSimpleName())
                .message(MESSAGE)
                .timestamp(LocalDateTime.now())
                .errors(convertFieldErrors(exception.getBindingResult().getFieldErrors()))
                .build();
        exception.getBindingResult().getFieldErrors();
        return new ResponseEntity<>(body, status);
    }

    private Map<String, List<String>> convertFieldErrors(List<FieldError> fieldErrors) {
        var errors = new HashMap<String, List<String>>();
        fieldErrors.forEach(fieldError -> {
            var field = snakeCaseStrategy.translate(fieldError.getField());
            if (errors.containsKey(field)) {
                errors.get(field).add(fieldError.getDefaultMessage());
            } else {
                errors.put(
                        field,
                        Stream.of(fieldError.getDefaultMessage()).collect(Collectors.toList())
                );
            }
        });
        return errors;
    }
}
