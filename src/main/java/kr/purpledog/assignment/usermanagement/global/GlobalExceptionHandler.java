package kr.purpledog.assignment.usermanagement.global;

import kr.purpledog.assignment.usermanagement.global.exception.BadRequestException;
import kr.purpledog.assignment.usermanagement.global.exception.ConflictException;
import kr.purpledog.assignment.usermanagement.global.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BaseResponse handle400Exception(HttpServletRequest request, BadRequestException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(400, exception.getError(), exception.getMessage(), exception.getErrorResults());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public BaseResponse handle404Exception(HttpServletRequest request, NotFoundException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getStatus(), exception.getError(), exception.getMessage(), exception.getErrorResults());
	}

	@ExceptionHandler({ConflictException.class})
	@ResponseStatus(HttpStatus.CONFLICT)
	public BaseResponse handle409Exception(HttpServletRequest request, ConflictException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getStatus(), exception.getError(), exception.getMessage(), exception.getErrorResults());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public BaseResponse handle500Exception(Exception exception) {
		log.error("===============Print 500 Error===============");
		log.error("[ExceptionHandle] trace : {}", exception);
		log.error("=========================================");
		return BaseResponse.errorResponse(500, "INTERVAL_SERVER_ERROR", exception.getMessage(), Collections.EMPTY_LIST);
	}

	private void printError(HttpServletRequest request, BaseException exception) {
		log.error("===============PrintError===============");
		log.error("[ExceptionHandle] request-url: {}", request.getRequestURL());
		log.error("[ExceptionHandle] error: {}", exception.getError());
		log.error("[ExceptionHandle] message: {}", exception.getMessage());
		log.error("[ExceptionHandle] errorResults: {}", exception.getErrorResults());
		log.error("=========================================");

	}

}