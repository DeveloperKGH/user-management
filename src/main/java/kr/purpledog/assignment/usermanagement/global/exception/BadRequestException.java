package kr.purpledog.assignment.usermanagement.global.exception;

import kr.purpledog.assignment.usermanagement.global.BaseException;
import kr.purpledog.assignment.usermanagement.global.ErrorResult;

import java.util.Arrays;
import java.util.List;

public class BadRequestException extends BaseException {

	public BadRequestException(List<ErrorResult> errorResults) {
		super(400, "4000000000", "Bad Request", errorResults);
	}

	public BadRequestException(String field, String message) {
		this(Arrays.asList(new ErrorResult(field, message)));
	}

}