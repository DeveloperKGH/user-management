package kr.purpledog.assignment.usermanagement.global.exception;

import kr.purpledog.assignment.usermanagement.global.BaseException;
import lombok.Getter;

import java.util.Collections;

public class ConflictException extends BaseException {

    @Getter
    public enum CauseCode {
        DUPLICATE("4090000000");

        private String code;

        CauseCode(String code) {
            this.code = code;
        }

    }

    public ConflictException(CauseCode cause, String message) {
        super(409, cause.getCode(), message, Collections.EMPTY_LIST);
    }

}