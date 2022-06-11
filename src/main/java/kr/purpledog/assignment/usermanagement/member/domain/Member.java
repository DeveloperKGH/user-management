package kr.purpledog.assignment.usermanagement.member.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode
@DynamicUpdate
@AllArgsConstructor @NoArgsConstructor
@Builder
@ToString
@Getter
@Table(name = "member")
@Entity
public class Member {

    @Id
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    public void changePassword(String password) {
        this.password = password;
    }

}
