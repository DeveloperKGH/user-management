package kr.purpledog.assignment.usermanagement.global;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ErrorResult {

	private String field;

	private String message;

}