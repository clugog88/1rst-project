package com.app.errors.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.auth.controllers.models.GenericResponse;
import com.app.errors.constants.ErrorMessages;
import com.app.errors.exceptions.BadCredentialsException;
import com.app.errors.exceptions.EntityNotFoundException;
import com.app.errors.exceptions.InvalidParametersException;
import com.app.errors.exceptions.UniqueEntityDuplicatedException;
import com.app.errors.exceptions.UsernameNotFoundException;

/** 
 * 
 * @Author Ing. Christhian Lugo Govea.
 */
@RestControllerAdvice
public class ResponseEntityExceptionHandlerImpl extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ BadCredentialsException.class })
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED )
    public GenericResponse<Object> handleBadCredentialsException(Exception ex, WebRequest request) {
    	return GenericResponse.error( ErrorMessages.ERROR_MESSAGE__AccessDenied );
    }
	
	@ExceptionHandler({ UsernameNotFoundException.class })
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED )
    public GenericResponse<Object> handleUsernameNotFoundException(Exception ex, WebRequest request) {
    	return GenericResponse.error( ErrorMessages.ERROR_MESSAGE__AccessDenied );
    }
	
	@ExceptionHandler({ EntityNotFoundException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public GenericResponse<Object> handleEntityNotFoundException(Exception ex, WebRequest request) {
    	return GenericResponse.error( ErrorMessages.ERROR_MESSAGE__EntityNotFound );
    }
	
	@ExceptionHandler({ UniqueEntityDuplicatedException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST )
    public GenericResponse<Object> handleUniqueEntityDuplicatedException(Exception ex, WebRequest request) {
    	return GenericResponse.error( ErrorMessages.ERROR_MESSAGE__UniqueEntityDuplicated );
    }
	
	@ExceptionHandler({ InvalidParametersException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST )
    public GenericResponse<Object> handleInvalidParametersException(Exception ex, WebRequest request) {
    	return GenericResponse.error( ex.getMessage() );
    }
	
	@ExceptionHandler({ AccessDeniedException.class })
	@ResponseStatus(value = HttpStatus.FORBIDDEN )
    public GenericResponse<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
    	return GenericResponse.error( ErrorMessages.ERROR_MESSAGE__AccessDenied );
    }
	
	@ExceptionHandler({ NullPointerException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR )
    public GenericResponse<Object> handleNullPointerExceptions(Exception e) {
		return GenericResponse.error( ErrorMessages.ERROR_MESSAGE__GeneralError );
    }
	
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR )
    public GenericResponse<Object> handleExceptions(Exception e) {
    	return GenericResponse.error( ErrorMessages.ERROR_MESSAGE__GeneralError );
    }
    
}
