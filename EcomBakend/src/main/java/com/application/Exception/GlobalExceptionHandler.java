package com.application.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.application.Entities.OrderDetail;

 

@ControllerAdvice
public class GlobalExceptionHandler {
	
     //user defined Exception
	//cartException
		 @ExceptionHandler(OrderException.class)
		    public ResponseEntity<MyErrorDetails> cartExceptionHandler(OrderException ce, WebRequest req) {

		        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));

		        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
		    }
	
	//cartException
	 @ExceptionHandler(CartException.class)
	    public ResponseEntity<MyErrorDetails> cartExceptionHandler(CartException ce, WebRequest req) {

	        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));

	        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	    }

	//WishListException
	  @ExceptionHandler(WishListException.class)
	    public ResponseEntity<MyErrorDetails> wishListExceptionHandler(WishListException ce, WebRequest req) {

	        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));

	        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	    }
	
	//category Exception
	 
    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<MyErrorDetails> categoryExceptionHandler(CategoryException ce, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }
    
    //productException
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<MyErrorDetails> productExceptionHandler(ProductException ce, WebRequest req) {
    	
    	MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
    	
    	return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }
      
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest req) {
    	
    	MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
    	
    	return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }
    
    //possible exception handlers:

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<MyErrorDetails> noSuchMethodExceptionHandler(NoSuchMethodException nsme, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(nsme.getMessage());
        err.setErrorDetails(req.getDescription(false));


        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> noHandlerFoundExpHandler(NoHandlerFoundException nhfe, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nhfe.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException manve) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage("Validation Error!");
        err.setErrorDetails(manve.getBindingResult().getFieldError().getDefaultMessage());


        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


    //Generic exception handler:

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception e, WebRequest req) {

        MyErrorDetails error = new MyErrorDetails();
        error.setTimeStamp(LocalDateTime.now());
        error.setMessage(e.getMessage());
        error.setErrorDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);
    }

}
