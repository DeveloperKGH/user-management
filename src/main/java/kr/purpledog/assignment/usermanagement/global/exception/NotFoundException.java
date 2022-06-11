package kr.purpledog.assignment.usermanagement.global.exception;

import kr.purpledog.assignment.usermanagement.global.BaseException;
import lombok.Getter;

import java.util.Collections;

public class NotFoundException extends BaseException {

    @Getter
    public enum CauseCode {
        NOT_FOUND_MEMBER("4040000000");

        private String code;

        CauseCode(String code) {
            this.code = code;
        }

    }

    public NotFoundException(CauseCode cause, String message) {
        super(404, cause.getCode(), message, Collections.EMPTY_LIST);
    }

}