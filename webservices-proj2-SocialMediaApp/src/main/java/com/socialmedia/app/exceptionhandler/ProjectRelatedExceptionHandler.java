package com.socialmedia.app.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ProjectRelatedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest wr)
	{
		GenericExceptionHandler handler=new GenericExceptionHandler(ex.getMessage(), new Date(),"ExceptionOccured");
	   return new ResponseEntity(handler, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity getspecificexception(Exception ex,WebRequest wr)
	{
		GenericExceptionHandler gc=new GenericExceptionHandler(ex.getMessage(), new Date(), "ExceptionDueToNoResourceFound");
		ResponseEntity res=new ResponseEntity(gc,HttpStatus.NOT_FOUND);
		return res;
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		GenericExceptionHandler gc=new GenericExceptionHandler("ValidationFailedDueToWrongParameters", new Date(),ex.getBindingResult().toString());
		ResponseEntity res=new ResponseEntity(gc,HttpStatus.BAD_REQUEST);
		return res;
	}
}
