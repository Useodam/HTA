package com.sample.web.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

/*
 * @ControllerAdvice
 * 		- 여러 컨트롤러 클래스에서 공통으로 사용되는 기능이 정의된 클래스임을 나타내는 어노테이션
 * 		- 컨트롤러에서 사용된 공통기능이 구현된 메소드에는 아래의 어노테이션 중 하나가 붙는다
 * 		  @ExceptionHandler
 * 			+ 예외처리를 담당하는 메소드임을 나타내는 어노테이션이다
 * 			+ 예외처리 메소드와 매핑되는 예외클래스를 지정하면, 지정된 그 예외 및 그 하위 예외가 발생했을 때 실행된다
 * 			+ 발생한 예외를 처리할 수 있는 예외처리 메소드가 여러 개 일때는 발생한 예외와 그 가까운 예외가 정의된 예외처리 핸들러 메소드가 실행된다
 * 			+ 예외처리 핸들러 메소드는 매개변수를 통해서 발생한 예외를 전달받을 수 있다
 * 		  @InitBinder, 
 * 			+ 컨트롤러로 전달되는 요청 파라미터에 대한 추가적인 작업을 수행하는 메소드임을 나타내는 어노테이션이다
 * 		  @ModelAttribute 
 * 			+ 
 */
@ControllerAdvice
@Log4j2
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandle(DataAccessException ex) {
		log.error(ex.getMessage(), ex);
		return "error/db"; 
	}

//	@ExceptionHandler(Exception.class)
//	public String exceptionHandle(Exception ex) {
//		log.error(ex.getMessage(), ex);
//		return "error/server";
//	}
}
