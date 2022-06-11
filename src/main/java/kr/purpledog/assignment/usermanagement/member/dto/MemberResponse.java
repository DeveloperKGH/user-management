package kr.purpledog.assignment.usermanagement.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberResponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("password")
	private String password;
}
