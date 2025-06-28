package br.com.jstack.syst.acrn.registry.framework.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * 🔥 Erros de validação de payload JSON (RequestBody)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex,
		HttpHeaders headers,
		HttpStatusCode status,
		WebRequest request) {
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err ->
			errors.put(err.getField(), err.getDefaultMessage()));
		
		log.warn("[Validation Error] {} - Fields: {}", ex.getMessage(), errors);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(Map.of(
				"timestamp", Instant.now(),
				"status", HttpStatus.BAD_REQUEST.value(),
				"error", "Validation Error",
				"details", errors
			));
	}
	
	/**
	 * 🔥 Erro na leitura do corpo da requisição (ex.: JSON mal formatado)
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
		HttpMessageNotReadableException ex,
		HttpHeaders headers,
		HttpStatusCode status,
		WebRequest request) {
		
		log.error("[Malformed JSON] {}", ex.getMessage(), ex);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(Map.of(
				"timestamp", Instant.now(),
				"status", HttpStatus.BAD_REQUEST.value(),
				"error", "Malformed JSON request",
				"message", ex.getLocalizedMessage()
			));
	}
	
	/**
	 * 🔥 Erro de parâmetros na URL (path variables ou query params)
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
		MethodArgumentTypeMismatchException ex) {
		
		String message = String.format("Parameter '%s' should be of type '%s'",
			ex.getName(), ex.getRequiredType().getSimpleName());
		
		log.warn("[Parameter Type Mismatch] {}", message, ex);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(Map.of(
				"timestamp", Instant.now(),
				"status", HttpStatus.BAD_REQUEST.value(),
				"error", "Parameter Type Mismatch",
				"message", message
			));
	}
	
	/**
	 * 🔥 Validações @Valid no QueryParam, PathVariable, etc.
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
		log.warn("[Constraint Violation] {}", ex.getMessage(), ex);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(Map.of(
				"timestamp", Instant.now(),
				"status", HttpStatus.BAD_REQUEST.value(),
				"error", "Constraint Violation",
				"message", ex.getMessage()
			));
	}
	
	/**
	 * 🔥 Captura qualquer outra exceção não tratada
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllUncaughtException(Exception ex, WebRequest request) {
		log.error("[Unhandled Exception] {}", ex.getMessage(), ex);
		
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(Map.of(
				"timestamp", Instant.now(),
				"status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"error", "Internal Server Error",
				"message", ex.getMessage()
			));
	}
}