package com.example.springDataDemo.controllers.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public abstract class BaseExceptionHandler {
	private static final ExceptionMapping DEFAULT_ERROR = new ExceptionMapping("SERVER_ERROR", "Internal Server Error",
			HttpStatus.INTERNAL_SERVER_ERROR);

	private final Logger log;

	private final Map<Class<?>, ExceptionMapping> exceptionMappings = new HashMap<>();

	public BaseExceptionHandler(final Logger log) {
		super();
		this.log = log;
		registerMapping(MissingServletRequestParameterException.class, "MISSING_PARAMETER", "Missing request parameter",
				HttpStatus.BAD_REQUEST);
		registerMapping(MethodArgumentTypeMismatchException.class, "ARGUMENT_TYPEMISMATCH", "Argument type mismatch",
				HttpStatus.BAD_REQUEST);
		registerMapping(HttpRequestMethodNotSupportedException.class, "METHOD_NOT_SUPPORTED",
				"Http method not supported", HttpStatus.METHOD_NOT_ALLOWED);
		registerMapping(ServletRequestBindingException.class, "MISSING_HEADER", "Missing header in request",
				HttpStatus.BAD_REQUEST);

	}

	protected ErrorResponse construct(ExceptionMapping mapping) {
		return new ErrorResponse(mapping.message, mapping.code);
	}

	protected ErrorResponse logAndConstruct(ExceptionMapping mapping, Throwable t) {
		log.error("{} ({}): {}", mapping.message, mapping.code, t.getMessage());
		return construct(mapping);
	}

	protected void registerMapping(final Class<?> clazz, final String code, final String message,
			final HttpStatus status) {
		exceptionMappings.put(clazz, new ExceptionMapping(message, code, status));
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ErrorResponse handleThrowable(final Throwable ex, final HttpServletResponse response) {
		ExceptionMapping mapping = exceptionMappings.getOrDefault(ex.getClass(), DEFAULT_ERROR);
		response.setStatus(mapping.status.value());
		return logAndConstruct(mapping, ex);
	}

	public static class ErrorResponse {
		private final String message;
		private final String code;

		public ErrorResponse(String message, String code) {
			super();
			this.message = message;
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public String getCode() {
			return code;
		}

	}

	private static class ExceptionMapping {
		private final String message;
		private final String code;
		private final HttpStatus status;

		public ExceptionMapping(String message, String code, HttpStatus status) {
			super();
			this.message = message;
			this.code = code;
			this.status = status;
		}

	}

}