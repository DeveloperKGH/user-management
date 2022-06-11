package kr.purpledog.assignment.usermanagement.member.repository;


import kr.purpledog.assignment.usermanagement.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
