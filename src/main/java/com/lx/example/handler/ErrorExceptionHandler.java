package com.lx.example.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ErrorExceptionHandler.class);

	/**
	 * 统一异常处理
	 * 
	 * @param exception
	 *            
	 * @return
	 */
	@ExceptionHandler({ RuntimeException.class })
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(RuntimeException e) {
		logger.error(e.getMessage(), e);
		ModelAndView m = new ModelAndView();
		m.addObject("lxRuntimeException", e.getMessage());
		m.setViewName("error/5xx");
		return m;
	}

	/**
	 * 统一异常处理
	 * 
	 * @param e
	 *            
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(Exception e) {
		logger.error(e.getMessage(), e);
		ModelAndView m = new ModelAndView();
		m.addObject("lxException", e.getMessage());
		m.setViewName("error/500");
		return m;
	}

}
