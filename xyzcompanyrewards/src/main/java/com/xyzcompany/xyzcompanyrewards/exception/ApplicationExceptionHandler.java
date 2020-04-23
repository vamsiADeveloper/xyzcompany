package com.xyzcompany.xyzcompanyrewards.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationExceptionHandler {
	private Log logger = LogFactory.getLog(ApplicationExceptionHandler.class);
	
	    @ExceptionHandler(ApplicationException.class)
	    public ResponseEntity<Object> handleMyException(ApplicationException mex) {
	    		logger.error(mex.getErrMsg());
	    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		        .body(mex.getErrMsg());
	    }
	 
	    @ExceptionHandler(Exception.class)
	    public ModelAndView handleException(Exception ex) {
	    		logger.error(ex.getCause());
	    		logger.error(ex.getLocalizedMessage());
	        ModelAndView model = new ModelAndView();
	        model.addObject("errMsg", "There has been a Technical failure, please contact support.");
	        model.setViewName("error");
	        return model;
	 
	    }
}
