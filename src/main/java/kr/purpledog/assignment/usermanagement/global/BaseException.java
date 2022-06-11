package kr.purpledog.assignment.usermanagement.global;

import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BaseException extends RuntimeException {

    public int status;

    public String error;

    public String message;

    public List<ErrorResult> errorResults;

}
