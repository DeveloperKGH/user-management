package kr.purpledog.assignment.usermanagement.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.purpledog.assignment.usermanagement.member.domain.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor @NoArgsConstructor
@Builder
@Setter @Getter
@ToString
@EqualsAndHashCode
public class MemberRequest {

    @JsonProperty("id")
    @NotBlank(groups = {Create.class})
    private String id;

    @JsonProperty("password")
    @NotBlank(groups = {Create.class, ChangePassword.class})
    private String password;

    @JsonProperty("new_password")
    @NotBlank(groups = {ChangePassword.class})
    private String newPassword;

    //TODO : 매핑할 필드가 많아지면 별도의 Mapper 를 이용해서 매핑하자 ex : ModelMapper
    public Member toEntity() {
        return Member.builder()
                .id(id)
                .password(password)
                .build();
    }

    public interface Create {}
    public interface ChangePassword {}

}
